/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import com.mycompany.FrontEnd.FrontendPrincipal.VentanaPrincipal;
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
public class MenuMemoria extends JPanel {
    
    private final VentanaPrincipal ventanaPrincipal;
    private final JPanel panelBotones;
    private final JButton botonJuego;
    private final JButton botonReportes;
    private final JButton botonAcercaDe;
    private final JButton botonAyuda;
    private final JButton botonSalir;
    private final JLabel labelTitulo;
    
    public MenuMemoria(VentanaPrincipal ventanaPrincipal){
        this.panelBotones = new JPanel();
        this.botonAcercaDe = new JButton();
        this.botonAyuda = new JButton();
        this.botonSalir = new JButton();
        this.botonJuego = new JButton();
        this.botonReportes = new JButton();
        this.labelTitulo = new JLabel();
        this.ventanaPrincipal = ventanaPrincipal;
        
        iniciarPanel();
        ajustarBotones();
        colocarBotones();
        
        accionesBoton();
    }
    
    private void iniciarPanel(){
        labelTitulo.setText("MENU DE MEMORIA");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 72));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        this.setForeground(Color.darkGray);
        this.setLayout(new BorderLayout());
    }
    
    private void colocarBotones(){
        editarTextoBotones();
        editarComponenteBotones();
        editarColoresBotones();
        
        panelBotones.add(botonJuego);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));
        
        panelBotones.add(botonAyuda);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));
        
        panelBotones.add(botonReportes);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));
        
        panelBotones.add(botonAcercaDe);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));
        
        panelBotones.add(botonSalir);
    }
    
    private void editarTextoBotones(){
        botonAcercaDe.setText("ACERCA DE...");
        botonSalir.setText("SALIR");
        botonAyuda.setText("AYUDA");
        botonReportes.setText("REPORTES");
        botonJuego.setText("INICIAR JUEGO");
    }
    
     private void editarComponenteBotones(){
        botonJuego.setFont(new Font("Arial", Font.BOLD, 30));
        botonAyuda.setFont(new Font("Arial", Font.BOLD, 30));
        botonAcercaDe.setFont(new Font("Arial", Font.BOLD, 30));
        botonReportes.setFont(new Font("Arial", Font.BOLD, 30));
        botonSalir.setFont(new Font("Arial", Font.BOLD, 30));
        
        botonJuego.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonAyuda.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonAcercaDe.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonReportes.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        botonJuego.setMaximumSize(new Dimension(300, 60));
        botonAcercaDe.setMaximumSize(new Dimension(300, 60));
        botonAyuda.setMaximumSize(new Dimension(300, 60));
        botonReportes.setMaximumSize(new Dimension(300, 60));
        botonSalir.setMaximumSize(new Dimension(300, 60));
    }
     
     private void editarColoresBotones(){
        botonJuego.setBackground(Color.GREEN);
        botonReportes.setBackground(Color.CYAN);
        botonAyuda.setBackground(Color.BLUE);
        botonAcercaDe.setBackground(Color.GRAY);
        botonSalir.setBackground(Color.red);
    }
     
     private void ajustarBotones(){
         JPanel contenedor = new JPanel(new GridBagLayout());
         
        panelBotones.setBackground(Color.GREEN);
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.add(Box.createRigidArea(new Dimension(0 , 20)));
        contenedor.add(panelBotones);
        contenedor.setBackground(Color.GREEN);
        this.add(contenedor, BorderLayout.CENTER);
         
     }
     
     private void accionesBoton(){
        botonJuego.addActionListener( e -> ventanaPrincipal.mostrarPaneles("INICIO MEMORIA"));
        botonSalir.addActionListener(e -> ventanaPrincipal.mostrarPaneles("MENU INICIAL"));
     }
   
    
}
