/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import com.mycompany.FrontEnd.FrontendPrincipal.VentanaPrincipal;
import com.mycompany.FrontEnd.ModulosDeNavegacion.NavegacionMemoria;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Kenny
 */
public final class PanelContenedorMemoria extends JPanel  implements NavegacionMemoria{
    
    private final VentanaPrincipal ventanaPrincipal;
    private final CardLayout cardLayout;
    private final MenuMemoria menuMemoria;
    private final PanelDatos panelDatos;
    private final VentanaJuego interfazJuego;
    
    private final String MENU_MEMORIA = "MENU MEMORIA";
    private final String PANEL_DATOS = "PANEL DATOS";
    private final String INTERFAZ_DE_JUEGO = "INTERFAZ DE DATOS";
    
    
    public PanelContenedorMemoria(VentanaPrincipal ventanaPrincipal){
        this.ventanaPrincipal = ventanaPrincipal;
        this.cardLayout = new CardLayout();
        this.menuMemoria = new MenuMemoria(this, ventanaPrincipal);
        this.panelDatos = new PanelDatos(this);
        this.interfazJuego = new VentanaJuego(this);
        setLayout(cardLayout);
        agregarPaneles();
        irAMenuMemoria();
    }
    
    private void agregarPaneles(){
        this.add(menuMemoria, MENU_MEMORIA);
        this.add(panelDatos, PANEL_DATOS);
        this.add(interfazJuego, INTERFAZ_DE_JUEGO);
    }

    
    
    @Override
    public void irAMenuMemoria() {
        cambiarPaneles(MENU_MEMORIA);
    }

    @Override
    public void recibirDatos() {
        cambiarPaneles(PANEL_DATOS);
    }

    @Override
    public void iniciarJuego() {
        cambiarPaneles(INTERFAZ_DE_JUEGO);
    }

    @Override
    public void cambiarPaneles(String nombrePanel) {
        cardLayout.show(this, nombrePanel);
    }

    public VentanaJuego getInterfazJuego() {
        return interfazJuego;
    }
    
    
    
}
