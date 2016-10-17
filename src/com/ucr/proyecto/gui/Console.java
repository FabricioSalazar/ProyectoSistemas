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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Machito
 */
public class Console {

    private Scanner scan;
    private Empleado empleado;
    private ArrayList<Empleado> empleados;
    private Client cliente;
    public static String respuesta;
    public Console() {
        scan= new Scanner(System.in);
        empleado=null;
    }

    // getters & setters
    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }
    
    public void verificarDatos() {
        System.out.println("\nPor favor ingresa tu usuario");
        String usuario=scan.next();
        System.out.println("Ingresa tu contrasena");
        String contrasena=StringMD.getStringMessageDigest(scan.next());

        Empleado emp = new Empleado(usuario, contrasena);
        Transaccion transaccion = new Transaccion(emp, Constantes.VERIFICACION_DE_DATOS_CONSOLA);

        Client c = new Client(5700, Constantes.VERIFICACION_DE_DATOS_CONSOLA, transaccion);
        c.start();
    }
    
    public void menuConsola(Empleado emp, ArrayList<Empleado> empleados){
        int opcion;
        
        Transaccion transaccion;
        
        empleado=emp;
        empleados=empleados;
        
        String cuenta=empleado.getNumCuenta();
        String cuentaDestino;
        double cantidad;
        String funcion;
        String detalle;
        
        String infoEmpleado="\n\nBienvid@ "+empleado.getNombre()+"\n"
                            + "Tu saldo es de: "+empleado.getSaldo();
                
        String menu="\n\n--------  MENU  -------\n"
                + "1- Acreditar tu cuenta\n"
                + "2- Debitar tu cuenta\n"
                + "3- Acreditar otra cuenta\n"
                + "4- Cerrar Sección\n"
                + "5- Salir\n\n"
                + "Ingresa tu eleccion:";
        
        System.out.println(infoEmpleado);
        System.out.println(menu);
        opcion=scan.nextInt();
        
        switch(opcion){
            case 1:
                System.out.println("\nIngresa la cantidad a acreditar a tu cuenta");
                cantidad=scan.nextDouble();
                System.out.println("Ingresa un detalle acerca de la transacción");
                detalle=scan.next();
                funcion="acreditar";
                
                
                transaccion=new Transaccion(Constantes.empleadoNulo, cantidad, funcion,empleado, detalle);
                
                cliente=new Client(5700, Constantes.ENVIAR_TRANSACCION_ACREDITAR, transaccion);
                
                System.out.println(respuesta);
            break;
            case 2:
                System.out.println("\nIngresa la cantidad a debitar a tu cuenta");
                cantidad=scan.nextDouble();
                System.out.println("Ingresa un detalle acerca de la transacción");
                detalle=scan.next();
                funcion="debitar";
                
                transaccion=new Transaccion(empleado, cantidad, funcion,Constantes.empleadoNulo, detalle);
                
            break;
            case 3:
                System.out.println("\nPor favor ingresa el numero de cuenta al cual quieres transferir el dinero:");
                cuentaDestino=scan.next();
                System.out.println("Ingresa la cantidad a debitar a tu cuenta");
                cantidad=scan.nextDouble();
                System.out.println("Ingresa un detalle acerca de la transacción");
                detalle=scan.next();
                funcion="acreditarotracuenta";
                
                Empleado empDestino=null;
                for (int i = 1; i < empleados.size(); i++) {
                    Empleado tempEmpleado=empleados.get(i);
                    
                    if(tempEmpleado.getNumCuenta().equalsIgnoreCase(cuentaDestino)){
                        empDestino=tempEmpleado;
                    }
                }
                

                transaccion=new Transaccion(empleado, cantidad, funcion,empDestino, detalle);
                
            break;
            case 4:
                empleado=null;
                verificarDatos();
            break;
            case 5:
                System.out.println("Gracias por utilizar nuestra aplicación");
                System.exit(0);
            break;
                
        }
                
                
    }

    public static String respuestaServidor(String respuesta){
        return respuesta;
    }
}
