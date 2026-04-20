/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Hunting.Reportes;

import com.mycompany.BackEnd.Hunting.JugadorHunting.JugadorHunting;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Kenny
 */
public class ReportesHunting {

    private final static String PATH = "Reportes/reporte_hunting.txt";
    
    public ReportesHunting() {
        inicializarArchivo();
    }

    private void inicializarArchivo() {
        try {
            File carpeta = new File("Reportes");
            File archivo = new File(PATH);

            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            if (!archivo.exists()) {
                archivo.createNewFile(); 
                System.out.println("Archivo creado  en: " + PATH);
            }
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo de reportes: " + e.getMessage());
        }
    }

    public void guardarPartida(JugadorHunting jugador, int tInicial, int tiempoReducido) {
        File carpeta = new File("Reportes");
        if (!carpeta.exists()) carpeta.mkdirs();

        LocalDateTime ahora = LocalDateTime.now();
        String fecha = ahora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String hora = ahora.format(DateTimeFormatter.ofPattern("HH:mm"));
        
        File archivo = new File(PATH);
        try (FileWriter escribirArchivo = new FileWriter(archivo, true);
             PrintWriter printArchivo = new PrintWriter(escribirArchivo)) {

            String config = "Tiempo inicial: " + tInicial + " ms,"+ " Tiempo reducido: "  + tiempoReducido + "ms";
            
            String linea = jugador.getNombreJugadorHunting() + " , " +
                           config + " , " +
                           jugador.getPatosAcertados() + " , " +
                           jugador.getTirosFallados() + " , " +
                           fecha + " , " +
                           hora;
            printArchivo.println(linea);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RegistroHunting[] leerAArreglo() {
        int tamanoMax = contarRegistros();
        RegistroHunting[] temporal = new RegistroHunting[tamanoMax];
        int contadorReal = 0;

        try (BufferedReader escribirEnBuffer = new BufferedReader(new FileReader(PATH))) {
            String linea;
            while ((linea = escribirEnBuffer.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                
                String[] partes = linea.split(" , ");
                
                if (partes.length >= 6) {
                    String nombre = partes[0].trim();
                    String config = partes[1].trim();
                    int aciertos = Integer.parseInt(partes[2].trim());
                    int fallos = Integer.parseInt(partes[3].trim());
                    String fecha = partes[4].trim();
                    String hora = partes[5].trim();
                    
                    temporal[contadorReal] = new RegistroHunting(nombre, config, aciertos, fallos, fecha, hora);
                    contadorReal++;
                }
            }
        } catch (Exception e) { 
            System.err.println("Error al leer línea de Hunting: " + e.getMessage()); 
        }

        RegistroHunting[] definitivo = new RegistroHunting[contadorReal];
        for (int i = 0; i < contadorReal; i++) {
            definitivo[i] = temporal[i];
        }
        return definitivo;
    }

    private int contarRegistros() {
        int contador = 0;
        File archivo = new File(PATH);
        if (!archivo.exists()) return 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while (br.readLine() != null) contador++;
        } catch (IOException e) { e.printStackTrace(); }
        return contador;
    }


    public void ordenarBurbuja(RegistroHunting[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getAciertos() < arr[j + 1].getAciertos()) {
                    RegistroHunting temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void ordenarQuickSort(RegistroHunting[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int pi = particion(arr, bajo, alto);
            ordenarQuickSort(arr, bajo, pi - 1);
            ordenarQuickSort(arr, pi + 1, alto);
        }
    }

    private int particion(RegistroHunting[] arr, int bajo, int alto) {
        int pivote = arr[alto].getAciertos();
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            if (arr[j].getAciertos() <= pivote) {
                i++;
                RegistroHunting temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        RegistroHunting temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;
        return i + 1;
    }
}
