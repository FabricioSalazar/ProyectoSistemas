/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatess
 * and open the template in the editor.
 */
package com.ucr.proyecto.domain;

//Hola Juan
import com.ucr.proyecto.gui.Console;
import com.ucr.proyecto.main.Main;
import com.ucr.proyecto.util.Constantes;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Client extends Thread {

    //private Socket socket;
    private final int PUERTO;
    private String funcion;
    private Transaccion transaccion;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    private Console con = new Console();
    private String respuesta="";
    
    public Client(int puerto, String funcion) {
        super("Client");
        this.PUERTO = puerto;
        this.funcion = funcion;

    }

    // @param int puerto recibe el puerto, String Funcion la funcion a realizar como cliente, Transaccion La transaccion a enviar 
    public Client(int puerto, String funcion, Transaccion transaccion) {
        super("Client");
        this.PUERTO = puerto;
        this.funcion = funcion;
        this.transaccion = transaccion;
    }

    @Override
    public synchronized void run() {
        try {
            InetAddress direccionIP = InetAddress.getByName(Constantes.SERVER_IP);

            Socket socket = new Socket(direccionIP, this.PUERTO);
            salida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());

            salida.writeUTF(funcion);// 1) envio de la funcion al server
            switch (funcion) {
                case Constantes.ENVIAR_TRANSACCION:
                    salida.writeObject(this.transaccion);
                    break;
                case Constantes.WAIT_CLIENT:
                    break;
                case Constantes.VERIFICACION_DE_DATOS:
                    salida.writeObject(this.transaccion);
                    
                    salida.writeObject(transaccion.getEmpleado().getUsuario());
                    Constantes.listaTransacciones = (List<Transaccion>) entrada.readObject();
                    
                    Main.ingresoAutorizado((boolean) entrada.readObject(), (Empleado) entrada.readObject(), (ArrayList<Empleado>) entrada.readObject());
                    break;
                case Constantes.VERIFICACION_DE_DATOS_CONSOLA:
                    System.out.println("\nVerificando datos\nPor favor espere");
                    salida.writeObject(this.transaccion);
                    Main.ingresoAutorizadoConsola((boolean) entrada.readObject(), (Empleado) entrada.readObject(), (ArrayList<Empleado>) entrada.readObject());
                    
                    salida.writeObject(transaccion.getEmpleado().getUsuario());
                    Constantes.listaTransacciones = (List<Transaccion>) entrada.readObject();
                    break;
                case Constantes.ENVIAR_TRANSACCION_ACREDITAR://envia la transaccion y recibe el string si la transaccion se pudo realizar
                    salida.writeObject(this.transaccion);
                    respuesta=(String)entrada.readObject();
                    if(Constantes.GUI){
                        JOptionPane.showMessageDialog(null, respuesta);
                    }else{
                        System.out.println(respuesta);//imprime si la transaccion se realizo o no
                    }
                    salida.writeObject(transaccion.getEmpleado().getUsuario());
                    Constantes.listaTransacciones = (List<Transaccion>) entrada.readObject();
                    break;
                case Constantes.ENVIAR_TRANSACCION_DEBITAR://envia la transaccion y recibe el string si la transaccion se pudo realizar
                    salida.writeObject(this.transaccion);
                    respuesta=(String)entrada.readObject();
                    if(Constantes.GUI){
                        JOptionPane.showMessageDialog(null, respuesta);
                    }else{
                        System.out.println(respuesta);//imprime si la transaccion se realizo o no
                    }
                    
                    salida.writeObject(transaccion.getEmpleado().getUsuario());
                    Constantes.listaTransacciones = (List<Transaccion>) entrada.readObject();
                    break;
                case Constantes.ENVIAR_TRANSACCION_ACREDITAR_OTRA_CUENTA://envia la transaccion y recibe el string si la transaccion se pudo realizar
                    salida.writeObject(this.transaccion);
                    respuesta=(String)entrada.readObject();
                    if(Constantes.GUI){
                        JOptionPane.showMessageDialog(null, respuesta);
                    }else{
                        System.out.println(respuesta);//imprime si la transaccion se realizo o no
                    }
                    
                    salida.writeObject(transaccion.getEmpleado().getUsuario());
                    Constantes.listaTransacciones = (List<Transaccion>) entrada.readObject();
                    break;
                case Constantes.ACTUALIZAR_LISTA:
                    //salida.writeObject(this.transaccion);
                    salida.writeObject(transaccion.getEmpleado().getUsuario());
                    Constantes.listaTransacciones = (List<Transaccion>) entrada.readObject();
                    break;
                    
            }//switch

            salida.close();
            entrada.close();

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        //try-catch
    }//fin run
}
