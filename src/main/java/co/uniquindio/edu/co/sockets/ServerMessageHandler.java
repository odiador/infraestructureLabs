package co.uniquindio.edu.co.sockets;

import java.util.Arrays;

import co.uniquindio.edu.co.conversiones.BinarioHexadecimal;
import co.uniquindio.edu.co.conversiones.DecimalBinario;
import co.uniquindio.edu.co.conversiones.DecimalHexadecimal;
import co.uniquindio.edu.co.splitstrings.SplitStrings;

public class ServerMessageHandler {
    public static String handleMessage(String message) {
        if (message.trim().isEmpty())
            return "Bro no enviaste un mensaje";

        String[] tokens = message.trim().split(" ");
        // CONV-DEC-BIN 189 8
        if (tokens[0].equalsIgnoreCase("CONV-DEC-BIN")) {
            try {
                return DecimalBinario.convertirDecToBin(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                return "CONV-DEC-BIN <integer> <integer>";
            }
        }
        // CONV-DEC-HEX 10111101
        if (tokens[0].equalsIgnoreCase("CONV-DEC-HEX")) {
            try {
                return DecimalHexadecimal.convertirDecimalHexadecimal(Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]));
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                return "CONV-DEC-HEX <integer> <integer>";
            }
        }
        // CONV-BIN-HEXA 10111101
        if (tokens[0].equalsIgnoreCase("CONV-BIN-HEXA")) {
            try {
                return BinarioHexadecimal.convertirBinarioHexa(tokens[1]);
            } catch (IndexOutOfBoundsException e) {
                return "CONV-BIN-HEXA <binario>";
            }
        }
        if (tokens[0].equalsIgnoreCase("GEN-CAD")) {
            // GEN-CAD 15
            if (tokens.length == 2) {
                try {
                    return SplitStrings.generateString(Integer.parseInt(tokens[1]));
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    return "GEN-CAD <integer> <integer>(optional) ";
                }
                // GEN-CAD 32 8
            } else if (tokens.length == 3) {
                try {
                    return String.join(", ",
                            SplitStrings.splitString(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    return "GEN-CAD <integer> <integer>(optional) ";
                }
            } else {
                return "GEN-CAD <integer> <integer>(optional) ";
            }
        }
        // CAD-SEG 16 5 9 2
        if (tokens[0].equalsIgnoreCase("CAD-SEG")) {
            try {
                int[] tams = Arrays.stream(Arrays.copyOfRange(tokens, 2, tokens.length))
                        .mapToInt((s) -> Integer.parseInt(s)).toArray();
                String[] result = SplitStrings.generarCadena(Integer.parseInt(tokens[1]), tams);
                return result == null ? "CAD-SEG <arg0: integer> <integer... (sum of arg0)>" : String.join(" ", result);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                return "CAD-SEG <arg0: integer> <integer... (sum of arg0)>";
            }
        }
        // UNI-CAD <string...>
        if (tokens[0].equalsIgnoreCase("UNI-CAD")) {
            try {
                String[] cadenas = Arrays.copyOfRange(tokens, 1, tokens.length);
                return SplitStrings.unirCadenas(cadenas);
            } catch (IndexOutOfBoundsException e) {
                return "UNI-CAD <string...>";
            }
        }
        return "Comando desconocido";
    }
}
