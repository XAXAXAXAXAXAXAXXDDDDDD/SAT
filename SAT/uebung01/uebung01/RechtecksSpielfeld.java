package uebung01;

public class RechtecksSpielfeld {

	private char[][] spielfeld;

	public RechtecksSpielfeld(int width, int height) {
		spielfeld = new char[height][width];
	}

	/**
	 * Spalte wird übergeben und das Feld wird gesetzt
	 * 
	 * @param column  -> eingegebene Spalte
	 * @param zeichen -> jeder Spieler hat ein Zeichen (*) oder (+)
	 */
	public int setzeFeld(int column, char zeichen) throws RowIsFullException {
		column--; // Weil der gemeine Mensch denkt, der Zahlenbereich würde sich von 1 bis 4
					// erstrecken
		int pos2check;
		if (spielfeld[0][column] != '\0') {
			throw new RowIsFullException();
		}
		
		for (int i = 0; i < spielfeld.length; i++) { // Iteriere durch die Zeilen
			if (i + 1 == spielfeld.length) {
				// Nach der letzten Zeile kommt nichts mehr..
				// also darf in das aktuelle Kästchen geschrieben werden, obwohl im
				// nächsten nichts steht
				pos2check = i;
				if (spielfeld[pos2check][column] == '\0') {
					spielfeld[i][column] = zeichen;
					return i;
				}
			} else {
				// Überprüfe immer das folgende Feld
				pos2check = i + 1;
				if (spielfeld[pos2check][column] != '\0') {
					spielfeld[i][column] = zeichen;
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Zeigt das komplette Spielfeld auf dem Bildschirm
	 * 
	 * @param spielfeld -> Das Spielfeld mit allen benötigten Daten
	 */
	public String showSpielfeld() {
		String result = "";
		StringBuffer Geruest = new StringBuffer();
		StringBuffer row_start = new StringBuffer(" "); // erste Zeile 1 2 3 4
		StringBuffer row_divide = new StringBuffer("|"); // Trennzeile |-----|
		StringBuffer row_end = new StringBuffer("-"); // letzte Zeile -------

		if (spielfeld[0].length > 9) {
			for (int i = 1; i <= spielfeld[0].length; i++)
				row_start.append((i / 10 == 0) ? " " : i / 10).append(" ");
			row_start.append("\n ");
		}
		for (int i = 1; i <= spielfeld[0].length; i++) {
			row_start.append(i % 10).append(" ");
			row_divide.append((i == spielfeld[0].length) ? "-|" : "--");
			row_end.append("--");
		}
		result += row_start.toString() + System.lineSeparator();
		result += row_divide.toString() + System.lineSeparator();

		for (char[] arrZeile : spielfeld) { // iteriere durch alle Zeilen
			for (char arrSpalte : arrZeile) { // iteriere durch alle Spalten
				Geruest.append("|");
				Geruest.append((arrSpalte == '\0') ? ' ' : arrSpalte);
			}
			Geruest.append("|\n");
		}
		Geruest.append(row_end).append("\n");
		result += Geruest.toString() + System.lineSeparator();

		return result;
	}

	public int getSpielfeldWidth() {
		return spielfeld.length;
	}

	public int getSpielfeldHeight() {
		return spielfeld[0].length;
	}

	public char[][] getSpielfeld() {
		return spielfeld;
	}

	public class RowIsFullException extends Exception {

		private static final long serialVersionUID = -1192063574840542972L;

		public RowIsFullException() {
		}

		public RowIsFullException(String message) {
			super(message);
		}
	}
}
