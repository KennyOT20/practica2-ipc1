/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Jugador;

/**
 *
 * @author Kenny
 */
public class Jugador {
   
    private boolean turno;
    private String nombreJugador;
    private int puntosMemoria;
   
    public void iniciarEstadisticasMemoria(){
        puntosMemoria = 50;
    }

    public int getPuntosMemoria() {
        return puntosMemoria;
    }

    public void setPuntosMemoria(int puntosMemoria) {
        this.puntosMemoria = puntosMemoria;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    
    
    
}
