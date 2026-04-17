/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Memoria.Controladores;

import com.mycompany.BackEnd.Jugador.Jugador;
import com.mycompany.BackEnd.Memoria.Partida.Partida;
import com.mycompany.BackEnd.Memoria.Tablero.Tablero;

/**
 *
 * @author Kenny
 */
public class ConstructorPartida {
   
    private Tablero tablero;
    private final Jugador jugador1;
    private final Jugador jugador2;
    private int cantidadFilas;
    private int cantidadColumnas;
    private String dificultad;
    private Partida partida;
    
    public ConstructorPartida(Jugador jugador1, Jugador jugador2, String dificultad){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.partida = new Partida(jugador1, jugador2, tablero);
        this.dificultad = dificultad.toUpperCase();
        
        
        obtenerTamañoTablero();
        this.tablero = new Tablero(cantidadFilas, cantidadColumnas);
    }
 
    private void obtenerTamañoTablero(){
        
        switch(dificultad){
            case "FACIL" :
                cantidadFilas = 2;
                cantidadColumnas = 5;
                break;
            case "MEDIO":
                cantidadFilas = 4;
                cantidadColumnas = 5;
                break;
            case "DIFICIL" :
                cantidadFilas = 5;
                cantidadColumnas = 6;
                break;
            default:
                cantidadFilas = 2;
                cantidadColumnas = 5;
                break;
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    
    
}
