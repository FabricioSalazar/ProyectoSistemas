/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.proyecto.gui;

import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.main.Main;
import com.ucr.proyecto.domain.Empleado;
import com.ucr.proyecto.util.Constantes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 *
 * @author Juan Carlos Mora B44540
 */
public class PanelDeControl extends javax.swing.JPanel {

    /**
     * Creates new form PanelDeControl
     */
    private String titular;
    private double saldo;
    private Empleado empleadoActual;
    private ArrayList<Empleado> empleados;
    private TablaTransacciones tablaTransacciones;
    private Transferencia transferencia;
    private Retiro retiro;
    private Timer timer;

    public PanelDeControl(Empleado empActual, ArrayList<Empleado> empleados) {
        initComponents();
        this.saldo = empActual.getSaldo();
        this.titular = empActual.getNombre();
        empleadoActual = empActual;
        this.empleados = empleados;

        jl_Titular.setText(titular);
        jl_Saldo.setText("Saldo Actual: " + saldo);
        jp_Transacciones.setBackground(Color.GRAY);
        
        transferencia= new Transferencia(empleados,empleadoActual,this);
        retiro = new Retiro(empActual, this);
        tablaTransacciones = new TablaTransacciones();
        
        timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaTransacciones.llenarTabla();
                timer.restart();
            }
        });
        timer.start();
        
        this.add(tablaTransacciones).setBounds(590, 60, 285, 310);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    JLabel jLabel2;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jp_Transacciones = new javax.swing.JPanel();
        rb_Transferencia = new javax.swing.JRadioButton();
        rb_Retiro = new javax.swing.JRadioButton();
        jp_Opciones = new javax.swing.JPanel();
        jl_Titular = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jl_Saldo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setText("Ultimos Movimientos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jp_Transacciones.setBackground(new java.awt.Color(102, 102, 102));

        rb_Transferencia.setBackground(new java.awt.Color(102, 102, 102));
        rb_Transferencia.setText("Transferencia");
        rb_Transferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_TransferenciaActionPerformed(evt);
            }
        });

        rb_Retiro.setBackground(new java.awt.Color(102, 102, 102));
        rb_Retiro.setText("Retiro");
        rb_Retiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_RetiroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_OpcionesLayout = new javax.swing.GroupLayout(jp_Opciones);
        jp_Opciones.setLayout(jp_OpcionesLayout);
        jp_OpcionesLayout.setHorizontalGroup(
            jp_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jp_OpcionesLayout.setVerticalGroup(
            jp_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jl_Titular.setForeground(new java.awt.Color(255, 255, 255));
        jl_Titular.setText("Titular");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jl_Saldo.setForeground(new java.awt.Color(255, 255, 255));
        jl_Saldo.setText("Saldo Actual: ");
        jPanel2.add(jl_Saldo);

        javax.swing.GroupLayout jp_TransaccionesLayout = new javax.swing.GroupLayout(jp_Transacciones);
        jp_Transacciones.setLayout(jp_TransaccionesLayout);
        jp_TransaccionesLayout.setHorizontalGroup(
            jp_TransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_TransaccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rb_Transferencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_Retiro)
                .addGap(41, 41, 41)
                .addComponent(jl_Titular, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jp_Opciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jp_TransaccionesLayout.setVerticalGroup(
            jp_TransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_TransaccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp_TransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_Transferencia)
                    .addComponent(rb_Retiro)
                    .addComponent(jl_Titular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Refrescar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_Transacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(338, 338, 338))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jp_Transacciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 11, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rb_TransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_TransferenciaActionPerformed
        rb_Retiro.setSelected(false);
        jp_Opciones.removeAll();
        jp_Opciones.setLayout(new BorderLayout());
        jp_Opciones.add(transferencia);
        Main.frame.setSize(900, 410);

    }//GEN-LAST:event_rb_TransferenciaActionPerformed

    private void rb_RetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_RetiroActionPerformed
        rb_Transferencia.setSelected(false);
        jp_Opciones.removeAll();
        jp_Opciones.setLayout(new BorderLayout());
        jp_Opciones.add(retiro);
        Main.frame.setSize(900, 414);
    }//GEN-LAST:event_rb_RetiroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Client cliente = new Client(5700, Constantes.ACTUALIZAR_LISTA);
        cliente.start();
        System.out.println("entro");
    }//GEN-LAST:event_jButton1ActionPerformed

    public void actualizaMonto(double monto){
        jl_Saldo.setText("Saldo actual: "+monto);
    }

    public double getMonto() {
        String saldo = jl_Saldo.getText();
        saldo = saldo.substring(saldo.lastIndexOf(" ")+1);
        return Double.parseDouble(saldo);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jl_Saldo;
    private javax.swing.JLabel jl_Titular;
    private javax.swing.JPanel jp_Opciones;
    private javax.swing.JPanel jp_Transacciones;
    private javax.swing.JRadioButton rb_Retiro;
    private javax.swing.JRadioButton rb_Transferencia;
    // End of variables declaration//GEN-END:variables
}
