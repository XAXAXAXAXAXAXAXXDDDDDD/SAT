package uebung01;

import java.io.InputStream;
import java.io.PrintStream;

import uebung01.RechtecksSpielfeld.RowIsFullException;

/**
 * @author Torben Brodt
 * @version 1.1
 *
 *          <p />
 *          Spiel: Vier gewinnt
 *          <p />
 *          Funktioniert mit Java < 1.5
 *
 */
public class VierGewinnt implements KonsolenSpiel {

	private Spieler spieler_am_zug; // der aktuelle Spielername -> für die Gewinner Ausgabe
	private boolean isGameOver;

	private Spieler[] spieler;
	private RechtecksSpielfeld spielfeld;
	private IOHelper io_helper;

	public VierGewinnt(InputStream in, PrintStream out, PrintStream err) {
		io_helper = new IOHelper(in, out, err);
		spieler = new Spieler[2];
	}

	@Override
	public void determinePlayers() {
		// Abfragen des Spielernamens
		String player1_name = "";
		String player2_name = "";

		player1_name = io_helper.eingabeString("Name von SpielerIn A\t\t\t: ");

		do {
			player2_name = io_helper.eingabeString("Name von SpielerIn B\t\t\t: ");
		} while (player1_name.equals(player2_name)); // Frage erneut, wenn die Spielernamen gleich sind

		spieler[0] = new Spieler(player1_name, 'o');
		spieler[1] = new Spieler(player2_name, '+');
		spieler_am_zug = spieler[0];
	}

	@Override
	public void createSpielfeld() {
		int columns, rows = 0;
		// Abfragen der Maße
		do {
			columns = io_helper.eingabeInt("Breite des Spielfeldes (mindestens 4)\t: ");
		} while (columns < 4); // Frage erneut, wenn die Breite zu klein gewählt wurde

		do {
			rows = io_helper.eingabeInt("Hoehe des Spielfeldes (mindestens 4)\t: ");
		} while (rows < 4); // Frage erneut, wenn die Höhe zu klein gewählt wurde

		spielfeld = new RechtecksSpielfeld(columns, rows);
	}

	@Override
	public void play() {
		int zug_zaehler = 0, input_column;

		determinePlayers();
		createSpielfeld();

		int input_row = 1;
		int columns = spielfeld.getSpielfeldHeight();
		int rows = spielfeld.getSpielfeldWidth();

		while (zug_zaehler < columns * rows && !isGameOver()) {

			spieler_am_zug = spieler[zug_zaehler % 2];

			io_helper.WriteToOutput(spielfeld.showSpielfeld());

			input_column = io_helper.eingabeInt("\n" + spieler_am_zug + "ist am Zug. Bitte gib die Spalte ein: ");

			if (input_column > columns || input_column < 1) {
				io_helper.WriteToOutput("Feld existriert nicht.. Bitte versuch es nochmal!");
			} else {
				try {
					input_row = spielfeld.setzeFeld(input_column, spieler_am_zug.getSpielzeichen());
				} catch (RowIsFullException rE) {
					io_helper.WriteToOutput("Feld existriert nicht.. Bitte versuch es nochmal!");
					continue;
				}

				isGameOver = isZeichenWinner(input_row, input_column - 1, spieler_am_zug.getSpielzeichen());
				zug_zaehler++; // naechster ist am Zug
			}
		}

		io_helper.WriteToOutput(spielfeld.showSpielfeld());
		if (zug_zaehler == columns * rows && !isGameOver()) {
			isGameOver = true;
			io_helper.WriteToOutput("Unentschieden!");
		} else {
			io_helper.WriteToOutput("Spieler mit " + spieler_am_zug.getSpielzeichen() + "hat gewonnen");
		}
	}

	@Override
	public boolean isGameOver() {
		return isGameOver;
	}

	/**
	 * Sammelstelle für die Funktionen, die überprüfen ob jmd. gewonnen hat
	 * 
	 * @param column  -> die Spalte an der das Zeichen gesetzt wurde
	 * @param row     -> die Reihe an der das Zeichen gesetzt wurde
	 * @param zeichen -> das Zeichen
	 */
	private boolean isZeichenWinner(int column, int row, char zeichen) {
		boolean b1 = gameIsOver_row(column, row, zeichen);
		boolean b2 = gameIsOver_column(column, row, zeichen);
		boolean b3 = gameIsOver_straight1(column, row, zeichen);
		boolean b4 = gameIsOver_straight2(column, row, zeichen);

		return (b1 || b2 || b3 || b4);
	}

	private boolean gameIsOver_row(int column, int row, char zeichen) {
		// nach links
		int go = row - 1; // mit dem Punkt links neber dem gesetzten beginne ich
		int i = 1; // der gesetzte Punkt = 1 Treffer
		while (go >= 0) {
			if (this.spielfeld.getSpielfeld()[column][go] != zeichen)
				break;
			go--;
			i++;
		}

		// nach rechts
		go = row + 1;
		while (go < this.spielfeld.getSpielfeldWidth()) {
			if (this.spielfeld.getSpielfeld()[column][go] != zeichen)
				break;
			go++;
			i++;
		}

		return (i > 3);
	}

	private boolean gameIsOver_column(int column, int row, char zeichen) {
		// nach oben
		int go = column - 1;
		int i = 1;
		while (go >= 0) {
			if (this.spielfeld.getSpielfeld()[go][row] != zeichen)
				break;
			go--;
			i++;
		}

		// nach unten
		go = column + 1;
		while (go < this.spielfeld.getSpielfeldWidth()) {
			if (this.spielfeld.getSpielfeld()[go][row] != zeichen)
				break;
			go++;
			i++;
		}

		return (i > 3);
	}

	private boolean gameIsOver_straight1(int column, int row, char zeichen) {
		// nach links oben
		int go = row - 1;
		int go2 = column - 1;
		int i = 1;
		while (go >= 0 && go2 >= 0) {
			if (this.spielfeld.getSpielfeld()[go2][go] != zeichen)
				break;
			go--;
			go2--;
			i++;
		}

		// nach rechts unten
		go = row + 1;
		go2 = column + 1;
		while (go < this.spielfeld.getSpielfeldHeight() && go2 < this.spielfeld.getSpielfeldWidth()) {
			if (this.spielfeld.getSpielfeld()[go2][go] != zeichen)
				break;
			go++;
			go2++;
			i++;
		}

		return (i > 3);
	}

	private boolean gameIsOver_straight2(int column, int row, char zeichen) {
		// nach links unten
		int go = row - 1;
		int go2 = column + 1;
		int i = 1;
		while (go >= 0 && go2 < this.spielfeld.getSpielfeldWidth()) {
			if (this.spielfeld.getSpielfeld()[go2][go] != zeichen)
				break;
			go--;
			go2++;
			i++;
		}

		// nach rechts oben
		go = row + 1;
		go2 = column - 1;
		while (go < this.spielfeld.getSpielfeldHeight() && go2 >= 0) {
			if (this.spielfeld.getSpielfeld()[go2][go] != zeichen)
				break;
			go++;
			go2--;
			i++;
		}

		return (i > 3);
	}

	public static void main(String[] args) {
		VierGewinnt game = new VierGewinnt(System.in, System.out, System.out);
		game.play();
	}
}
