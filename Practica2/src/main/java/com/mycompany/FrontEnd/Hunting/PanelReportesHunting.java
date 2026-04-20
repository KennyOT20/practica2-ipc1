/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FrontEnd.Hunting;

import com.mycompany.BackEnd.Hunting.Reportes.RegistroHunting;
import com.mycompany.BackEnd.Hunting.Reportes.ReportesHunting;
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
public class PanelReportesHunting extends JPanel {

    JPanelContenedorHunting contenedor;
    private final JPanel panelTitulo;
    private final JLabel titulo;
    private final JPanel panelContenido;
    private final JTable tablaDeDatos;
    private final DefaultTableModel modeloTabla;
    private final JScrollPane scrollTabla;
    private final JButton botonSalir;
    private final JButton botonMayorAMenor;
    private final JButton botonMenorAMayor;

    private final ReportesHunting gestionReportes;

    public PanelReportesHunting(JPanelContenedorHunting contenedor) {
        this.gestionReportes = new ReportesHunting();
        this.contenedor = contenedor;
        this.panelTitulo = new JPanel();
        this.titulo = new JLabel();
        this.panelContenido = new JPanel();

       String[] columnas = {
            "Jugador", "Configuracion", "Aciertos", "Fallos", "Fecha", "Hora"
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
        this.botonMayorAMenor = new JButton("Mayores Aciertos");
        this.botonMenorAMayor = new JButton("Menores Aciertos");

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
                RegistroHunting[] datos = gestionReportes.leerAArreglo();
                if (datos != null && datos.length > 0) {
                    gestionReportes.ordenarBurbuja(datos);
                    llenarTabla(datos);
                }
            }
        });

        botonMenorAMayor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistroHunting[] datos = gestionReportes.leerAArreglo();
                if (datos != null && datos.length > 0) {
                    gestionReportes.ordenarQuickSort(datos, 0, datos.length - 1);
                    llenarTabla(datos);
                }
            }
        });

        botonSalir.addActionListener(e -> {
           contenedor.irAMenuInicial();
        });
    }

    private void cargarDatosATabla() {
        RegistroHunting[] datos = gestionReportes.leerAArreglo();
        llenarTabla(datos);
    }

    private void llenarTabla(RegistroHunting[] datos) {
        modeloTabla.setRowCount(0);

        for (RegistroHunting registro : datos) {
            if (registro != null) {
                
                Object[] fila = {
                    registro.getNombre(),
                    registro.getConfiguracion(), 
                    registro.getAciertos(),
                    registro.getFallos(),
                    registro.getFecha(),
                    registro.getHora()
                };
                
                modeloTabla.addRow(fila);
            }
        }
    }

    @Override
    public void doLayout() {
        super.doLayout();
        panelTitulo.setBounds(0, 0, getWidth(), 120);
        
        int anchoPanel = 900; 
        int altoPanel = 450;
        int x = (getWidth() - anchoPanel) / 2;
        int y = 150;
        
        panelContenido.setBounds(x, y, anchoPanel, altoPanel);
    }

    private void iniciarComponentes() {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
    }

    private void configurarPaneles() {
        panelTitulo.setBackground(Color.ORANGE);
        panelTitulo.setLayout(new BorderLayout());
        
        panelContenido.setLayout(null);
        panelContenido.setBackground(Color.DARK_GRAY);
    }

    private void configurarComponentes() {
        titulo.setText("REPORTES HUNTING");
        titulo.setFont(new Font("Arial", Font.BOLD, 40));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(JLabel.CENTER);

        scrollTabla.setBounds(0, 0, 900, 350);

        
        javax.swing.table.TableColumnModel columnModel = tablaDeDatos.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(120); 
        columnModel.getColumn(1).setPreferredWidth(300); 
        columnModel.getColumn(2).setPreferredWidth(80);  
        columnModel.getColumn(3).setPreferredWidth(80);  
        columnModel.getColumn(4).setPreferredWidth(100); 
        columnModel.getColumn(5).setPreferredWidth(80);  

        botonSalir.setBounds(0, 380, 150, 40);
        botonSalir.setBackground(Color.RED);
        botonSalir.setForeground(Color.WHITE);

        botonMayorAMenor.setBounds(200, 380, 300, 40);
        botonMayorAMenor.setBackground(Color.WHITE);

        botonMenorAMayor.setBounds(550, 380, 300, 40);
        botonMenorAMayor.setBackground(Color.WHITE);
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