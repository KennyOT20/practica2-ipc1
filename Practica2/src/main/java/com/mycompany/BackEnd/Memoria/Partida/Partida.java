/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Memoria.Partida;

import com.mycompany.BackEnd.Jugador.Jugador;
import com.mycompany.BackEnd.Memoria.Tablero.Tablero;
import java.util.Random;

/**
 *
 * @author Kenny
 */
public class Partida {
    
    private boolean turnos;
    
    private final Jugador jugador1;
    private final Jugador jugador2;
    private final Tablero tablero;
    
    public Partida(Jugador jugador1, Jugador jugador2, Tablero tablero){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        
        iniciarPartida();
    }
    
    private void iniciarPartida(){
        Random random = new Random();
        turnos = random.nextBoolean();
        
        if(turnos == true){
            jugador1.setTurno(turnos);
        } else {
            jugador2.setTurno(turnos);
        }
    }
    
    public void obtenerEstadoPartida(){
        
    }
    
}
