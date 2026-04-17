/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import com.mycompany.BackEnd.Memoria.Controladores.ControladorDatos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class VentanaJuego extends JPanel {
    
    private ControladorDatos controladorDatos;
    private TableroMemoria tablero;
    private final JButton botonSalir;
    private final JPanel panelSuperior;
    private final JPanel panelContenedorTablero;
    private final JLabel labelPunteoJug1;
    private final JLabel labelPunteoJug2;
    private final JLabel turnos;
    
    public VentanaJuego(PanelContenedorMemoria memoria){
        this.panelSuperior = new JPanel();
        this.panelContenedorTablero = new JPanel();
        this.botonSalir = new JButton();
        this.labelPunteoJug1 = new JLabel();
        this.labelPunteoJug2 = new JLabel();
        this.turnos = new JLabel();
        iniciarComponentes();
    }
    
   public void obtenerDatos(ControladorDatos datos){
        this.controladorDatos = datos;
        agregarTablero();
        configurarLabels();
        obtenerTurnos();
    }
  
   public void agregarTablero(){
        this.tablero = new TableroMemoria(controladorDatos);

        panelContenedorTablero.removeAll(); 
        panelContenedorTablero.add(tablero, BorderLayout.CENTER);

        panelContenedorTablero.revalidate();
        panelContenedorTablero.repaint();
    }
   
    private void iniciarComponentes(){
        this.setLayout(new BorderLayout()); 
        this.setBackground(Color.CYAN);
        
        botonSalir.setText("Salir");
        botonSalir.setFont(new Font("Arial", Font.BOLD, 30));
        botonSalir.setBackground(Color.PINK);

        configurarPanelSuperior();
        configurarPanelTablero();
    }
    
    private void configurarPanelSuperior(){

        panelSuperior.setPreferredSize(new Dimension(0, 120));
        panelSuperior.setBackground(Color.RED);
        panelSuperior.setLayout(new BorderLayout());

        panelSuperior.add(crearPanelJugadores(), BorderLayout.WEST);
        panelSuperior.add(turnos, BorderLayout.CENTER);
        panelSuperior.add(botonSalir, BorderLayout.EAST);

        this.add(panelSuperior, BorderLayout.NORTH);
    }
    
    private JPanel crearPanelJugadores(){
        JPanel panelJugadores = new JPanel();
        panelJugadores.setLayout(new GridLayout(2, 1));
        panelJugadores.setOpaque(false); 

        panelJugadores.add(labelPunteoJug1);
        panelJugadores.add(labelPunteoJug2);

        return panelJugadores;
    }
    
    private void configurarPanelTablero(){
        panelContenedorTablero.setLayout(new BorderLayout());
        this.add(panelContenedorTablero, BorderLayout.CENTER);
    }
    
    private void configurarLabels(){
        String nombreJugador1 = controladorDatos.getJugador1().getNombreJugador();
        String nombreJugador2 = controladorDatos.getJugador2().getNombreJugador();

        int punteoJugador1 = controladorDatos.getJugador1().getPuntosMemoria();
        int punteoJugador2 = controladorDatos.getJugador2().getPuntosMemoria();

        labelPunteoJug1.setText("Puntos de " + nombreJugador1 + " : " + punteoJugador1);
        labelPunteoJug2.setText("Puntos de " + nombreJugador2 + " : " + punteoJugador2);
        
        labelPunteoJug1.setHorizontalAlignment(JLabel.CENTER);
        labelPunteoJug2.setHorizontalAlignment(JLabel.CENTER);
        turnos.setHorizontalAlignment(JLabel.CENTER);
        
        labelPunteoJug1.setFont(new Font("Arial", Font.BOLD, 25));
        labelPunteoJug2.setFont(new Font("Arial", Font.BOLD, 25));
        turnos.setFont(new Font("Arial", Font.BOLD, 30));

        labelPunteoJug1.setForeground(Color.WHITE);
        labelPunteoJug2.setForeground(Color.WHITE);
        turnos.setForeground(Color.YELLOW);
    }
    
    private void obtenerTurnos(){
        turnos.setFont(new Font("Arial", Font.BOLD, 35));
        
        String jugadorEnTurno = " ";
        
        if(controladorDatos.getJugador1().isTurno() == true){
            jugadorEnTurno = controladorDatos.getJugador1().getNombreJugador();
        } else if(controladorDatos.getJugador2().isTurno() == false){
            jugadorEnTurno = controladorDatos.getJugador2().getNombreJugador();
        }
         turnos.setText("Turno de: " + jugadorEnTurno);

    }
    
}
