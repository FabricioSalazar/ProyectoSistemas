/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.proyecto.main;

import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.domain.Constantes;
import com.ucr.proyecto.domain.Empleado;
import com.ucr.proyecto.domain.Transaccion;

/**
 *
 * @author Juan Carlos Mora B44540
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan", "asd32", 234567d, "I22334455", "Juan Carlos Mora");
        Transaccion transaccion = new Transaccion(empleado, 23400d, "debitar");
        new Client(5700, Constantes.ENVIAR_TRANSACCION, transaccion).start();
    }

}
