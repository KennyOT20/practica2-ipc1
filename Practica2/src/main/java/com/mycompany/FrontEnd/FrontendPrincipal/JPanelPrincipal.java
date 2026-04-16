/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.FrontendPrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class JPanelPrincipal extends JPanel {
    
    private final VentanaPrincipal ventanaPrincipal;
    private final JPanel panelBotones;
    private final JLabel labelTitulo;
    private final JButton botonMemoria;
    private final JButton botonHunting;
    private final JButton botonReportes;
    private final JButton botonSalir;
    
    
    
    public JPanelPrincipal(VentanaPrincipal ventanaPrincipal){
        this.panelBotones = new JPanel();
        this.labelTitulo = new JLabel();
        this.botonMemoria = new JButton();
        this.botonHunting = new JButton();
        this.botonReportes = new JButton();
        this.botonSalir = new JButton();
        this.ventanaPrincipal = ventanaPrincipal;
        
        iniciarComponentes();
        colocarTitulo();
        colocarPanelBotones();
        agregarBotones();
        
        accionMemoria();
        accionHunting();
        accionReportes();
        accionSalir();
    }
    
    private void iniciarComponentes(){
        this.setBackground(Color.RED);
        this.setLayout(new BorderLayout());
    }
    
    private void colocarTitulo(){
        labelTitulo.setBackground(Color.red);
        labelTitulo.setText(" LIBRERIA DE JUEGOS ");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 72));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        this.add(labelTitulo, BorderLayout.NORTH);
    }
    
    private void agregarBotones(){
        editarTextoBotones();
        editarComponenteBotones();
        editarColoresBotones();

        panelBotones.add(botonMemoria);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));

        panelBotones.add(botonHunting);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));

        panelBotones.add(botonReportes);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));

        panelBotones.add(botonSalir);
    }
    
    private void editarTextoBotones(){
        botonMemoria.setText("MEMORIAS");
        botonHunting.setText("HUNTING");
        botonReportes.setText("REPORTES");
        botonSalir.setText("SALIR");
    }
    
    private void editarComponenteBotones(){
        botonMemoria.setFont(new Font("Arial", Font.BOLD, 30));
        botonHunting.setFont(new Font("Arial", Font.BOLD, 30));
        botonReportes.setFont(new Font("Arial", Font.BOLD, 30));
        botonSalir.setFont(new Font("Arial", Font.BOLD, 30));
        
        botonMemoria.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonHunting.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonReportes.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        botonMemoria.setMaximumSize(new Dimension(300, 60));
        botonHunting.setMaximumSize(new Dimension(300, 60));
        botonReportes.setMaximumSize(new Dimension(300, 60));
        botonSalir.setMaximumSize(new Dimension(300, 60));
    }
    
    private void colocarPanelBotones(){
        JPanel panelContenedorBotones = new JPanel(new GridBagLayout());
        
        panelBotones.setBackground(Color.pink);
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.add(Box.createRigidArea(new Dimension(0 , 20)));
        panelContenedorBotones.add(panelBotones);
        panelContenedorBotones.setBackground(Color.PINK);
        this.add(panelContenedorBotones, BorderLayout.CENTER);
    }
    
    private void editarColoresBotones(){
        botonHunting.setBackground(Color.YELLOW);
        botonReportes.setBackground(Color.white);
        botonMemoria.setBackground(Color.GRAY);
        botonSalir.setBackground(Color.red);
    }
    
    private void accionMemoria(){
        
        botonMemoria.addActionListener(e -> {
                ventanaPrincipal.irAMemorias();
                ventanaPrincipal.setTitle("Memorias");
        } );
       
    }
    
    private void accionHunting(){
        
    }
    
    private void accionReportes(){
        
    }
    
    private void accionSalir(){
        botonSalir.addActionListener(e -> System.exit(0));
    }
    
   
    
    
}
