package dao;

public class Artikel {

	protected int artikelID;

	protected int breite;
	protected int hoehe;
	protected int tiefe;

	protected Ort einlagerungsOrt;

	public Artikel(int artikelID, int breite, int hoehe, int tiefe, Ort eingelagerungsOrt) {
		super();
		this.artikelID = artikelID;
		this.breite = breite;
		this.hoehe = hoehe;
		this.tiefe = tiefe;
		this.einlagerungsOrt = eingelagerungsOrt;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public int getHoehe() {
		return hoehe;
	}

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

	public int getTiefe() {
		return tiefe;
	}

	public void setTiefe(int tiefe) {
		this.tiefe = tiefe;
	}

	public Ort getEinlagerungsOrt() {
		return einlagerungsOrt;
	}

	public void setEinlagerungsOrt(Ort eingelagerungsOrt) {
		this.einlagerungsOrt = eingelagerungsOrt;
	}

	public int getArtikelID() {
		return artikelID;
	}

	public boolean isEingelagert() {
		return getEinlagerungsOrt() != null;
	}

	@Override
	public String toString() {
		return "Artikel [artikelID=" + artikelID + ", breite=" + breite + ", hoehe=" + hoehe + ", tiefe=" + tiefe
				+ ", einlagerungsOrt=" + einlagerungsOrt + "]";
	}

}
