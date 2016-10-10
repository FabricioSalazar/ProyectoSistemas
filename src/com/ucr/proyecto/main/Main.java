
package com.ucr.proyecto.main;

import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.domain.Constantes;
import com.ucr.proyecto.domain.Empleado;
import com.ucr.proyecto.domain.Transaccion;

public class Main {
//Hola Fabri
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan", "asd32", 234567d, "I22334455", "Elver Galarga");
        Transaccion transaccion = new Transaccion(empleado, 23400d, "debitar");
        new Client(5700, Constantes.ENVIAR_TRANSACCION, transaccion).start();
    }

}
