/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Memoria.Partida;

import com.mycompany.BackEnd.Jugador.Jugador;
import com.mycompany.BackEnd.Memoria.Tablero.Tablero;

/**
 *
 * @author Kenny
 */
public class Partida {
    
    private final Jugador jugador1;
    private final Jugador jugador2;
    private final Tablero tablero;
    
    public Partida(Jugador jugador1, Jugador jugador2, Tablero tablero){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
    }
    
    public void obtenerEstadoPartida(){
        
    }
    
}
