/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.proyecto.util;

import com.ucr.proyecto.domain.Empleado;
import com.ucr.proyecto.domain.Transaccion;
import java.util.ArrayList;
import java.util.List;

public class Constantes {

    public static final String SERVER_IP = "localhost";
    public static final String CONEXION_ESTABLECIDA = "Conectado";

    public static final String ENVIAR_TRANSACCION = "Enviar";
    public static final String ENVIAR_TRANSACCION_ACREDITAR= "Enviar_Acreditar";
    public static final String ENVIAR_TRANSACCION_DEBITAR= "Enviar_Debitar";
    public static final String ENVIAR_TRANSACCION_ACREDITAR_OTRA_CUENTA= "Enviar_Acreditar_Otra_Cuenta";
    public static final String ACTUALIZACION_DE_ESTADOO = "NUEVO_ESTADO";
    public static final String VERIFICACION_DE_DATOS = "VERIFICAR_DATOS";
    public static final String VERIFICACION_DE_DATOS_CONSOLA = "VERIFICAR_DATOS_CONSOLA";
    public static final String WAIT_CLIENT = "EN_ESPERA";

    public static String MD5 = "MD5";

    public static Empleado empleadoNulo = new Empleado("No suministrado", "null", 0, "00000000", "No suministrado", 0);
    public static List<Transaccion> listaTransacciones = new ArrayList<>();
    
    public static boolean GUI=false;
}
