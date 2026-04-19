/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Hunting.TableroHunting;

/**
 *
 * @author Kenny
 */
public class Casilla {
    
    public boolean contienePato;
    
    public Casilla(){
        this.contienePato = false;
    }

    public boolean isContienePato() {
        return contienePato;
    }

    public void activarPato(){
        contienePato = true;
    }
    
    public void desactivarPato(){
        contienePato = false;
    }
    
    

}
