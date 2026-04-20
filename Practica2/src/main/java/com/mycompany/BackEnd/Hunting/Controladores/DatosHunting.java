/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Hunting.Controladores;

import com.mycompany.BackEnd.Hunting.JugadorHunting.JugadorHunting;

/**
 *
 * @author Kenny
 */
public class DatosHunting {
    
    private final JugadorHunting jugador;
    private  Partida partida;
    private int cantidadAciertos;
    private int tiempoInicial;
    private int tiempoReducido;

    public DatosHunting() {
        this.jugador = new JugadorHunting();
    }
    
    public void iniciarPartida(){
        this.partida = new Partida( this, jugador, cantidadAciertos, tiempoInicial, tiempoReducido);
    }
    
    public int getCantidadAciertos() {
        return cantidadAciertos;
    }

    public void setCantidadAciertos(int cantidadAciertos) {
        this.cantidadAciertos = cantidadAciertos;
    }

    public int getTiempoInicial() {
        return tiempoInicial;
    }

    public void setTiempoInicial(int tiempoInicial) {
        this.tiempoInicial = tiempoInicial;
    }

    public int getTiempoReducido() {
        return tiempoReducido;
    }

    public void setTiempoReducido(int tiempoReducido) {
        this.tiempoReducido = tiempoReducido;
    }

    public JugadorHunting getJugador() {
        return jugador;
    }

    public Partida getPartida() {
        return partida;
    }

    
    
}
