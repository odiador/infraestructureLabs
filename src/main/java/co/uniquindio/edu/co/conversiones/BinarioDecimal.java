package co.uniquindio.edu.co.conversiones;

public class BinarioDecimal {
	public static int convertirBinarioDecimal(String bin) {
		int result = 0;
		for (int i = bin.length() - 1; i >= 0; i--) {
			if (bin.charAt(i) == '1') {
				result += (int) Math.pow(2, bin.length() - 1 - i);
			}
		}
		return result;
	}

}
