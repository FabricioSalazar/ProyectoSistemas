/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.proyecto.gui;

import com.ucr.proyecto.domain.Empleado;
import com.ucr.proyecto.domain.Transaccion;
import com.ucr.proyecto.util.Constantes;
import java.util.Scanner;

/**
 *
 * @author Machito
 */
public class Console {

    private Scanner scan;
    private String usuario; 
    private String contrasena;
    
    
    public Console() {
        scan= new Scanner(System.in);
        usuario=null;
        contrasena=null;
    }

    // getters & setters
    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void inferfaz(){
        System.out.println("Bienvenidos al Sistema Transacional de la Cooperativa TrendNET S.A\n\n"
                           +"¿Deseas utilizar la aplicacion con interfaz grafica? (S/N)");
        String seleccion=scan.next();
        
        if(seleccion.equalsIgnoreCase("S")){
            //va el metodo de interfaz grafica
            System.out.println("Intergaz grafica");
        }else{
            interfazConsola();
        }
        
    }

    private void interfazConsola() {
        
        System.out.println("Por favor ingresa tu usuario");
        usuario=scan.next();
        System.out.println("Ingresa tu contrasena");
        contrasena=scan.next();
        
        Empleado empleado=new Empleado(usuario, contrasena);
        //validar que este empleado exista en la base de datos
        
        //if(){ si el empleado existe
            menuConsola();
        //}else{
//            System.out.println("Autentificacion incorrecta\n\n");
//            System.out.println("Gracias por utilizar nuestra aplicación");
//            System.exit(0);
        //}
        
    }
    
    private void menuConsola(){
        int opcion;
        String cuenta;
        String cuentaDestino;
        double cantidad;
        String funcion;
        String detalle;
        Transaccion transaccion;
        
        String menu="Bienvenido "+usuario+"\n\n"
                + "--------  MENU  -------\n"
                + "1- Acreditar tu cuenta\n"
                + "2- Debitar tu cuenta\n"
                + "3- Acreditar otra cuenta\n"
                + "4- Salir\n\n"
                + "Ingresa tu eleccion:";
        
        System.out.println(menu);
        opcion=scan.nextInt();
        
        switch(opcion){
            case 1:
                System.out.println("Por favor ingresa tu numero de cuenta:");
                cuenta=scan.next();
                System.out.println("Ingresa la cantidad a acreditar a tu cuenta");
                cantidad=scan.nextDouble();
                System.out.println("Ingresa un detalle acerca de la transacción");
                detalle=scan.next();
                funcion="acreditar";
                
                //se debe pasar el Empleado con la informacion desde la base
                Empleado emp=null;
                transaccion=new Transaccion(Constantes.empleadoNulo, cantidad, funcion,emp, detalle);
            break;
            case 2:
                System.out.println("Por favor ingresa tu numero de cuenta:");
                cuenta=scan.next();
                System.out.println("Ingresa la cantidad a debitar a tu cuenta");
                cantidad=scan.nextDouble();
                System.out.println("Ingresa un detalle acerca de la transacción");
                detalle=scan.next();
                funcion="debitar";
                
                //se debe pasar el Empleado con la informacion desde la base
                Empleado emp1=null;
                transaccion=new Transaccion(emp1, cantidad, funcion,Constantes.empleadoNulo, detalle);
            break;
            case 3:
                System.out.println("Por favor ingresa el numero de cuenta al cual quieres transferir el dinero:");
                cuenta=scan.next();
                System.out.println("Ingresa la cantidad a debitar a tu cuenta");
                cantidad=scan.nextDouble();
                System.out.println("Ingresa un detalle acerca de la transacción");
                detalle=scan.next();
                funcion="acreditarotracuenta";
                
                //se debe pasar el Empleado con la informacion desde la base
                Empleado emp2=null;
                
                //Se debe de traer la informacion del empleado de la cuenta que se ingreso
                Empleado emp3=null;
                transaccion=new Transaccion(emp2, cantidad, funcion,emp3, detalle);
            break;
            case 4:
                System.out.println("Gracias por utilizar nuestra aplicación");
                System.exit(0);
            break;
                
        }
                
                
    }
    
}
