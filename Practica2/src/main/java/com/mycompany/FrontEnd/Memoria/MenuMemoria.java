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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Kenny
 */
public class MenuMemoria extends JPanel {
    
    private final PanelContenedorMemoria panelContenedor;
    private final VentanaPrincipal ventanaPrincipal;
    private final JPanel panelBotones;
    private final JButton botonJuego;
    private final JButton botonReportes;
    private final JButton botonAcercaDe;
    private final JButton botonAyuda;
    private final JButton botonSalir;
    private final JLabel labelTitulo;
    
    public MenuMemoria(PanelContenedorMemoria panelContenedor, VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        this.panelContenedor = panelContenedor;
        this.panelBotones = new JPanel();
        this.botonAcercaDe = new JButton();
        this.botonAyuda = new JButton();
        this.botonSalir = new JButton();
        this.botonJuego = new JButton();
        this.botonReportes = new JButton();
        this.labelTitulo = new JLabel();

        
        iniciarPanel();
        ajustarBotones();
        colocarBotones();
        
        botonInicio();
        botonAyuda();
        botonAcercaDe();
        botonReportes();
        botonSalir();
    }
    
    private void iniciarPanel(){
        this.setLayout(new BorderLayout());
        labelTitulo.setText("MEMORIA");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 72));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        this.add(labelTitulo, BorderLayout.NORTH);
        this.setBackground(Color.RED);
        this.setForeground(Color.YELLOW);
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
        botonAyuda.setBackground(Color.MAGENTA);
        botonAcercaDe.setBackground(Color.GRAY);
        botonSalir.setBackground(Color.red);
    }
     
     private void ajustarBotones(){
         JPanel contenedor = new JPanel(new GridBagLayout());
         
        panelBotones.setBackground(Color.blue);
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.add(Box.createRigidArea(new Dimension(0 , 20)));
        contenedor.add(panelBotones);
        contenedor.setBackground(Color.blue);
        this.add(contenedor, BorderLayout.CENTER);
         
     }
     
     private void botonReportes(){
          botonReportes.addActionListener(e ->{
             ventanaPrincipal.setTitle("Reportes");
             panelContenedor.irAReportes();
         });
     }
     
     private void botonInicio(){
         botonJuego.addActionListener(e ->{
             ventanaPrincipal.setTitle("Datos de Memoria");
             panelContenedor.recibirDatos();
         });
     }
   
     private void botonSalir(){
         botonSalir.addActionListener(e -> {
           ventanaPrincipal.setTitle("Menu Principal");
           ventanaPrincipal.mostrarPaneles("MENU INICIAL");
            });
     }
     
     private void botonAyuda(){
         botonAyuda.addActionListener(e ->{
             mostrarGuia();
         });
     }
     
     private void botonAcercaDe(){
         botonAcercaDe.addActionListener(e ->{
             mostrarDescripcionDesarrollador();
         });
     }
     private void mostrarGuia() {
        JDialog guiaDialog = new JDialog();
        guiaDialog.setTitle("Guia del juego");
        
        JTextArea guiaText = new JTextArea("""
                                                  1. Encuentra un par igual de cartas
                                                  y obtiene 50 puntos, si fallas perderas 5 puntos.
                                                  2. El turno en pantalla indica quien debe 
                                                  voltear las cartas.
                                                  3. Podras ver los punteos en tiempo real al
                                                  lado del turno.
                                                  4. El que consiga mas puntos al final gana
                                                  la partida.
                                                  5. El juego es exclusivamente 1vs1.
                                                  6. Al finalizar puedes iniciar otra 
                                                  partida en Juego - IniciarJuego.
                                                  """);
        guiaText.setEditable(false); 
        guiaDialog.add(guiaText);
        
        guiaDialog.setSize(300, 300);
        guiaDialog.setLocationRelativeTo(this);
        guiaDialog.setVisible(true);
    }
    
    private void mostrarDescripcionDesarrollador() {
        JDialog descripcionDialog = new JDialog();
        descripcionDialog.setTitle("Desarrollador");
        
        JTextArea descripcionText = new JTextArea("""
                                                  Juego desarrollado por Kenny Oxlaj
                                                  Con carnet 202331308
                                                  Estudiante de Ingenieria en Ciencias y Sistemas
                                                  en el Centro Universitario de Occidente
                                                  Para la practica 2 del curso IPC1 PS 2026
                                                  """);
        descripcionText.setEditable(false); 
        descripcionDialog.add(descripcionText);
        
        descripcionDialog.setLocationRelativeTo(this);
        descripcionDialog.setSize(400, 200);
        descripcionDialog.setVisible(true);
    }
    
}
