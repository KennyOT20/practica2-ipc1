/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.BackEnd.Memoria.Reportes;

import com.mycompany.BackEnd.Memoria.Jugador.Jugador;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Kenny
 */
public class ReportesMemoria {

    private final static String PATH = "Reportes/partidas.txt";
    private Jugador jugadorGanador;
    private Jugador jugadorPerdedor;
    private String fecha;
    private String hora;

    public void obtenerGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public void obtenerPerdedor(Jugador jugadorPerdedor) {
        this.jugadorPerdedor = jugadorPerdedor;
    }

    public void obtenerFecha() {
        LocalDateTime tiempoReal = LocalDateTime.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        fecha = tiempoReal.format(formatoFecha);
        hora = tiempoReal.format(formatoHora);
    }

    public void guardarPartida() {
        File carpeta = new File("Reportes");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
        obtenerFecha();

        File archivo = new File(PATH);
        try (FileWriter escribirArchivo = new FileWriter(archivo, true);
             PrintWriter pw = new PrintWriter(escribirArchivo)) {

            String linea = "Fecha: " + fecha +
                           " , Hora: " + hora +
                           " , Ganador: " + jugadorGanador.getNombreJugador() +
                           " (" + jugadorGanador.getPuntosMemoria() + " puntos)" +
                           " , Perdedor: " + jugadorPerdedor.getNombreJugador() +
                           " (" + jugadorPerdedor.getPuntosMemoria() + " puntos)";
            pw.println(linea);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo encargado de contar las lineas del archivo para vrrear arreglo
     */
    private int contarRegistros() {
        int contador = 0;
        File archivo = new File(PATH);
        if (!archivo.exists()) return 0;

        try (BufferedReader leerBuffer = new BufferedReader(new FileReader(archivo))) {
            while (leerBuffer.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }

    /**
     * Lee el archivo y convierte cada linea en un objeto RegistroPartida dentro de un arreglo.
     */
    public RegistroPartida[] leerAArreglo() {
        int tamañoMaximo = contarRegistros();
        
        RegistroPartida[] temporal = new RegistroPartida[tamañoMaximo];
        int contadorReal = 0;

        try (BufferedReader leerBuffer = new BufferedReader(new FileReader(PATH))) {
            String linea;
            while ((linea = leerBuffer.readLine()) != null) {
                RegistroPartida partidaObtenda = parsearLinea(linea);
                
                if (partidaObtenda != null) {
                    temporal[contadorReal] = partidaObtenda;
                    contadorReal++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        RegistroPartida[] resultado = new RegistroPartida[contadorReal];

        for (int i = 0; i < contadorReal; i++) {
            resultado[i] = temporal[i];
        }

        return resultado;
    }

    /**
     * Extrae los datos de la cadena de texto usando split y substring.
     */
   private RegistroPartida parsearLinea(String linea) {
        if (linea == null || linea.trim().isEmpty()) {
            return null;
        }

        String[] partes = linea.split(" , ");

        if (partes.length < 4) {
            return null; 
        }

        try {
            String f = partes[0].replace("Fecha: ", "").trim();
            String h = partes[1].replace("Hora: ", "").trim();

            String ganStr = partes[2].replace("Ganador: ", "");
            String nomG = ganStr.substring(0, ganStr.indexOf(" (")).trim();
            int ptsG = Integer.parseInt(ganStr.substring(ganStr.indexOf("(") + 1, ganStr.indexOf(" puntos")));

            String perStr = partes[3].replace("Perdedor: ", "");
            String nomP = perStr.substring(0, perStr.indexOf(" (")).trim();
            int ptsP = Integer.parseInt(perStr.substring(perStr.indexOf("(") + 1, perStr.indexOf(" puntos")));

            return new RegistroPartida(nomG, ptsG, nomP, ptsP, f, h);
        } catch (Exception e) {
            System.err.println("Error procesando datos  en línea: " + linea);
            return null;
        }
    }



    /**
     * Usando el ordenamiento de burbuja
     * @param arregloPartida recible un arreglo de artidas
     */
    public void ordenarBurbuja(RegistroPartida[] arregloPartida) {
        
        int tamañoArreglo = arregloPartida.length;
        for (int i = 0; i < tamañoArreglo - 1; i++) {
            for (int j = 0; j < tamañoArreglo - i - 1; j++) {
                if (arregloPartida[j].getPuntosGanador() < arregloPartida[j + 1].getPuntosGanador()) {
                    RegistroPartida registroObtenido = arregloPartida[j];
                    arregloPartida[j] = arregloPartida[j + 1];
                    arregloPartida[j + 1] = registroObtenido;
                }
            }
        }
    }

    /**
     * usarnedo el metodo de quikshort;
     * @param arreglo
     */
    public void ordenarQuickSort(RegistroPartida[] arreglo, int bajo, int alto) {
        if (bajo < alto) {
            int indice = particion(arreglo, bajo, alto);
            ordenarQuickSort(arreglo, bajo, indice - 1);
            ordenarQuickSort(arreglo, indice + 1, alto);
        }
    }

    private int particion(RegistroPartida[] arreglo, int bajo, int alto) {
        int pivote = arreglo[alto].getPuntosGanador();
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            if (arreglo[j].getPuntosGanador() <= pivote) {
                i++;
                RegistroPartida registroObtenido = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = registroObtenido;
            }
        }
        RegistroPartida temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temp;
        return i + 1;
    }

   
}