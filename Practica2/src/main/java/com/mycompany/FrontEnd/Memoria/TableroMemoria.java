/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import com.mycompany.BackEnd.Memoria.Controladores.ControladorDatos;
import com.mycompany.BackEnd.Memoria.Tablero.Carta;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class TableroMemoria extends JPanel{
    
    private final ControladorDatos controladorDatos;
    private JButton[][] tablero;
    private Carta[][] cartas;
    private int filas;
    private int columnas;
    
    private ImageIcon imagenGenerica;
    
    public TableroMemoria (ControladorDatos controladorDatos) {
        this.controladorDatos = controladorDatos;
        cargarImagenes();
        construirTablero();
        agregarTablero();
    }
    
   private void construirTablero() {
        this.columnas = controladorDatos.getControladorPartida().getTablero().getCantidadColumnas();
        this.filas = controladorDatos.getControladorPartida().getTablero().getCantidadFilas();
        this.tablero = new JButton[filas][columnas];

        this.cartas = controladorDatos.getControladorPartida().getTablero().getTablero();
    }

    private void agregarTablero() {

        setLayout(new GridLayout(filas, columnas));

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                JButton boton = new JButton();
                boton.setBackground(Color.white);
                int anchoBoton = 100;
                int altoBoton = 100;

                boton.setIcon(adaptarImagen(imagenGenerica, anchoBoton, altoBoton));

                final int fila = i;
                final int columna = j;
                
                agregarAccionBoton(boton, fila, columna);

                tablero[i][j] = boton;
                this.add(boton);
            }
        }
    }
    
    private void cargarImagenes(){
        imagenGenerica = new ImageIcon(getClass().getResource("/ImagenesMemoria/ImagenGenerica.png"));
    }
    
    private ImageIcon adaptarImagen(ImageIcon imagenObtenida, int ancho, int alto){
        Image imagen = imagenObtenida.getImage();
        Image imagenEscalada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
    
    private void mostrarCarta(int fila, int colummna, JButton boton) {
        Carta carta = cartas[fila][colummna];

        ImageIcon frente = new ImageIcon(
            getClass().getResource(carta.getRutaDeImages())
        );

        boton.setIcon(frente);
    }

    private void agregarAccionBoton(JButton boton, int fila, int columna){
        boton.addActionListener(e -> { mostrarCarta(fila, columna, boton);});
    }
    
    
}
