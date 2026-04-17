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
    
    private String rutaDeImagenes;
    private boolean estaVolteada;
    private int codigoCarta;
    
    public Carta(){
        this.estaVolteada = false;
        this.codigoCarta = 0;
    }
    
    public boolean isEstaVolteada() {
        return estaVolteada;
    }

    public void setEstaVolteada(boolean estaVolteada) {
        this.estaVolteada = estaVolteada;
    }

    public int getCodigoCarta() {
        return codigoCarta;
    }

    public void setCodigoCarta(int codigoCarta) {
        this.codigoCarta = codigoCarta;
    }

    public String getRutaDeImages() {
        return rutaDeImagenes;
    }

    public void setRutaDeImages(String rutaDeImages) {
        this.rutaDeImagenes = rutaDeImages;
    }
    
    

}
