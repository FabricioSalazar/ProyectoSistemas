/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.proyecto.gui;

import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.domain.Empleado;
import com.ucr.proyecto.util.Constantes;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Juan Carlos Mora B44540
 */
public class Main {

    public static JFrame frame;
    private static InicioDeSesion inicioDeSesion;
    private static PanelDeControl panelDeControl;
    private static Scanner scan;
    private static Console console;

    
    public static void main(String args[]) {
        scan=new Scanner(System.in);
        console=new Console();
        
        System.out.println("Bienvenidos al Sistema Transacional de la Cooperativa TrendNET S.A\n\n"
                + "¿Deseas utilizar la aplicacion con interfaz grafica? (S/N)");
        String seleccion = scan.next();

        if (seleccion.equalsIgnoreCase("S")) {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame = new JFrame();
                    frame.setVisible(true);
                    inicioDeSesion = new InicioDeSesion();
                    frame.add(inicioDeSesion);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                }
            });
        } else {
            console.verificarDatos();
        }
    }
    //si se autoriza el ingreso se accede a la pantalla para administrar la cuenta

    public static void ingresoAutorizado(boolean autorizacion, Empleado emp, ArrayList<Empleado> empleados) {
        if (autorizacion) {         
            frame.remove(inicioDeSesion);
            panelDeControl = new PanelDeControl(emp,empleados);
            frame.add(panelDeControl);
            frame.setSize(900, 415);
        } else {
            InicioDeSesion.label_ingreso.setForeground(Color.red);
            InicioDeSesion.label_ingreso.setText("Los datos ingresados son incorrectos");
            InicioDeSesion.label_ingreso.repaint();
            InicioDeSesion.jLabel3.setVisible(false);
        }
    }
    
    public static void ingresoAutorizadoConsola(boolean autorizacion, Empleado emp, ArrayList<Empleado> empleados) {
        if (autorizacion) {         
            console.menuConsola(emp,empleados);
        }else{
            System.out.println("Autentificacion incorrecta\n\n");
            System.out.println("Gracias por utilizar nuestra aplicación");
            System.exit(0);
        }
    }
    
    
}
