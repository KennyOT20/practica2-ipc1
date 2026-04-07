/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Memoria.Tablero;

/**
 *
 * @author Kenny
 */
public class Tablero {
    
    private final Carta[][] tablero;
    private int cantidadFilas;
    private int cantidadColumnas;

    public Tablero() {
        this.tablero =  new Carta[cantidadFilas][cantidadColumnas];
    }

    public int getCantidadFilas() {
        return cantidadFilas;
    }

    public void setCantidadFilas(int cantidadFilas) {
        this.cantidadFilas = cantidadFilas;
    }

    public int getCantidadColumnas() {
        return cantidadColumnas;
    }

    public void setCantidadColumnas(int cantidadColumnas) {
        this.cantidadColumnas = cantidadColumnas;
    }
    
    
    
}
