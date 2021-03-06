/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.proyecto.gui;

import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.domain.Empleado;
import com.ucr.proyecto.domain.Transaccion;
import com.ucr.proyecto.util.Constantes;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Juan Carlos Mora B44540
 */
public class Transferencia extends javax.swing.JPanel {

    /**
     * Creates new form Transferencia
     *
     * @param empleados
     * @param empAct
     */
    private ArrayList<Empleado> empleados;
    private Empleado empAct;
    private Empleado empDest;
    private PanelDeControl p;
    private Calendar calendario;
    
    public Transferencia(ArrayList<Empleado> empleados, Empleado empAct, PanelDeControl p) {
        initComponents();
        jb_cuentas.removeAllItems();
        jl_cuenta.setText("No Cuenta: "+empAct.getNumCuenta());
        cargarCuentas(empleados, empAct);
        this.empleados = empleados;
        this.empAct = empAct;
        this.p = p;
        
    }

    private void cargarCuentas(ArrayList<Empleado> empleados, Empleado emp) {
        String nombreUsuarios;
        for (Empleado empleado : empleados) {
            if (!emp.getNumCuenta().equals(empleado.getNumCuenta())) {
                nombreUsuarios = empleado.getNombre()+" "+empleado.getNumCuenta();
                jb_cuentas.addItem(nombreUsuarios);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jl_cuenta = new javax.swing.JLabel();
        jb_cuentas = new javax.swing.JComboBox<>();
        jb_transferir = new javax.swing.JButton();
        jtf_monto = new javax.swing.JTextField();
        jtf_detalle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jl_cuenta.setText("Cuenta Num:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_cuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jl_cuenta)
                .addContainerGap())
        );

        jb_cuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jb_cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cuentasActionPerformed(evt);
            }
        });

        jb_transferir.setText("Transferir");
        jb_transferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_transferirActionPerformed(evt);
            }
        });

        jtf_monto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_montoActionPerformed(evt);
            }
        });

        jtf_detalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_detalleActionPerformed(evt);
            }
        });

        jLabel1.setText("Monto:");

        jLabel2.setText("Detalle:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtf_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jb_cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(107, 107, 107)
                                    .addComponent(jLabel1)
                                    .addGap(110, 110, 110))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jtf_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addComponent(jb_transferir))))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jb_cuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_transferir)
                        .addComponent(jtf_monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_montoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_montoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_montoActionPerformed

    private void jb_transferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_transferirActionPerformed
        if(jtf_monto.getText().equals("")) return;
        double monto = Double.parseDouble(jtf_monto.getText());
        calendario = Calendar.getInstance();
        Transaccion t = new Transaccion(empAct,
                monto,
                "acreditarotracuenta",
                getEmpleadoSeleccionado(), jtf_detalle.getText(), calendario.getTime().toString());
        
        new Client(5700, Constantes.ENVIAR_TRANSACCION_ACREDITAR_OTRA_CUENTA, t)
                .start();
        
        
        if (p.getMonto() >= monto) {
            p.actualizaMonto(p.getMonto()-monto);
        }
        
        jtf_detalle.setText("");
        jtf_monto.setText("");
    }//GEN-LAST:event_jb_transferirActionPerformed

    private void jtf_detalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_detalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_detalleActionPerformed

    private void jb_cuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cuentasActionPerformed

    }//GEN-LAST:event_jb_cuentasActionPerformed

    private Empleado getEmpleadoSeleccionado(){
        String emp = jb_cuentas.getSelectedItem().toString();
        emp = emp.substring(emp.lastIndexOf(" ")+1);
        Empleado empSelected = null;
        for(Empleado e: empleados){
            if (e.getNumCuenta().equals(emp)){
                empSelected = e;
            }
        }
        return empSelected;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jb_cuentas;
    private javax.swing.JButton jb_transferir;
    private javax.swing.JLabel jl_cuenta;
    private javax.swing.JTextField jtf_detalle;
    private javax.swing.JTextField jtf_monto;
    // End of variables declaration//GEN-END:variables
}
