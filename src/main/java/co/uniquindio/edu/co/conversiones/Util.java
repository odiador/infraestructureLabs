package co.uniquindio.edu.co.conversiones;

public class Util {

	public static String[] dividirCadenabits(String bin, int c) {
		final int len = bin.length();
		if (len <= c)
			return new String[] { bin };
		final int mod = len % c;

		final StringBuilder sb = new StringBuilder();

		if (mod != 0) {
			for (int i = 0; i < c - mod; i++)
				sb.append('0');
			sb.append(bin.substring(0, mod) + '-');
		}

		for (int i = mod; i < len; i += c) {
			sb.append(bin.substring(i, (i + c < len) ? i + c : len));
			sb.append('-');
		}
		return sb.toString().split("-");
	}
}
