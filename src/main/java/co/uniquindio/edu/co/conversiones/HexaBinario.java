package co.uniquindio.edu.co.conversiones;

public class HexaBinario {
	private static final String[] bins = {
		"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
		"1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
	};

	public static String hexaToBinario(String hexa) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < hexa.length(); i++) {
			char c = hexa.charAt(i);
			int index = obtenerNum(c);
			if (index == -1)
				throw new IllegalArgumentException("Bro, tienes un caracter que no sirve: " + c);

			sb.append(bins[index]);
		}

		return sb.toString();
	}



	private static int obtenerNum(char c) {
		if (c >= '0' && c  <= '9')
			return c - '0';

		if (c >= 'A' && c  <= 'F')
			return c - 'A' + 10;

		if (c >= 'a' && c  <= 'f')
			return c - 'a' + 10;
		return -1;
	}
}
