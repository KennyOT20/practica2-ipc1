/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import com.mycompany.BackEnd.Memoria.Controladores.ControladorDatos;
import com.mycompany.FrontEnd.FrontendPrincipal.VentanaPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kenny
 */
public class PanelDatos extends JPanel {
    
    private final ControladorDatos obtenerNombres;
    private final JLabel nombreJugador1;
    private final JLabel nombreJugador2;
    private final JTextField datoJugador1;
    private final JTextField datoJugador2;
    private final JButton botonIniciar;
    private final JButton botonRegresar;

    public PanelDatos(PanelContenedorMemoria memoria){
        this.nombreJugador1 = new JLabel();
        this.nombreJugador2 = new JLabel();
        this.datoJugador1 = new JTextField();
        this.datoJugador2 = new JTextField();
        this.botonIniciar = new JButton();
        this.botonRegresar = new JButton();
        this.obtenerNombres  = new ControladorDatos();
        
        iniciarComponentes();
        colocarComponentes();
    }
    
    private void iniciarComponentes(){
       
    }
    
    private void editarLabels(){
        BorderLayout borderLayout = new BorderLayout();
        
        nombreJugador1.setText("Nombre de jugador 1: ");
        nombreJugador2.setText("Nombre de jugador 2: ");
       
        nombreJugador1.setBackground(Color.red);
        nombreJugador2.setBackground(Color.blue);
        
        nombreJugador1.setLayout(borderLayout);
        nombreJugador2.setLayout(borderLayout);
        
        nombreJugador1.setFont(new Font(("Arial"), Font.BOLD, 38));
        nombreJugador2.setFont(new Font("Arial", Font.BOLD, 38));
    }
    
    private void editarTextFields(){
        datoJugador1.setBackground(Color.white);
        datoJugador2.setBackground(Color.WHITE);
    }
    
    private void colocarComponentes(){
        editarLabels();
        editarTextFields();
        
        this.add(nombreJugador1, BorderLayout.SOUTH);
        this.add(nombreJugador2, BorderLayout.EAST);
    }
    
    
}
