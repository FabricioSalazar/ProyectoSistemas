/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.proyecto.util;

import com.ucr.proyecto.domain.Empleado;

public class Constantes {

    public static final String SERVER_IP = "localhost";
    public static final String CONEXION_ESTABLECIDA = "Conectado";

    public static final String ENVIAR_TRANSACCION = "Enviar";
    public static final String ENVIAR_TRANSACCION_ACREDITAR= "Enviar_Acreditar";
    public static final String ACTUALIZACION_DE_ESTADOO = "Nuevo_estado";
    public static final String VERIFICACION_DE_DATOS = "VERIFICAR_DATOS";
    public static final String VERIFICACION_DE_DATOS_CONSOLA = "VERIFICAR_DATOS_CONSOLA";
    public static final String WAIT_CLIENT = "EN_ESPERA";

    public static String MD5 = "MD5";

    public static Empleado empleadoNulo = new Empleado("No suministrado", "null", 0, "00000000", "No suministrado", 0);

}
