/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Memoria.Tablero;

import java.util.Random;

/**
 *
 * @author Kenny
 */
public class Tablero {
    
    private final Carta[][] tablero;
    private int cantidadFilas;
    private int cantidadColumnas;
    private int cantidadCartas;

    public Tablero(int cantidadFilas, int cantidadColumnas){
        this.cantidadFilas = cantidadFilas;
        this.cantidadColumnas = cantidadColumnas;
        this.cantidadCartas = cantidadFilas * cantidadColumnas;
        this.tablero = new Carta[cantidadFilas][cantidadColumnas];

        agregarCodigo();
        mezclarCartas();
    }
    
    /**
     * Metodo encargado de crear ub codigo especifico para dos carta,s esta encargado de poder buscarle
     * los pares.
     */
    private void agregarCodigo(){
        
        int codigo = 1;
        int contador = 0;
        
        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j < cantidadColumnas; j++) {
                tablero[i][j] = new Carta();
                tablero[i][j].setCodigoCarta(codigo);
                contador ++;
                
                if(contador == 2){
                    codigo  ++;
                    contador = 0;
                }
            }

        }
        
    }

    private void mezclarCartas(){
        Random random = new Random();
        
        for (int i = 0; i < cantidadFilas; i++) {
            for (int j = 0; j < cantidadColumnas; j++) {
                int fila = random.nextInt(cantidadFilas);
                int columna = random.nextInt(cantidadColumnas);
                
                Carta carta = tablero[i][j];
                tablero[i][j] = tablero[fila][columna];
                tablero[fila][columna] = carta;
            }
        }
        
    }
    
    
}
