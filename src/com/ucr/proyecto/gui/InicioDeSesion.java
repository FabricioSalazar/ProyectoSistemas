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
import com.ucr.proyecto.util.StringMD;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Juan Carlos Mora B44540
 */
public class InicioDeSesion extends javax.swing.JPanel implements KeyListener{

    /**
     * Creates new form InicioDeSesion
     */
    public static JLabel cargando;

    public InicioDeSesion() {
        initComponents();
        
        ImageIcon observador = new ImageIcon("src/com/ucr/proyecto/assets/loading.gif");
        jLabel3.setIcon(observador);
        observador.setImageObserver(jLabel3);// observador de imagen gif
        jLabel3.setVisible(false);
        
        text_Usuario.addKeyListener(this);
        text_Contrasena.addKeyListener(this);
    }

    private void verificarDatos() {
        jLabel3.setVisible(true);
        
        String contrasena = StringMD.getStringMessageDigest(text_Contrasena.getText());
        String usuario = text_Usuario.getText();

        Empleado empleado = new Empleado(usuario, contrasena);
        Transaccion transaccion = new Transaccion(empleado, Constantes.VERIFICACION_DE_DATOS);

        Client c = new Client(5700, Constantes.VERIFICACION_DE_DATOS, transaccion);
        c.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_ingreso = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        text_Usuario = new javax.swing.JTextField();
        text_Contrasena = new javax.swing.JPasswordField();
        button_Ingresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        label_ingreso.setText("                   Incio de sesion ");

        jLabel2.setText("Contraseña");

        jLabel1.setText("Usuario");

        text_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_UsuarioActionPerformed(evt);
            }
        });

        button_Ingresar.setText("Ingresar");
        button_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_IngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(text_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)))
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(button_Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(label_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(text_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(button_Ingresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void text_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_UsuarioActionPerformed

    private void button_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_IngresarActionPerformed
        verificarDatos();
    }//GEN-LAST:event_button_IngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel label_ingreso;
    private javax.swing.JPasswordField text_Contrasena;
    private javax.swing.JTextField text_Usuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            verificarDatos();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
