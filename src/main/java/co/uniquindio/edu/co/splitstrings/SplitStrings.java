/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.uniquindio.edu.co.splitstrings;

import java.util.Arrays;

public class SplitStrings {
    
    public static String unirCadenas(String [] cadenas){
        String resultado = "";
        for(String eachCadena : cadenas) resultado += eachCadena;
        return resultado;
    }
    
    public static String[] separarCadena(String cadena, int [] tPartes){
        int suma = Arrays.stream(tPartes).sum();
        if(suma >  cadena.length()) return null;
        String [] arreglo = new String [tPartes.length+1];
        
        int pInicio = 0;
        int pFin = 0;
        
        for(int i = 0; i < tPartes.length; i++, pInicio = pFin){
            pFin = pFin + tPartes[i];
            arreglo[i] = cadena.substring(pInicio, pFin);
        }
        if(! (pFin == cadena.length())) return arreglo;
        
        arreglo[arreglo.length-1] = cadena.substring(pFin);
        return Arrays.copyOfRange(arreglo, 0, arreglo.length-1);
    }

    public static String[] generarCadena(int length, int... partes) {
        return separarCadena(generateString(length), partes);
    }

    public static String[] splitString(int tam, int n) {
        String cadena = generateString(tam);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {
            sb.append(cadena.charAt(i));
            if (i % n == n - 1)
                sb.append('-');
        }
        return sb.toString().split("-");
    }

    public static String generateString(int tam) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int aux = 0;
        String result = "";
        if (tam < alphabet.length()) {
            result = alphabet.substring(0, tam);
            return result;
        } else if (tam > alphabet.length()) {
            aux = tam - alphabet.length();
            result = alphabet + generateString(aux);
            return result;
        }
        return result;
    }

}
