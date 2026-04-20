/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Hunting;

import com.mycompany.BackEnd.Hunting.Controladores.DatosHunting;
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
public class PanelJuego extends JPanel {
    
    private final JPanelContenedorHunting panelContenedor;
    private final JPanel panelSuperior;
    private final JPanel panelContenedorTablero;
    private JPanel panelInfo;
    private JLabel labelInfo;
    private JLabel info2;
    private final JLabel labelAciertos;
    private final JLabel labelFallos;
    private final JLabel labelFallosConsecutivos;
    
    private final JButton botonSalir;
    
    private TableroHunting tablero;
    private DatosHunting datosHunting;
    
    public PanelJuego(JPanelContenedorHunting panelContenedor){
        this.panelContenedor = panelContenedor;
        this.panelSuperior = new JPanel();
        this.panelContenedorTablero = new JPanel();
        
        this.labelAciertos = new JLabel();
        this.labelFallos = new JLabel();
        this.labelFallosConsecutivos = new JLabel();
        
        this.botonSalir = new JButton();
        
        iniciarComponentes();
        accionSalir();
      
    }
    
    public void iniciarDatos(DatosHunting datos){
        this.datosHunting = datos;
        agregarTablero();
        configurarLabels();
        actualizarLabels();
        tablero.iniciarJuego();
    }
    
    private void iniciarComponentes(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GREEN);
        
        botonSalir.setText("Salir");
        botonSalir.setFont(new Font("Arial", Font.BOLD, 25));
        botonSalir.setBackground(Color.PINK);
        
        configurarPanelSuperior();
        configurarPanelTablero();
        inicializarPanelInfo();
    }
    
    private void configurarPanelSuperior(){
        
        panelSuperior.setPreferredSize(new Dimension(0, 120));
        panelSuperior.setBackground(Color.BLACK);
        panelSuperior.setLayout(new BorderLayout());
        
        panelSuperior.add(crearPanelEstadisticas(), BorderLayout.CENTER);
        panelSuperior.add(botonSalir, BorderLayout.EAST);
        
        this.add(panelSuperior, BorderLayout.NORTH);
    }
    
    private JPanel crearPanelEstadisticas(){
        JPanel panelStats = new JPanel();
        panelStats.setLayout(new GridLayout(3, 1));
        panelStats.setOpaque(false);
        
        panelStats.add(labelAciertos);
        panelStats.add(labelFallos);
        panelStats.add(labelFallosConsecutivos);
        
        return panelStats;
    }
    
    private void configurarPanelTablero(){
        panelContenedorTablero.setLayout(new BorderLayout());
        this.add(panelContenedorTablero, BorderLayout.CENTER);
    }
    
    private void agregarTablero(){
        this.tablero = new TableroHunting(datosHunting, this);
        
        panelContenedorTablero.removeAll();
        panelContenedorTablero.add(tablero, BorderLayout.CENTER);
        
        panelContenedorTablero.revalidate();
        panelContenedorTablero.repaint();
    }
    
    private void configurarLabels(){
        
        labelAciertos.setHorizontalAlignment(JLabel.CENTER);
        labelFallos.setHorizontalAlignment(JLabel.CENTER);
        labelFallosConsecutivos.setHorizontalAlignment(JLabel.CENTER);
        
        labelAciertos.setFont(new Font("Arial", Font.BOLD, 22));
        labelFallos.setFont(new Font("Arial", Font.BOLD, 22));
        labelFallosConsecutivos.setFont(new Font("Arial", Font.BOLD, 22));
        
        labelAciertos.setForeground(Color.WHITE);
        labelFallos.setForeground(Color.WHITE);
        labelFallosConsecutivos.setForeground(Color.YELLOW);
    }
    
    public final void actualizarLabels(){
        labelAciertos.setText("Tiros acertados: " + datosHunting.getJugador().getPatosAcertados());
        labelFallos.setText("Tiros fallados: " + datosHunting.getJugador().getTirosFallados());
        labelFallosConsecutivos.setText("Fallos consecutivos: " + datosHunting.getJugador().getFallosConsecutivos());
    }
    
    public void mostrarLabelResta(){

        info2.setText("La velocidad baja a " + datosHunting.getPartida().getTiempoInicial());

        panelSuperior.revalidate();
        panelSuperior.repaint();
    }
    
    private void inicializarPanelInfo(){

        labelInfo = new JLabel("Turnos acertados consecutivos");
        info2 = new JLabel();

        labelInfo.setForeground(Color.WHITE);
        info2.setForeground(Color.WHITE);

        panelInfo = new JPanel(new GridLayout(2,1));
        panelInfo.setOpaque(false);

        panelInfo.add(labelInfo);
        panelInfo.add(info2);

        panelSuperior.add(panelInfo, BorderLayout.WEST);
    }

    private void accionSalir(){
        botonSalir.addActionListener(e ->{
            datosHunting.getPartida().detener();
            
            panelContenedor.irAMenuInicial();
        });
        
    }
    
    public TableroHunting getTablero() {
        return tablero;
    }

    public JPanelContenedorHunting getPanelContenedor() {
        return panelContenedor;
    }
    
    
    
    
    
    }

