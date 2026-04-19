/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Hunting;

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
public class MenuHunting extends JPanel {

    private final JButton botonInicio;
    private final JButton botonRegresar;
    private final JButton botonReportes;
    private final JLabel labelTitulo;
    private final JPanel panelBotones;

    public MenuHunting(){
        this.botonInicio = new JButton();
        this.botonRegresar = new JButton();
        this.botonReportes = new JButton();
        this.labelTitulo = new JLabel();
        this.panelBotones = new JPanel();

        iniciarPanel();
        colocarBotones();
        ajustarBotones();
    }

    private void iniciarPanel(){
        this.setLayout(new BorderLayout());

        labelTitulo.setText("HUNTING");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 60));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);

        this.add(labelTitulo, BorderLayout.NORTH);

        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
    }

    private void colocarBotones(){
        añadirTextos();
        editarFonts();
        editarComponentes();
        editarColores();

        panelBotones.add(botonInicio);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));

        panelBotones.add(botonReportes);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));

        panelBotones.add(botonRegresar);
    }

    private void añadirTextos(){
        botonInicio.setText("INICIAR JUEGO");
        botonRegresar.setText("SALIR");
        botonReportes.setText("REPORTES");
    }

    private void editarFonts(){
        botonInicio.setFont(new Font("Arial", Font.BOLD, 28));
        botonRegresar.setFont(new Font("Arial", Font.BOLD, 28));
        botonReportes.setFont(new Font("Arial", Font.BOLD, 28));
    }

    private void editarComponentes(){
        botonInicio.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonRegresar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonReportes.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonInicio.setMaximumSize(new Dimension(300, 60));
        botonRegresar.setMaximumSize(new Dimension(300, 60));
        botonReportes.setMaximumSize(new Dimension(300, 60));
    }

    private void editarColores(){
        botonInicio.setBackground(Color.GREEN);
        botonReportes.setBackground(Color.CYAN);
        botonRegresar.setBackground(Color.RED);
    }

    private void ajustarBotones(){
        JPanel contenedor = new JPanel(new GridBagLayout());

        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(Color.BLACK);

        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)));

        contenedor.add(panelBotones);
        contenedor.setBackground(Color.BLACK);

        this.add(contenedor, BorderLayout.CENTER);
    }
}
