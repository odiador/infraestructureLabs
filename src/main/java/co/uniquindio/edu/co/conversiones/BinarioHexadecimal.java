package co.uniquindio.edu.co.conversiones;

import static co.uniquindio.edu.co.conversiones.Util.dividirCadenabits;

public class BinarioHexadecimal {
	private static final String LETRAS = "0123456789ABCDEF";

	public static String convertirBinarioHexa(String bin) {
		String[] bins = dividirCadenabits(bin, 4);
		StringBuilder sb = new StringBuilder();
		for (String four : bins) {
			int res = 0;
			for (int i = four.length() - 1; i >= 0; i--) {
				if (four.charAt(i) == '1') {
					res += (int) Math.pow(2, 3 - i);
				}
			}
			sb.append(LETRAS.charAt(res));
		}
		return sb.toString();
	}

}
