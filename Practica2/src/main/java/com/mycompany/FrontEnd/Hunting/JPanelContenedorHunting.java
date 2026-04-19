/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Hunting;

import com.mycompany.FrontEnd.FrontendPrincipal.VentanaPrincipal;
import com.mycompany.FrontEnd.ModulosDeNavegacion.NavegacionHunting;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public class JPanelContenedorHunting extends JPanel implements NavegacionHunting {
    
    private final VentanaPrincipal ventanaPrincipal;
    private final MenuHunting menuHunting;
    private final PanelDatosHunting datosHunting;
    private final PanelJuego panelJuego;
    
    private final CardLayout cardLayout;
    
    private final String MENU = "MENU INCIAL";
    private final String DATOS = "DATOS";
    private final String REPORTES = "REPORTES";
    private final String REGRESAR = "REGRESAR";
    
    
    public JPanelContenedorHunting(VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        this.menuHunting = new MenuHunting();
        this.datosHunting = new PanelDatosHunting();
        this.panelJuego = new PanelJuego();
        this.cardLayout = new CardLayout();
        
        setLayout(cardLayout);
        
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        this.add(menuHunting, MENU);
        this.add(datosHunting, DATOS);
        this.add(panelJuego);
    }

    @Override
    public void cambiarPaneles(String nombrePanel) {
        cardLayout.show(this, nombrePanel);
    }

    @Override
    public void irADatos() {
    }

    @Override
    public void irAReportes() {
    }

    @Override
    public void regresarAMenu() {
    }

    @Override
    public void irAMenuInicial() {
        cambiarPaneles(MENU);
    }
    
}
