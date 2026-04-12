/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import com.mycompany.FrontEnd.FrontendPrincipal.VentanaPrincipal;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class InterfazMemoria extends JPanel {
    
    private final VentanaPrincipal ventanaInicial;
    
    public InterfazMemoria(VentanaPrincipal ventanaInicial){
        this.ventanaInicial = ventanaInicial;
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        this.setForeground(Color.CYAN);
    }
    
    
}
