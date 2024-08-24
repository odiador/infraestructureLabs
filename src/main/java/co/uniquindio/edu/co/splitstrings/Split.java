package co.uniquindio.edu.co.splitstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Split {
    public static void main(String[] args) {

        String s1 = generateString(30);
        System.out.println(s1);

        String[] s2 = splitString(s1, 8);
        System.out.println(Arrays.toString(s2));
    }


    public static String generateString(int tam) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int aux = 0;
        String result = "";
        if(tam < alphabet.length()) {
            result = alphabet.substring(0, tam);
            return result;
        }else if(tam > alphabet.length()) {
            aux = tam - alphabet.length();
            result = alphabet + generateString(aux);
            return result;
        }
        return result;
    }

    public static String[] splitString(String cadena, int longitud) {
        // Crear un ArrayList para almacenar los segmentos
        List<String> segmentos = new ArrayList<>();

        // Dividir la cadena en segmentos de la longitud especificada
        for (int i = 0; i < cadena.length(); i += longitud) {
            int fin = Math.min(i + longitud, cadena.length());
            segmentos.add(cadena.substring(i, fin));
        }

        // Convertir el ArrayList a un arreglo de String y retornarlo
        return segmentos.toArray(new String[0]);
    }


}
