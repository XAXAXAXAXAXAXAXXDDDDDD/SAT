package uebung01;

public class Spieler {

	private String name;
	private char spielzeichen;

	public Spieler(String name, char zeichen) {
		this.name = name;
		this.spielzeichen = zeichen;
	}

	public String getName() {
		return name;
	}

	public char getSpielzeichen() {
		return spielzeichen;
	}

	@Override
	public String toString() {
		return this.getName() + " (" + this.getSpielzeichen() + ") ";
	}
}
