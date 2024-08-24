package co.uniquindio.edu.co.conversiones;

/**
 * Convertir un entero decimal a binario, especificando el ancho en bits.
 */
public class DecimalBinario {
	public static String convertirDecToBin(int n, int bits) {
		if (n < 0 || bits < 0)
			throw new IllegalArgumentException("Ningun numero no puede ser negativo bro");
		if (n >= Math.pow(2, bits))
			throw new IllegalArgumentException("Sube la cantidad de bits bro");
		int num = n;
		StringBuilder sb = new StringBuilder();
		for (int i = bits - 1; i >= 0; i--) {
			final double pow = Math.pow(2, i);
			if (num >= pow) {
				sb.append('1');
				num -= pow;
			} else {
				sb.append('0');
			}
		}
		return sb.toString();
	}
}
