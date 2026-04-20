/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Memoria.Reportes;

/**
 *
 * @author Kenny
 */
public class RegistroPartida {
    
    private final String nombreGanador;
    private final String nombrePerdedor;
    private final int puntosGanador; 
    private final int puntosPerdedor; 
    private final String fecha;
    private final String hora;

    public RegistroPartida(String nombreGanador, int puntosGanador, String nombrePerdedor, int puntosPerdedor, String fecha, String hora) {
        this.nombreGanador = nombreGanador;
        this.puntosGanador = puntosGanador;
        this.nombrePerdedor = nombrePerdedor;
        this.puntosPerdedor = puntosPerdedor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombreGanador() {
        return nombreGanador;
    }

    public String getNombrePerdedor() {
        return nombrePerdedor;
    }

    public int getPuntosGanador() {
        return puntosGanador;
    }

    public int getPuntosPerdedor() {
        return puntosPerdedor;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
    
    

}