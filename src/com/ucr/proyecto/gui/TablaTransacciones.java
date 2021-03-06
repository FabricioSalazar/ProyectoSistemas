package com.ucr.proyecto.gui;

import com.ucr.proyecto.util.Constantes;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Nelson
 */
public class TablaTransacciones extends JPanel {
    private DefaultTableModel modeloTabla;   
    private JTable tabla;
    private final String[] encabezado = {"Fecha", "Función", "Cantidad"};
    private String [][] data = {{"Cargando datos", "", ""}};
    
    public TablaTransacciones() {
        iniciar();
    }

    private void iniciar() {
        this.setLayout(null);
        modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tabla = new JTable(data, encabezado) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                Component comp = super.prepareRenderer(renderer, row, col);
                Object value = getModel().getValueAt(row, 1);
                if (value.equals("debitar")) {
                    comp.setBackground(Color.red);
                } else if (value.equals("acreditar")) {
                    comp.setBackground(Color.green);
                } else if (value.equals("ahorroautomatico")){
                    comp.setBackground(Color.orange);
                } else {
                    comp.setBackground(Color.WHITE);
                }
                return comp;
            }
        };

        tabla.setModel(modeloTabla);
        tabla.setAutoCreateRowSorter(true);

        tabla.setFillsViewportHeight(true);
        tabla.setGridColor(Color.black);
        tabla.setCellSelectionEnabled(true);

        JScrollPane scrollPane = new JScrollPane(tabla);
        this.add(scrollPane).setBounds(0, 0, 285, 310);
        llenarTabla();
    }
    
    public void llenarTabla() {
        if (!Constantes.listaTransacciones.isEmpty()) {
            data = new String[Constantes.listaTransacciones.size()][3];
            for (int i = 0; i < Constantes.listaTransacciones.size(); i++) {
                data[i][0] = Constantes.listaTransacciones.get(i).getFecha();
                data[i][1] = Constantes.listaTransacciones.get(i).getFuncion();
                data[i][2] = Constantes.listaTransacciones.get(i).getCantidad() + "";
            }
            modeloTabla.setDataVector(data, encabezado);
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        }
    }
}