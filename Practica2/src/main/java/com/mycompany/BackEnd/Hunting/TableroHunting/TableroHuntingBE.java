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
public class TableroHuntingBE {
    
    private final Casilla[][] tablero;
    private int coordenadaX;
    private int coordenadaY;
    private final int filas;
    private final int columnas;

    public TableroHuntingBE() {
        this.filas = 10;
        this.columnas = 10;
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
        if(tablero[coordenadaX][coordenadaY].isContienePato()){
             tablero[coordenadaX][coordenadaY].desactivarPato();
    }
        
    }
    
    public boolean acertar(int x, int y){
        if(tablero[x][y].isContienePato()){
            tablero[x][y].desactivarPato();
            return true; 
        }
        return false; 
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public Casilla[][] getTablero() {
        return tablero;
    }
    
    
    
    
}
