/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import com.mycompany.BackEnd.Memoria.Jugador.Jugador;
import com.mycompany.BackEnd.Memoria.Controladores.ControladorDatos;
import com.mycompany.BackEnd.Memoria.Tablero.Carta;
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
public class TableroMemoria extends JPanel implements Runnable{
    
    private final ControladorDatos controladorDatos;
    private final VentanaJuego ventana;
    private boolean cartasPares;
    private JButton[][] tablero;
    private JButton boton1;
    private JButton boton2;
    private Carta[][] cartas;
    private Carta primeraCarta;
    private boolean cartaBloqueada;
    private int filas;
    private int columnas;
    private final String RUTA_IMAGEN_GENERICA = "/ImagenesMemoria/ImagenGenerica.png";
    
    private ImageIcon imagenGenerica;
    
    public TableroMemoria (ControladorDatos controladorDatos, VentanaJuego ventana) {
        this.ventana = ventana;
        this.controladorDatos = controladorDatos;
        this.primeraCarta = null;
        this.cartaBloqueada = false;
        
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
        imagenGenerica = new ImageIcon(getClass().getResource(RUTA_IMAGEN_GENERICA));
    }
    
    private ImageIcon adaptarImagen(ImageIcon imagenObtenida, int ancho, int alto){
        Image imagen = imagenObtenida.getImage();
        Image imagenEscalada = imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
    
    private void agregarAccionBoton(JButton boton, int fila, int columna){
        boton.addActionListener(e -> { 
            voltearCartas(fila, columna, boton);
        });
    }
    
    private void voltearCartas(int fila, int colummna, JButton boton) {
        
        if(cartaBloqueada == true){
            return;
        }
        
        Carta carta = cartas[fila][colummna];
        
        if(carta == primeraCarta){
            JOptionPane.showMessageDialog(this, "Error, la carta ya esta volteada", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        if(carta.isEstaVolteada() == false ){
            System.out.println("Entrando acan 1");
            carta.voltearCartaArriba();
            controladorDatos.getControladorPartida().getPartida().obtenerCartas(carta);
            mostrarCartas(boton, carta);
            
            if(primeraCarta == null){
                primeraCarta = carta;
                boton1 = boton;
            } else {
                boton2 = boton;
                cartaBloqueada = true; 
                mostrarDosCartas();
            }
            
        } 
        
    }
    
    private void mostrarCartas(JButton botonObtenido, Carta cartaObtenida) {
        
        ImageIcon imagenFondo = obtenerImagen(cartaObtenida.getCodigoCarta());
        botonObtenido.setIcon(imagenFondo);
        
    }
    
   private void mostrarDosCartas() {

        cartasPares = controladorDatos.getControladorPartida().getPartida().compararCartas();

        if (cartasPares) {
            
            controladorDatos.getControladorPartida() .getPartida().cartasArriba();
            controladorDatos.getControladorPartida().getPartida().resetearCartas();
            actualizarFrontend();
            obtenerFInFrontend();
            cartaBloqueada = false;
            primeraCarta = null;
        } else {
            new Thread(this).start();
        }
        
        
    }
   
   private void actualizarFrontend(){
        controladorDatos.getControladorPartida().getPartida().darRecompensas(cartasPares);
        
        ventana.obtenerTurnos();
        ventana.actualizarLabels();
   }
    
    private void restaurarCartas(JButton boton1, Carta carta){
        
        if(!carta.isEstaVolteada()){
            boton1.setIcon(adaptarImagen(imagenGenerica, 100, 100));
        }
    }
    
    private ImageIcon obtenerImagen(int codigoCarta){
        ImageIcon imagenObtenida = new ImageIcon(getClass().getResource("/ImagenesMemoria/Imagen" + codigoCarta + ".jpg"));
        return adaptarImagen(imagenObtenida, 100, 100);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        controladorDatos.getControladorPartida().getPartida().cartasAbajo();

        restaurarCartas(boton1, primeraCarta);
        restaurarCartas(boton2, controladorDatos.getControladorPartida().getPartida().getCarta2());
        
        actualizarFrontend();
        controladorDatos.getControladorPartida().getPartida().resetearCartas();
        obtenerFInFrontend();
        primeraCarta = null;
        cartaBloqueada = false;
    }
    
    private void obtenerFInFrontend(){

        boolean partidaFinalizada = controladorDatos.getControladorPartida().getPartida().obtenerEstadoPartida();

        if (!partidaFinalizada) {
            return;
        }

        Jugador ganador = controladorDatos.getControladorPartida().getPartida().obtenerGanador();

        if(ganador != null){
            JOptionPane.showMessageDialog( this,"Pares completos encontrados, Ganador: " + ganador.getNombreJugador(),"Fin de la partida",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
        
        controladorDatos.getControladorPartida().getPartida().mandarReportes();
        

        ventana.getMemoria().recibirDatos();
        
        
    }
    
    
    

}
