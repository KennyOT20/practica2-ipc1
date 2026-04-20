/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Hunting.Controladores;

import com.mycompany.BackEnd.Hunting.JugadorHunting.JugadorHunting;
import com.mycompany.BackEnd.Hunting.TableroHunting.TableroHuntingBE;
import com.mycompany.FrontEnd.ModulosDeNavegacion.AvisarPartida;



/**
 *
 * @author Kenny
 */
public class Partida implements Runnable {
    
    private  TableroHuntingBE tablero;
    private AvisarPartida avisar;
    private boolean jugando;
    private Thread hilo;
    private boolean tiempoRestado;
    
    private final JugadorHunting jugador;
    private final int cantidadAciertos;
    private int tiempoInicial;
    private final int tiempoReducido;


    public Partida(  JugadorHunting jugador, int cantidadAciertos, int tiempoInicial, int tiempoReducido) {
 
        this.jugador = jugador;
        this.cantidadAciertos = cantidadAciertos;
        this.tiempoInicial = tiempoInicial;
        this.tiempoReducido = tiempoReducido;
        this.jugando = false;
    }
    
    public void iniciar(){
         this.tablero = new TableroHuntingBE();
         
        if(hilo == null || !hilo.isAlive()){
            jugando = true;
            hilo = new Thread(this);
            hilo.start();
        }
    }

    public void detener(){
        jugando = false;
    }

    @Override
    public void run() {
        while (jugando) {
            try {
                Thread.sleep(tiempoInicial);
            } catch (InterruptedException e) {
                break;
            }
            
            System.out.println("Tiempo actual: " + tiempoInicial);
            
            tablero.quitarPato();
            tablero.aleatorizarPato();
            
            if(avisar != null){
                avisar.actualizarFrontedn();
            }
        }
    }
    
    public boolean verificarPartidaPerdida(){
        int fallosConsecutivos = jugador.getFallosConsecutivos();
        if(fallosConsecutivos == 5){
            return true;
        } return false;
    }
    
    public boolean restarTiempos(){
        int aciertosConsecutivos = jugador.getAciertosConsecutivos();
        if(aciertosConsecutivos == cantidadAciertos){
            jugador.setAciertosConsecutivos(0);
            tiempoInicial = tiempoInicial - tiempoReducido;
            
            if(tiempoInicial <= 0){
                tiempoInicial = 1;
            }
            
            return tiempoRestado = true;
        } return tiempoRestado = false;
        
    }

    public void incrementarFallos(){
        jugador.incrementarFallos();
    }
    
    public void incrementarVecesSeguidas(){
        jugador.incrementarAciertos();
    }
    
    public void incrementarPatos(){
        jugador.incrementarPatos();
    }
    
    public void decrementarVecesSeguidas(){
        jugador.reiniciarAciertos();
    }
    
    public void incrementarFallosSeguidos(){
        jugador.incrementarFallosConsecutivos();
    }
    
    public void reiniciarFallos(){
        jugador.reiniciarFallos();
    }
    
    public void setAvisar(AvisarPartida avisar) {
        this.avisar = avisar;
    }

    public TableroHuntingBE getTablero() {
        return tablero;
    }

    public int getTiempoInicial() {
        return tiempoInicial;
    }

    public void setTiempoRestado(boolean tiempoRestado) {
        this.tiempoRestado = tiempoRestado;
    }
    
    
    
  
    
}