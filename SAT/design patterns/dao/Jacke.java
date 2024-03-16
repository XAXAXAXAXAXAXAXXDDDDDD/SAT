package dao;

public class Jacke extends Kleidungsstück {

	protected int wassersaeule;

	public Jacke(int artikelID, int breite, int hoehe, int tiefe, Ort eingelagerungsOrt, int kleidergroesse,
			String bezeichnung, String farbe, int wassersaeule) {
		super(artikelID, breite, hoehe, tiefe, eingelagerungsOrt, kleidergroesse, bezeichnung, farbe);
		this.wassersaeule = wassersaeule;
	}

	public int getWassersaeule() {
		return wassersaeule;
	}
	
	public void setWassersaeule(int wassersaeule) {
		this.wassersaeule = wassersaeule;
	}
	
	@Override
	public String toString() {
		return "Jacke [wassersaeule=" + wassersaeule + ", kleidergroesse=" + kleidergroesse + ", bezeichnung="
				+ bezeichnung + ", farbe=" + farbe + ", artikelID=" + artikelID + ", breite=" + breite + ", hoehe="
				+ hoehe + ", tiefe=" + tiefe + ", einlagerungsOrt=" + einlagerungsOrt + "]";
	}
}
