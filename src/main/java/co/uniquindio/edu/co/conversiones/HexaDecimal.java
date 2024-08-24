package co.uniquindio.edu.co.conversiones;

public class HexaDecimal {

  public static int convertirHexaDecimal(String hexa) {
    return BinarioDecimal.convertirBinarioDecimal(HexaBinario.hexaToBinario(hexa));
  }
}
