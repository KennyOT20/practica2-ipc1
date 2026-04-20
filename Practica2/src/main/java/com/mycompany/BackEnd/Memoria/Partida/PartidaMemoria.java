/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Memoria.Partida;

import com.mycompany.BackEnd.Memoria.Jugador.Jugador;
import com.mycompany.BackEnd.Memoria.Reportes.ReportesMemoria;
import com.mycompany.BackEnd.Memoria.Tablero.Carta;
import com.mycompany.BackEnd.Memoria.Tablero.Tablero;
import java.util.Random;

/**
 *
 * @author Kenny
 */
public class PartidaMemoria {
    
    private boolean turnos;
    private Random random;
    private  Jugador jugador1;
    private Carta carta1;
    private Carta carta2;
    
    private int contadorPares = 0;
    
    private  Jugador jugador2;
    private final Tablero tablero;
    
    public PartidaMemoria(Jugador jugador1, Jugador jugador2, Tablero tablero){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        this.random = new Random();
        
        iniciarPartida();
    }
    
    private void iniciarPartida(){
        turnos = random.nextBoolean();
    }
    
    private void cambiarTurno(){
        turnos =! turnos;
    }
    
    public boolean obtenerEstadoPartida(){

        int totalCartas = tablero.getCantidadFilas() * tablero.getCantidadColumnas();
        int totalPares = totalCartas / 2;

        int paresEncontrados = tablero.getCantidadPares(); 

        return paresEncontrados == totalPares;
    }
    
   public void obtenerCartas(Carta cartaObtenida) {

        if (carta1 == null) {
            carta1 = cartaObtenida;
        } 
        else if (carta2 == null && cartaObtenida != carta1) {
            carta2 = cartaObtenida;
        }
    }
    
    public void resetearCartas(){
        carta1 = null;
        carta2 = null;
        contadorPares = 0;
    }
    
    public void cartasArriba(){
        System.out.println("Cartas arriba");
        carta1.voltearCartaArriba();
        System.out.println(carta1.getCodigoCarta());
        System.out.println(carta2.getCodigoCarta());
        carta2.voltearCartaArriba();
    }
    
    public void cartasAbajo(){
        System.out.println("Cartas abajo");
        System.out.println(carta1.getCodigoCarta());
        System.out.println(carta2.getCodigoCarta());
        carta1.voltearCartaAbajo();
        carta2.voltearCartaAbajo();
    }
    
    
    public boolean compararCartas() {
        if(carta1.getCodigoCarta() == carta2.getCodigoCarta()){
            return true;
        } else {
            return false;
        }
        
    }
    
    public  void darRecompensas(boolean sonPares){
        
        if(sonPares){
            darPunteo();
        } else {
            quitarPunteo();
            cambiarTurno();
        }
                
    }
    
    public void mandarReportes(){
        ReportesMemoria reportes = new ReportesMemoria();
        
        if(jugador1.getPuntosMemoria() > jugador2.getPuntosMemoria()){
            reportes.obtenerGanador(jugador1);
            reportes.obtenerPerdedor(jugador2);
        } else {
            reportes.obtenerGanador(jugador2);
            reportes.obtenerPerdedor(jugador1);
        }
        
        reportes.guardarPartida();
    }
    
    private void darPunteo(){
        contadorPares ++;
        tablero.setCantidadPares(tablero.getCantidadPares() + contadorPares);
        if(turnos ){
            jugador1.incremetarPunteo();
            System.out.println("punteo 1" + jugador1.getPuntosMemoria());
        } else {
            jugador2.incremetarPunteo();
            System.out.println("punteo 2" + jugador2.getPuntosMemoria());
        }
    }
    
    private void quitarPunteo(){
        if(turnos ){
            jugador1.decrementarPunteo();
        } else {
            jugador2.decrementarPunteo();
        }
    }
    
    public Jugador obtenerGanador(){
        if(jugador1.getPuntosMemoria() > jugador2.getPuntosMemoria()){
            return jugador1;
        } else if(jugador2.getPuntosMemoria() > jugador1.getPuntosMemoria()){
            return jugador2;
        } else {
            return null;
        }
        
    }
    
    public void resetearPartida(){
        jugador1 = null;
        jugador2 = null;
        contadorPares = 0;
    }
    
    public Carta getCarta1() {
        return carta1;
    }

    public Carta getCarta2() {
        return carta2;
    }

    public boolean isTurnos() {
        return turnos;
    }
    
}
