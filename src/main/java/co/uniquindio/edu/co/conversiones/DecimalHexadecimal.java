package co.uniquindio.edu.co.conversiones;

public class DecimalHexadecimal {
	public static String convertirDecimalHexadecimal(int dec, int bitsHexa) {
		return BinarioHexadecimal.convertirBinarioHexa(DecimalBinario.convertirDecToBin(dec, bitsHexa * 4));
	}
}
