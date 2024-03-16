package dao;

public class Kleidungsstück extends Artikel {

	protected int kleidergroesse;
	protected String bezeichnung;
	protected String farbe;

	public Kleidungsstück(int artikelID, int breite, int hoehe, int tiefe, Ort eingelagerungsOrt, int kleidergroesse,
			String bezeichnung, String farbe) {
		super(artikelID, breite, hoehe, tiefe, eingelagerungsOrt);
		this.kleidergroesse = kleidergroesse;
		this.bezeichnung = bezeichnung;
		this.farbe = farbe;
	}

	public int getKleidergroesse() {
		return kleidergroesse;
	}

	public void setKleidergroesse(int kleidergroesse) {
		this.kleidergroesse = kleidergroesse;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	@Override
	public String toString() {
		return "Kleidungsstück [kleidergroesse=" + kleidergroesse + ", bezeichnung=" + bezeichnung + ", farbe=" + farbe
				+ ", artikelID=" + artikelID + ", breite=" + breite + ", hoehe=" + hoehe + ", tiefe=" + tiefe
				+ ", einlagerungsOrt=" + einlagerungsOrt + "]";
	}

}
