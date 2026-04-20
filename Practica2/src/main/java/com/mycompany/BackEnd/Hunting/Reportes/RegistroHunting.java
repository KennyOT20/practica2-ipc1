/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Hunting.Reportes;

/**
 *
 * @author Kenny
 */
public class RegistroHunting {
    private final String nombre;
    private final String configuracion;
    private final int aciertos;
    private final int fallos;
    private final String fecha;
    private final String hora;

    public RegistroHunting(String nombre, String configuracion, int aciertos, int fallos, String fecha, String hora) {
        this.nombre = nombre;
        this.configuracion = configuracion;
        this.aciertos = aciertos;
        this.fallos = fallos;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public String getConfiguracion() {
        return configuracion;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getFallos() {
        return fallos;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    
    
    
}