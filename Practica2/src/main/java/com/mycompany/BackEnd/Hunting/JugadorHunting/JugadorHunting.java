/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Hunting.JugadorHunting;

/**
 *
 * @author Kenny
 */
public class JugadorHunting {
    
    private String nombreJugadorHunting;
    private int patosAcertados;
    private int fallosConsecutivos;
    private int aciertosConsecutivos;
    private int tirosFallados;

    public void incrementarAciertos(){
        aciertosConsecutivos ++;
    }
    
    public void incrementarFallos(){
        tirosFallados ++;
    }
    
    public void reiniciarAciertos(){
        aciertosConsecutivos = 0;
    }
    
    public void incrementarFallosConsecutivos(){
        fallosConsecutivos ++;
    }
    
    public void reiniciarFallos(){
        fallosConsecutivos = 0;
    }
    
    public void tirosFallados(){
        tirosFallados++;
    }
    
    public void incrementarPatos(){
        patosAcertados ++;
    }
    
    public String getNombreJugadorHunting() {
        return nombreJugadorHunting;
    }

    public void setNombreJugadorHunting(String nombreJugadorHunting) {
        this.nombreJugadorHunting = nombreJugadorHunting;
    }

    public int getPatosAcertados() {
        return patosAcertados;
    }

    public void setPatosAcertados(int patosAcertados) {
        this.patosAcertados = patosAcertados;
    }

    public int getFallosConsecutivos() {
        return fallosConsecutivos;
    }

    public void setFallosConsecutivos(int fallosConsecutivos) {
        this.fallosConsecutivos = fallosConsecutivos;
    }

    public int getAciertosConsecutivos() {
        return aciertosConsecutivos;
    }

    public void setAciertosConsecutivos(int aciertosConsecutivos) {
        this.aciertosConsecutivos = aciertosConsecutivos;
    }

    public int getTirosFallados() {
        return tirosFallados;
    }

    public void setTirosFallados(int tirosFallados) {
        this.tirosFallados = tirosFallados;
    }

    
    
    
    
    
}
