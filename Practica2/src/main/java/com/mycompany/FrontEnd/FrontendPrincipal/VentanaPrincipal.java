/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.FrontendPrincipal;

import com.mycompany.FrontEnd.Memoria.PanelContenedorMemoria;
import com.mycompany.FrontEnd.ModulosDeNavegacion.NavegacionPrincipal;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Kenny
 */
public final class VentanaPrincipal extends JFrame implements NavegacionPrincipal {
    
    private final CardLayout cardLayout;
    private final JPanel contenedor;
    private final JPanelPrincipal menuInicial;
    private final PanelContenedorMemoria memoria;
    public final String MENU_INICIAL = "MENU INICIAL";
    public final String MEMORIA = "MEMORIA";   
    public final String HUNTING = "HUNTING";
    public final String REPORTES = "REPORTES";
    
    
    public VentanaPrincipal(){
       this.cardLayout = new CardLayout();
       this.contenedor = new JPanel(cardLayout);
       this.memoria = new PanelContenedorMemoria(this);
       this.menuInicial = new JPanelPrincipal(this);
       iniciarComponentes();
       agregarPanelesPrincipales();
       irAMenuInicial();
    }
    
    /**
     * Metodo encargado de iniciar los componentes necesarios para que el JFrame funcione correctamente
     */
    private void iniciarComponentes(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Libreria de juegos");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    //    this.setState(JFrame.ICONIFIED);
  //      this.setLocationRelativeTo(null);
        this.setContentPane(contenedor);
    }
    
    private void agregarPanelesPrincipales(){
        contenedor.add(menuInicial, MENU_INICIAL);
        contenedor.add(memoria, MEMORIA);
       // contenedor.add();
    }
    
 
    public void mostrarPaneles(String panel){
        cardLayout.show(contenedor, panel);
    }
    
    @Override
    public void irAMenuInicial(){
        mostrarPaneles(MENU_INICIAL);
    }
    
    @Override
    public void irAMemorias() {
        mostrarPaneles(MEMORIA);
    }

    @Override
    public void irAHunting() {
    }

    @Override
    public void irAReportes() {
    }

}
