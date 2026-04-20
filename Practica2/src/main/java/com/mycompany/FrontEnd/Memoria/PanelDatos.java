/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import com.mycompany.BackEnd.Memoria.Controladores.ControladorDatos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kenny
 */
public class PanelDatos extends JPanel {

    private ControladorDatos controladorDatos;
    private final PanelContenedorMemoria contenedor;
    
    private final JComboBox<String> dificultades;
    private final JPanel panelTitulo;
    private final JPanel panelNombres;

    private final JLabel titulo;
    private final JLabel nombreJugador1;
    private final JLabel nombreJugador2;
    private final JLabel dificultad;

    private final JTextField datoJugador1;
    private final JTextField datoJugador2;

    private final JButton botonIniciar;
    private final JButton botonRegresar;

    public PanelDatos(PanelContenedorMemoria contenedo) {
        this.contenedor = contenedo;
        this.dificultades = new JComboBox<>();
        this.panelTitulo = new JPanel();
        this.panelNombres = new JPanel();
        this.dificultad = new JLabel();
        this.titulo = new JLabel();
        this.nombreJugador1 = new JLabel();
        this.nombreJugador2 = new JLabel();
        this.datoJugador1 = new JTextField();
        this.datoJugador2 = new JTextField();
        this.botonIniciar = new JButton("Iniciar");
        this.botonRegresar = new JButton("Salir");

        iniciarComponentes();
        configurarPaneles();
        inicializarDificultades();
        configurarComponentes();
        agregarComponentes();
        botonIniciarJuego();
        botonSalir();
    }

    @Override
    public void doLayout() {
        super.doLayout();

        panelTitulo.setBounds(0, 0, getWidth(), 120);

        int anchoPanel = 600;
        int altoPanel = 300;

        int x = (getWidth() - anchoPanel) / 2;
        int y = 150;

        panelNombres.setBounds(x, y, anchoPanel, altoPanel);
    }
    
    private void iniciarComponentes() {
        setLayout(null);
        setBackground(Color.GRAY);
    }
    
    private void reiniciarDatos(){
        datoJugador1.setText("");
        datoJugador2.setText("");
        dificultades.setSelectedIndex(0);
        
    }

    private void configurarPaneles() {

        this.setForeground(Color.blue);
        panelTitulo.setBounds(0, 0, 1000, 120);
        panelTitulo.setBackground(Color.RED);
        panelTitulo.setLayout(new BorderLayout());

        panelNombres.setBounds(0, 120, 1000, 400);
        panelNombres.setLayout(null);
        panelNombres.setBackground(Color.GRAY);
    }

    private void configurarComponentes() {

        titulo.setText("NOMBRE DE JUGADORES");
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(JLabel.CENTER);

        nombreJugador1.setText("Jugador 1:");
        nombreJugador2.setText("Jugador 2:");
        dificultad.setText("Dificultad:");

        nombreJugador1.setFont(new Font("Arial", Font.BOLD, 28));
        nombreJugador2.setFont(new Font("Arial", Font.BOLD, 28));
        dificultad.setFont(new Font("Arial", Font.BOLD, 28));

        nombreJugador1.setBounds(100, 40, 200, 40);
        datoJugador1.setBounds(300, 40, 250, 40);

        nombreJugador2.setBounds(100, 100, 200, 40);
        datoJugador2.setBounds(300, 100, 250, 40);

        dificultad.setBounds(100, 160, 200, 40);
        dificultades.setBounds(300, 160, 250, 40);

        botonRegresar.setBounds(100, 230, 150, 40);
        botonIniciar.setBounds(400, 230, 150, 40);
        
        botonRegresar.setBackground(Color.PINK);
        botonIniciar.setBackground(Color.GREEN);
    }

    private void agregarComponentes() {

        panelTitulo.add(titulo, BorderLayout.CENTER);

        panelNombres.add(nombreJugador1);
        panelNombres.add(nombreJugador2);
        panelNombres.add(datoJugador1);
        panelNombres.add(datoJugador2);
        panelNombres.add(dificultad);
        panelNombres.add(dificultades); 
        panelNombres.add(botonRegresar);
        panelNombres.add(botonIniciar);
        
        panelNombres.setForeground(Color.pink);

        add(panelTitulo);
        add(panelNombres);
    }
    
    /**
     * A partir de este metodo para abajo se encargan de validar y manejar los eventos de la ventana
     */
    private void botonIniciarJuego(){
        
        botonIniciar.addActionListener(e -> { 
                if(entradaValida() == true){
                    enviarDatos();
                    reiniciarDatos();
                    contenedor.getInterfazJuego().obtenerDatos(controladorDatos);
                    contenedor.iniciarJuego();
                } else {
                    manejarValidacio();
                }
        });
    }

    private void botonSalir(){
        botonRegresar.addActionListener(e -> {
            reiniciarDatos();
            contenedor.irAMenuMemoria();});
    }
    
    private void manejarValidacio(){
        JOptionPane.showMessageDialog(this, "Error, debe de llenar todos los datos");
    }
    
    private void enviarDatos(){
        String jugador1 = datoJugador1.getText();
        String jugado2 = datoJugador2.getText();
        String nivel = (String) dificultades.getSelectedItem();
        
        controladorDatos = new ControladorDatos();
        
        controladorDatos.getJugador1().setNombreJugador(jugador1);
        controladorDatos.getJugador2().setNombreJugador(jugado2);
        controladorDatos.setDificultad(nivel);
        
        controladorDatos.construirPartida();
    }
    
    private boolean entradaValida(){
        return !(datoJugador1.getText().isEmpty() ||datoJugador2.getText().isEmpty());
    }
    
    private void inicializarDificultades(){
        dificultades.addItem("FACIL");
        dificultades.addItem("MEDIO");
        dificultades.addItem("DIFICIL");
    }

    public ControladorDatos getControladorDatos() {
        return controladorDatos;
    }
    
    
    
}