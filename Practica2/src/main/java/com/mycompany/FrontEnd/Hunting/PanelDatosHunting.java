/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Hunting;

import com.mycompany.BackEnd.Hunting.Controladores.DatosHunting;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kenny
 */
public class PanelDatosHunting extends JPanel{
    
    private final  JPanelContenedorHunting contenedor;
    private final MenuHunting menuHunting;
    private final JPanel contenedorOpcion;
    
    private final JButton botonInicio;
    private final JButton botonRegresar;
    
    private final JTextField obtenerNombre;
    private final JFormattedTextField obtenerAciertos;
    private final JFormattedTextField obtenerTiempoInicial;
    private final JFormattedTextField obtenerTiempoReducido;
    
    private final JLabel titulo;
    private final JLabel nombre;
    private final JLabel aciertos;
    private final JLabel tiempInicial;
    private final JLabel tiempoReducido;
    
    
    public PanelDatosHunting(MenuHunting menuHunting, JPanelContenedorHunting contenedor){
        this.contenedor = contenedor;
        this.menuHunting = menuHunting;
        this.contenedorOpcion = new JPanel();
        this.botonInicio = new JButton();
        this.botonRegresar = new JButton();
        this.obtenerNombre = new JTextField();
        this.obtenerAciertos = new JFormattedTextField();
        this.obtenerTiempoInicial = new JFormattedTextField();
        this.obtenerTiempoReducido = new JFormattedTextField();
        this.titulo = new JLabel();
        this.nombre = new JLabel();
        this.aciertos = new JLabel();
        this.tiempInicial = new JLabel();
        this.tiempoReducido = new JLabel();
        
        iniciarComponentes();
        configurarPanel();
        configurarComponentes();
        agregarComponentes();
        
        accionIniciar();
        accionRegresar();
    }
    
    private void iniciarComponentes(){
        this.setLayout(null);
        this.setBackground(Color.GRAY);
        
        editarTextosComponentes();
        editarFuentesYColoresComponentes();
    }
    
    @Override
    public void doLayout() {
        super.doLayout();

        int anchoPanel = 700;
        int altoPanel = 400;

        int x = (getWidth() - anchoPanel) / 2;
        int y = (getHeight() - altoPanel) / 2;

        contenedorOpcion.setBounds(x, y, anchoPanel, altoPanel);
    }
    
    private void configurarPanel(){
        contenedorOpcion.setLayout(null);
        contenedorOpcion.setBackground(Color.GRAY);
    }
    
    private void editarTextosComponentes(){
        titulo.setText("DATOS HUNTING");
        
        botonInicio.setText("INICIAR");
        botonRegresar.setText("REGRESAR");
        
        nombre.setText("Ingrese su nombre:");
        tiempInicial.setText("Tiempo inicial (ms):");
        aciertos.setText("Cantidad de aciertos:");
        tiempoReducido.setText("Tiempo reducido (ms):");
    }
    
    private void editarFuentesYColoresComponentes(){
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        
        botonInicio.setFont(new Font("Arial", Font.BOLD, 24));
        botonRegresar.setFont(new Font("Arial", Font.BOLD, 24));
        
        nombre.setFont(new Font("Arial", Font.BOLD, 22));
        tiempInicial.setFont(new Font("Arial", Font.BOLD, 22));
        tiempoReducido.setFont(new Font("Arial", Font.BOLD, 22));
        aciertos.setFont(new Font("Arial", Font.BOLD, 22));
        
        botonInicio.setBackground(Color.GREEN);
        botonRegresar.setBackground(Color.PINK);
    }
    
    private void configurarComponentes(){
        
        titulo.setBounds(0, 10, 700, 50);
        
        nombre.setBounds(50, 80, 250, 30);
        obtenerNombre.setBounds(320, 80, 250, 30);
        
        tiempInicial.setBounds(50, 130, 250, 30);
        obtenerTiempoInicial.setBounds(320, 130, 250, 30);
        
        aciertos.setBounds(50, 180, 250, 30);
        obtenerAciertos.setBounds(320, 180, 250, 30);
        
        tiempoReducido.setBounds(50, 230, 250, 30);
        obtenerTiempoReducido.setBounds(320, 230, 250, 30);
        
        botonRegresar.setBounds(150, 300, 180, 40);
        botonInicio.setBounds(370, 300, 180, 40);
    }
    
    private void agregarComponentes(){
        
        contenedorOpcion.add(titulo);
        
        contenedorOpcion.add(nombre);
        contenedorOpcion.add(obtenerNombre);
        
        contenedorOpcion.add(tiempInicial);
        contenedorOpcion.add(obtenerTiempoInicial);
        
        contenedorOpcion.add(aciertos);
        contenedorOpcion.add(obtenerAciertos);
        
        contenedorOpcion.add(tiempoReducido);
        contenedorOpcion.add(obtenerTiempoReducido);
        
        contenedorOpcion.add(botonRegresar);
        contenedorOpcion.add(botonInicio);
        
        this.add(contenedorOpcion);
    }
    
    private void accionRegresar(){
        botonRegresar.addActionListener(e ->{
            reiniciarDatos();
            menuHunting.getPanelContenedor().irAMenuInicial();
        });
    }
    
    private void accionIniciar(){
        
        botonInicio.addActionListener(e ->{
            DatosHunting datos = new DatosHunting();
            
            if(nombreCorrecto(datos) && obtenerDatosNumericos(datos)){
                datos.iniciarPartida();
                contenedor.getPanelJuego().iniciarDatos(datos);
                reiniciarDatos();
                contenedor.iniciarJuego();
                 }   
        });
    }

    private boolean nombreCorrecto(DatosHunting datos){

        String nombreJugador = obtenerNombre.getText().trim();

        if(!nombreJugador.isEmpty()){
            datos.getJugador().setNombreJugadorHunting(nombreJugador);
            return true;
        } else {
            JOptionPane.showMessageDialog(
                this,
                "El nombre no puede estar vacio.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
    
    private void reiniciarDatos(){
        obtenerNombre.setText("");
        obtenerAciertos.setText("");
       obtenerTiempoInicial.setText("");
        obtenerTiempoReducido.setText("");
    }
    
    
   private boolean obtenerDatosNumericos(DatosHunting datos){
        try {
            int cantidadDeAciertos;
            int tiempoInicial;

            cantidadDeAciertos = Integer.parseInt(obtenerAciertos.getText());
            tiempoInicial = Integer.parseInt(obtenerTiempoInicial.getText());

            if(cantidadDeAciertos > 0 && tiempoInicial > 0){

                if(validarTiempoReducido(datos, tiempoInicial)){ 
                    datos.setCantidadAciertos(cantidadDeAciertos);
                    datos.setTiempoInicial(tiempoInicial);
                    System.out.println("tiempoInicial " + tiempoInicial);
                    return true;
                } else {
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Los datos no pueden ser cero o negativos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return false;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "Los campos no pueden estar vacios o contener texto invalido.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
    
   private boolean validarTiempoReducido(DatosHunting datos, int tiempoInicial){
        try {
            int tiempoRestado = Integer.parseInt(obtenerTiempoReducido.getText());

            if(tiempoRestado > 0 && tiempoRestado < tiempoInicial){
                datos.setTiempoReducido(tiempoRestado);
                return true;
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "El tiempo reducido debe ser mayor a 0 y menor que el tiempo inicial.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return false;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "El tiempo reducido no puede estar vacio o contener texto invalido.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    
    

}
    
    
    

