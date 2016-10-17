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
import java.util.Calendar;
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
    private String respuesta;
    private Empleado empDestino;
    private Calendar calendario;

    public Console() {
        scan = new Scanner(System.in);
        calendario = Calendar.getInstance();
    }

    // getters & setters
    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public void verificarDatos() {
        System.out.println("\nPor favor ingresa tu usuario");
        String usuario = scan.next();
        System.out.println("Ingresa tu contrasena");
        String contrasena = StringMD.getStringMessageDigest(scan.next());

        Empleado emp = new Empleado(usuario, contrasena);
        Transaccion transaccion = new Transaccion(emp, Constantes.VERIFICACION_DE_DATOS_CONSOLA);

        Client c = new Client(5700, Constantes.VERIFICACION_DE_DATOS_CONSOLA, transaccion);
        c.start();
    }//verificarDatos()

    public void menuConsola(Empleado emp, ArrayList<Empleado> empleados) {
        int opcion;

        Transaccion transaccion;
        
        empleado=emp;
        this.empleados=empleados;
        
        String cuenta=empleado.getNumCuenta();

        String cuentaDestino;
        double cantidad;
        String funcion;
        String detalle;

        String infoEmpleado = "\n\nBienvid@ " + empleado.getNombre() + "\n"
                + "Tu saldo es de: " + empleado.getSaldo();

        String menu = "\n\n--------  MENU  -------\n"
                + "1- Acreditar tu cuenta\n"
                + "2- Debitar tu cuenta\n"
                + "3- Acreditar otra cuenta\n"
                + "4- Cerrar Sección\n"
                + "5- Salir\n\n"
                + "Ingresa tu eleccion:";

        System.out.println(infoEmpleado);
        System.out.println(menu);
        opcion = scan.nextInt();


        switch (opcion) {//Segun la opcion se piden los datos y se crean las transaciones que luego se envian en un cliente al servidor
            case 1:
                System.out.println("\nIngresa la cantidad a acreditar a tu cuenta");
                cantidad = scan.nextDouble();
                System.out.println("Ingresa un detalle acerca de la transacción");
                
                detalle = scan.next();
                funcion = "acreditar";

                transaccion = new Transaccion(Constantes.empleadoNulo, cantidad, funcion, empleado, detalle, calendario.getTime().toString());

                cliente = new Client(5700, Constantes.ENVIAR_TRANSACCION_ACREDITAR, transaccion);
                cliente.start();

                break;
            case 2:
                System.out.println("\nIngresa la cantidad a debitar a tu cuenta");
                cantidad = scan.nextDouble();
                System.out.println(cantidad);
                System.out.println("Ingresa un detalle acerca de la transacción");
                detalle = scan.next();
                funcion = "debitar";

                transaccion = new Transaccion(empleado, cantidad, funcion, Constantes.empleadoNulo, detalle, calendario.getTime().toString());

                cliente = new Client(5700, Constantes.ENVIAR_TRANSACCION_DEBITAR, transaccion);
                cliente.start();
                break;
            case 3:
                System.out.println("\nPor favor ingresa el numero de cuenta al cual quieres transferir el dinero:");
                cuentaDestino = scan.next();
                System.out.println("Ingresa la cantidad a debitar a tu cuenta");
                cantidad = scan.nextDouble();
                System.out.println("Ingresa un detalle acerca de la transacción");
                detalle = scan.next();
                funcion = "acreditarotracuenta";

                for (int i = 0; i < empleados.size(); i++) {
                    Empleado tempEmpleado = empleados.get(i);

                    if (tempEmpleado.getNumCuenta().equalsIgnoreCase(cuentaDestino)) {
                        empDestino = (Empleado) tempEmpleado;
                    }
                }

                transaccion = new Transaccion(empleado, cantidad, funcion, empDestino, detalle, calendario.getTime().toString());

                cliente = new Client(5700, Constantes.ENVIAR_TRANSACCION_ACREDITAR_OTRA_CUENTA, transaccion);
                cliente.start();
                break;
            case 4:
                empleado = null;
                verificarDatos();
                break;
            case 5:
                System.out.println("Gracias por utilizar nuestra aplicación");
                System.exit(0);
                break;
        } //switch     
    }//menuConsola()
}
