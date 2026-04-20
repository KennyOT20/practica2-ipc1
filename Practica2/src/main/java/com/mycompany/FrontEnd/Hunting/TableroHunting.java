/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Hunting;

import com.mycompany.BackEnd.Hunting.Controladores.DatosHunting;
import com.mycompany.BackEnd.Hunting.TableroHunting.Casilla;
import com.mycompany.FrontEnd.ModulosDeNavegacion.AvisarPartida;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class TableroHunting extends JPanel implements AvisarPartida{
    
    private final PanelJuego panelJuego;
    private JButton[][] tablero;
    private  DatosHunting datosHunting;
    
    private Casilla[][] casillas;
    
    private ImageIcon imagenPato;

    public TableroHunting(DatosHunting datosHunting, PanelJuego panelJuego){
        this.panelJuego = panelJuego;
        this.datosHunting = datosHunting;
        
        cargarImagenes();
        
    }
    
    public void iniciarJuego(){
        datosHunting.getPartida().iniciar();
         construirTablero();
        agregarTablero();
        datosHunting.getPartida().setAvisar(this);
    }
    
    private void construirTablero(){
        int filas = datosHunting.getPartida().getTablero().getFilas();
        int columnas = datosHunting.getPartida().getTablero().getColumnas();
        
        tablero = new JButton[filas][columnas];
        casillas = datosHunting.getPartida().getTablero().getTablero(); 
    }
    

    
    private void agregarTablero(){
        int filas = tablero.length;
        int columnas = tablero[0].length;
        
        setLayout(new GridLayout(filas, columnas));
        
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                
                JButton boton = new JButton();
                
                boton.setBackground(Color.GREEN);
                boton.setBorderPainted(false);
                boton.setFocusPainted(false);
                
                int fila = i;
                int columna = j;
                
                boton.addActionListener(e -> disparar(fila, columna, boton));
                
                tablero[i][j] = boton;
                this.add(boton);
            }
        }
    }
    
    private void cargarImagenes(){
        imagenPato = new ImageIcon(getClass().getResource("/ImagenHunting/ImagenPato.png"));
    }
    
    private ImageIcon adaptarImagen(ImageIcon imagen, int ancho, int alto){
        Image ImagenObtenida = imagen.getImage();
        Image escalada = ImagenObtenida.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(escalada);
    }
    
    private void disparar(int fila, int columna, JButton boton){
        panelJuego.actualizarLabels();
        evaluarTiempos();
        evaluarPartida();
        
        
        boolean hayPato = casillas[fila][columna].isContienePato();
        
        if(hayPato){
            datosHunting.getPartida().incrementarVecesSeguidas();
            datosHunting.getPartida().incrementarPatos();
            datosHunting.getPartida().reiniciarFallos();
            casillas[fila][columna].desactivarPato();
            boton.setIcon(null);
            
            System.out.println("ACIERTO");
            
        } else {
            datosHunting.getPartida().decrementarVecesSeguidas();
            datosHunting.getPartida().incrementarFallos();
            datosHunting.getPartida().incrementarFallosSeguidos();
            System.out.println("FALLO");
        }
    }
    
    private void evaluarTiempos(){
        
        boolean tiempoRestado =datosHunting.getPartida().restarTiempos();
        
        if(tiempoRestado ){
            panelJuego.mostrarLabelResta();
        }
        
    }
    
    private void evaluarPartida(){
    
        boolean partidaFinalizada = datosHunting.getPartida().verificarPartidaPerdida();

        if(partidaFinalizada){
            datosHunting.getPartida().detener();

            JOptionPane.showMessageDialog(
                panelJuego, 
                "Partida perdida, se llego al maximo de fallas",
                "Fin del juego",
                JOptionPane.INFORMATION_MESSAGE
            );
            
            panelJuego.reiniciarLabelInfo();
            panelJuego.getPanelContenedor().irAMenuInicial();
        }
    }
    
    public void actualizarTablero(){
        
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[0].length; j++){
                
                if(casillas[i][j].isContienePato()){
                    tablero[i][j].setIcon(adaptarImagen(imagenPato, 75, 75));
                } else {
                    tablero[i][j].setIcon(null);
                }
            }
        }
    }

    @Override
    public void actualizarFrontedn() {
        actualizarTablero();
    }
}