package tdd;

public class Utilities {

	private static final int MAX_TEXT_LENGTH = 140;

	public static String shortenText(String s) {

		if (s == null || s.length() == 0) {
			throw new IllegalArgumentException("Invalid input!");
		}

		if (s.length() <= MAX_TEXT_LENGTH) {
			// text fits in preview
			return s;
		}

		// search for next white space character
		int i = MAX_TEXT_LENGTH /*- 3*/;
		while (i >= 0 && !Character.isWhitespace(s.charAt(i))) {
			i--;
		}

		if (i < 0) {
			return s.substring(0, MAX_TEXT_LENGTH) + "...";
		}

		if (i > 0 && (s.charAt(i - 1) == '.' || s.charAt(i - 1) == ',')) {
			return s.substring(0, i - 1) + "...";
		}

		return s.substring(0, i) + "...";
	}

	public static String prepareStringForUrl(String s) {
		// Überprüfen, ob übergebene String leer ist
		if (s.isEmpty())
			return null;

		// wandelt alle ?, &, # in Strings um
		s = s.replaceAll("\\?", "qm").replaceAll("&", "amp").replaceAll("#", "hash");

		// Buchstaben, Ziffern, (-), Leer-/und andere Sonderzeichen durch '-' ersetzen
		s = s.replaceAll("[^a-zA-Z0-9-]", "-");

		/*
		 * andere Möglichkeit: StringBuilder sb = new StringBuilder(); for (char c :
		 * s.toCharArray()) { if (Character.isLetterOrDigit(c) || c == '-') {
		 * sb.append(c); } else { sb.append("-"); } } s = sb.toString();
		 */

		// keine aufeinanderfolgenden Min^^^^uszeichen (bei mind. 2 --)
		s = s.replaceAll("-{2,}", "-");

		// kleinbuchstaben konvertieren
		s = s.toLowerCase();

		// Minuszeichen Anfang und Ende entfernen
		// Anfang
		if (s.startsWith("-"))
			s = s.substring(1);

		// Ende
		if (s.endsWith("-"))
			s = s.substring(0, s.length() - 1);

		return s;
	}

	public static void main(String[] args) {

	}
}
