/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Hunting.TableroHunting;

import java.util.Random;

/**
 *
 * @author Kenny
 */
public class TableroHunting {
    
    private final Casilla[][] tablero;
    private int coordenadaX;
    private int coordenadaY;
    private final int filas;
    private final int columnas;

    public TableroHunting() {
        this.filas = 30;
        this.columnas = 30;
        this.tablero = new Casilla[filas][columnas];
        
        llenarArreglo();
    }
    
    private void llenarArreglo(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = new Casilla();
            }
        }
    }
    
    public void aleatorizarPato(){
        Random random = new Random();
        
        coordenadaX = random.nextInt(filas);
        coordenadaY = random.nextInt(columnas);
        
        tablero[coordenadaX][coordenadaY].activarPato();
    }
    
    public void quitarPato(){
        tablero[coordenadaX][coordenadaY].desactivarPato();
        tablero[coordenadaX][coordenadaY] = null;
    }
    
    
}
