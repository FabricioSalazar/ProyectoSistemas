/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.proyecto.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread {

    private Socket socket;
    private final int PUERTO;
    private final String funcion;
    private Transaccion transaccion;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;

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
    public void run() {
        try {
            InetAddress direccionIP = InetAddress.getByName(Constantes.SERVER_IP);
            socket = new Socket(direccionIP, this.PUERTO);
            salida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());

            if (entrada.readUnshared().toString().equals(Constantes.CONEXION_ESTABLECIDA)) {
                switch (funcion) {
                    case Constantes.ENVIAR_TRANSACCION:
                        salida.writeObject(this.transaccion);
                        System.out.println(transaccion.toString());
                        break;
                }//switch

            }//if
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }//try-catch
    }//fin run

}
