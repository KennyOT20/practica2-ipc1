/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Memoria;

import com.mycompany.BackEnd.Memoria.Reportes.ReportesMemoria;
import com.mycompany.BackEnd.Memoria.Reportes.RegistroPartida;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Kenny
 */
public class PanelReportes extends JPanel {

    private final PanelDatos panelDatos;
    private final PanelContenedorMemoria contenedorMemoria;
    private final JPanel panelTitulo;
    private final JLabel titulo;
    private final JPanel panelContenido;
    private final JTable tablaDeDatos;
    private final DefaultTableModel modeloTabla;
    private final JScrollPane scrollTabla;
    private final JButton botonSalir;
    private final JButton botonMayorAMenor;
    private final JButton botonMenorAMayor;

    private final ReportesMemoria gestionReportes;

    public PanelReportes(PanelDatos panelDatos, PanelContenedorMemoria contenedorMemoria) {
        this.contenedorMemoria = contenedorMemoria;
        this.panelDatos = panelDatos;
        this.gestionReportes = new ReportesMemoria(); 
        
        this.panelTitulo = new JPanel();
        this.titulo = new JLabel();
        this.panelContenido = new JPanel();

        String[] columnas = {
            "Nombre Ganador", "Punteo", "Fecha",
            "Nombre Perdedor", "Punteo", "Hora"
        };
        
        this.modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        this.tablaDeDatos = new JTable(modeloTabla);
        this.scrollTabla = new JScrollPane(tablaDeDatos);

        this.botonSalir = new JButton("Salir");
        this.botonMayorAMenor = new JButton("Ordenar Mayores a Menores");
        this.botonMenorAMayor = new JButton("Ordenar Menores a Mayores");

        iniciarComponentes();
        configurarPaneles();
        configurarComponentes();
        agregarComponentes();
        asignarEventos();
        
        cargarDatosATabla();
    }

    private void asignarEventos() {
        botonMayorAMenor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroPartida[] partidas = gestionReportes.leerAArreglo();
                if (partidas != null && partidas.length > 0) {
                    gestionReportes.ordenarBurbuja(partidas);
                    llenarTabla(partidas);
                }
            }
        });

        botonMenorAMayor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroPartida[] partidas = gestionReportes.leerAArreglo();
                if (partidas != null && partidas.length > 0) {
                    gestionReportes.ordenarQuickSort(partidas, 0, partidas.length - 1);
                    llenarTabla(partidas);
                }
            }
        });

        botonSalir.addActionListener(e -> {
           contenedorMemoria.irAMenuMemoria();
        });
    }

    private void cargarDatosATabla() {
        RegistroPartida[] partidas = gestionReportes.leerAArreglo();
        llenarTabla(partidas);
    }

    private void llenarTabla(RegistroPartida[] datos) {
        modeloTabla.setRowCount(0);

        for (RegistroPartida partidaObtenida : datos) {
            if (partidaObtenida != null) {
                Object[] fila = {
                    partidaObtenida.getNombreGanador(),
                    partidaObtenida.getPuntosGanador(),
                    partidaObtenida.getFecha(),
                    partidaObtenida.getNombrePerdedor(),
                    partidaObtenida.getPuntosPerdedor(),
                    partidaObtenida.getHora()
                };
                modeloTabla.addRow(fila);
            }
        }
    }

    @Override
    public void doLayout() {
        super.doLayout();
        panelTitulo.setBounds(0, 0, getWidth(), 120);
        
        int anchoPanel = 850;
        int altoPanel = 450;
        int x = (getWidth() - anchoPanel) / 2;
        int y = 150;
        
        panelContenido.setBounds(x, y, anchoPanel, altoPanel);
    }

    private void iniciarComponentes() {
        setLayout(null);
        setBackground(Color.GRAY);
    }

    private void configurarPaneles() {
        panelTitulo.setBackground(Color.RED);
        panelTitulo.setLayout(new BorderLayout());
        
        panelContenido.setLayout(null);
        panelContenido.setBackground(Color.GRAY);
    }

    private void configurarComponentes() {
        titulo.setText("REPORTES DE PARTIDAS");
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(Color.BLACK);
        titulo.setHorizontalAlignment(JLabel.CENTER);

        scrollTabla.setBounds(0, 0, 850, 350);

        botonSalir.setBounds(0, 380, 150, 40);
        botonSalir.setBackground(Color.PINK);

        botonMayorAMenor.setBounds(200, 380, 250, 40);
        botonMayorAMenor.setBackground(Color.LIGHT_GRAY);

        botonMenorAMayor.setBounds(500, 380, 250, 40);
        botonMenorAMayor.setBackground(Color.LIGHT_GRAY);
    }

    private void agregarComponentes() {
        panelTitulo.add(titulo, BorderLayout.CENTER);
        
        panelContenido.add(scrollTabla);
        panelContenido.add(botonSalir);
        panelContenido.add(botonMayorAMenor);
        panelContenido.add(botonMenorAMayor);
        
        add(panelTitulo);
        add(panelContenido);
    }
}