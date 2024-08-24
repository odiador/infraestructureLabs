/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.uniquindio.edu.co.splitstrings;

import java.util.Arrays;

public class SplitStrings {

    public static void main(String[] args) {

        String cadena = "abcdefghijklmnop";
        int [] tam = {5, 9, 2};
        String [] segCadena = separarCadena(cadena, tam);
        
        for(String eachCadena : segCadena) System.out.println(eachCadena);

        String [] s5 = splitString(20, 5);
        System.out.println(Arrays.toString(s5));

        String [] s6 = splitString(30, 16);
        System.out.println(Arrays.toString(s6));

        System.out.println(unirCadenas(s6));
    }
    
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
        String[] resultado = new String[2];
        resultado[0] = cadena.substring(0, n);
        resultado[1] = cadena.substring(n);
        return resultado;
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
