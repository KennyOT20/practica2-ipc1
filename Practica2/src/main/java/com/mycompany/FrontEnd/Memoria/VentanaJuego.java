/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import com.mycompany.BackEnd.Memoria.Controladores.ControladorDatos;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class VentanaJuego extends JPanel {
    
    private ControladorDatos controladorDatos;
    
    private final JPanel panelContenedorTablero;
    private final JLabel labelPunteoJug1;
    private final JLabel labelPunteoJug2;
    
    public VentanaJuego(PanelContenedorMemoria memoria){
        this.panelContenedorTablero = new JPanel();
        this.labelPunteoJug1 = new JLabel();
        this.labelPunteoJug2 = new JLabel();
        iniciarComponentes();
    }
    
    public void obtenerDatos(ControladorDatos datos){
        this.controladorDatos = datos;
    }
    
    private void iniciarComponentes(){
        this.setForeground(Color.CYAN);
        this.setLayout(null);
    }
    
    
}
