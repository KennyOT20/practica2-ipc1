/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Memoria.Tablero;


/**
 *
 * @author Kenny
 */
public class Carta {
    
    private boolean estaVolteada;
    private int codigoCarta;
    private int cantidadDeCartas;
    
    public Carta(){
     
    }
    
    /**
     * Metodo encargado de de crear los codigo de las cartas hasta que se le ponga un limite
     * @param limiteDePares recibe el maximo de parejas de las cartas 5, 10, 15
     * @return 
     */
    public int[] generarCodigo(int limiteDePares){
       
      int [] codigos = new int[limiteDePares * 2];
      int indice = 0;
      
        for (int i = 1; i <= limiteDePares; i++) {
            codigos[indice ++ ] = i;
            codigos[indice ++] = i;
        }
      
        return codigos;
        
    }
      
        
}
