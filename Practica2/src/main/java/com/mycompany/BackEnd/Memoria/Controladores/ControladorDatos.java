/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Memoria.Controladores;

import com.mycompany.BackEnd.Jugador.Jugador;

/**
 *
 * @author Kenny
 */
public class ControladorDatos {
    
    private ConstructorPartida controladorPartida;
    private final Jugador jugador1;
    private final Jugador jugador2;
    private String dificultad;
    
    public ControladorDatos(){
        this.jugador1 = new Jugador();
        this.jugador2 = new Jugador();
    }
    
    public void construirPartida(){
        this.controladorPartida = new ConstructorPartida(jugador1, jugador2, dificultad);
    }
    
    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getDificultad() {
        return dificultad;
    }

    public ConstructorPartida getControladorPartida() {
        return controladorPartida;
    }
    
    
    
    
    
}
