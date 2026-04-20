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
    private PanelJuego panelJuego;
    
    private final CardLayout cardLayout;
    
    private final String INICIO = "INICIO";
    private final String MENU = "MENU INCIAL";
    private final String MENU_HUNTING = "MENU HUNTING";
    private final String DATOS = "DATOS";
    private final String REPORTES = "REPORTES";
    private final String REGRESAR = "REGRESAR";
    
    
    public JPanelContenedorHunting(VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        this.menuHunting = new MenuHunting(this, ventanaPrincipal);
        this.datosHunting = new PanelDatosHunting(menuHunting, this);
        this.panelJuego = new PanelJuego(this);
        this.cardLayout = new CardLayout();
        
        setLayout(cardLayout);
        
        iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        this.add(menuHunting, MENU_HUNTING);
        this.add(datosHunting, DATOS);
        this.add(panelJuego, INICIO);
    }

    @Override
    public void cambiarPaneles(String nombrePanel) {
        cardLayout.show(this, nombrePanel);
    }

    @Override
    public void irADatos() {
        cambiarPaneles(DATOS);
    }

    @Override
    public void irAReportes() {
    }

    @Override
    public void regresarAMenu() {
        ventanaPrincipal.irAMenuInicial();
    }

    @Override
    public void irAMenuInicial() {
        cambiarPaneles(MENU_HUNTING);
    }
    
    @Override
    public void iniciarJuego() {
        cambiarPaneles(INICIO);
    }

    public PanelJuego getPanelJuego() {
        return panelJuego;
    }

    public void setPanelJuego(PanelJuego panelJuego) {
        this.panelJuego = panelJuego;
    }
    
    
    
    
}
