/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class VentanaJuegoMemoria extends JPanel {
    
    
    public VentanaJuegoMemoria(PanelContenedorMemoria memoria){
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        this.setForeground(Color.CYAN);
    }
    
    
}
