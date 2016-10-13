/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucr.proyecto.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class StringMD {

    private static String convertirAHexadecimal(byte[] digest) {
        String hash = "";

        for (byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }
            hash += Integer.toHexString(b);
        }
        return hash;
    }//convertirAHexadecimal

    public static String getStringMessageDigest(String message) {

        byte[] digest = null; //resumen
        try {
            byte[] buffer = message.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(Constantes.MD5);//Clase de java
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }//try-catch
        return convertirAHexadecimal(digest);
    }//getStringMessageDigest
    
    public static int getRandom(){
        Random rnd = new Random();

        // Se genera un número aleatorio entre 10000000 y 99999999 
        int random = 10000000 + rnd.nextInt(90000000);
        return random;
    }
}//fin claseMD
