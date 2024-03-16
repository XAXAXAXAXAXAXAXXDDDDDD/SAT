package dao;

public class Jeans extends Kleidungsstück {

	protected int schrittlaenge;

	public Jeans(int artikelID, int breite, int hoehe, int tiefe, Ort eingelagerungsOrt, int kleidergroesse,
			String bezeichnung, String farbe, int schrittlaenge) {
		super(artikelID, breite, hoehe, tiefe, eingelagerungsOrt, kleidergroesse, bezeichnung, farbe);
		this.schrittlaenge = schrittlaenge;
	}

	public int getSchrittlaenge() {
		return schrittlaenge;
	}

	public void setSchrittlaenge(int schrittlaenge) {
		this.schrittlaenge = schrittlaenge;
	}

	@Override
	public String toString() {
		return "Jeans [schrittlaenge=" + schrittlaenge + ", kleidergroesse=" + kleidergroesse + ", bezeichnung="
				+ bezeichnung + ", farbe=" + farbe + ", artikelID=" + artikelID + ", breite=" + breite + ", hoehe="
				+ hoehe + ", tiefe=" + tiefe + ", einlagerungsOrt=" + einlagerungsOrt + "]";
	}

}
