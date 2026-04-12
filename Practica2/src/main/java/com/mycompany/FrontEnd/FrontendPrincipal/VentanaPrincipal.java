/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.FrontendPrincipal;

import com.mycompany.FrontEnd.Memoria.InterfazMemoria;
import com.mycompany.FrontEnd.Memoria.MenuMemoria;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class VentanaPrincipal extends JFrame {
    
    private final CardLayout cardLayout;
    private final JPanel contenedor;
    private final JPanelPrincipal menuInicial;
    private final MenuMemoria menuMemoria;
    private final InterfazMemoria interfazMemoria;

    public VentanaPrincipal(){
       this.cardLayout = new CardLayout();
       this.contenedor = new JPanel(cardLayout);
       this.menuInicial = new JPanelPrincipal(this);
       this.menuMemoria = new MenuMemoria(this);
       this.interfazMemoria = new InterfazMemoria(this);
       iniciarComponentes();
       agregarPanelesMemoria();
    }
    
    /**
     * Metodo encargado de iniciar los componentes necesarios para que el JFrame funcione correctamente
     */
    private void iniciarComponentes(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Libreria de juegos");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setContentPane(contenedor);
    }
    
    private void agregarPanelesMemoria(){
        contenedor.add(menuInicial, "MENU INICIAL");
        contenedor.add(menuMemoria, "MEMORIAS");
        contenedor.add(interfazMemoria, "INICIO MEMORIA");
    }
    
    public void mostrarPaneles(String nombre){
         cardLayout.show(contenedor, nombre);
    }
    
}
