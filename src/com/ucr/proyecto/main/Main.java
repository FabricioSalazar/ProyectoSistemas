
package com.ucr.proyecto.main;

import com.ucr.proyecto.domain.Client;
import com.ucr.proyecto.util.Constantes;
import com.ucr.proyecto.domain.Empleado;
import com.ucr.proyecto.domain.Transaccion;
import com.ucr.proyecto.gui.Console;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Empleado empleado = new Empleado("juan", "asd32", 234567d, "I22334455", "Elver Galarga",1);
        Empleado empleado2 = new Empleado("oscar", "asd32", 234567d, "I22334455", "Elver Galarga",1);
        
        Transaccion transaccion = new Transaccion(empleado, 23400d, "debitar",empleado2,"Ahorro");
        new Client(5700, Constantes.ENVIAR_TRANSACCION, transaccion).start();  

    }

}
