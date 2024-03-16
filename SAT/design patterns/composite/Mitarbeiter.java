package composite;

public abstract class Mitarbeiter {

	// besser als Interface und getter und setter in den jeweiligen Unterklassen?

	private Abteilung abteilung;
	private float gehalt;
	private String vorname;
	private String nachname;
	private int personalNr;
	private String zustaendigkeit;

	public Mitarbeiter(Abteilung abt, float g, String vn, String nn, int persNr, String zust) {
		this.abteilung = abt;
		this.gehalt = g;
		this.vorname = vn;
		this.nachname = nn;
		this.personalNr = persNr;
		this.zustaendigkeit = zust;
	}

	public Abteilung getAbteilung() {
		return abteilung;
	}

	public void setAbteilung(Abteilung abteilung) {
		this.abteilung = abteilung;
	}

	public float getGehalt() {
		return gehalt;
	}

	public void setGehalt(float gehalt) {
		this.gehalt = gehalt;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public int getPersonalNr() {
		return personalNr;
	}

	public void setPersonalNr(int personalNr) {
		this.personalNr = personalNr;
	}

	public String getZustaendigkeit() {
		return zustaendigkeit;
	}

	public void setZustaendigkeit(String zustaendigkeit) {
		this.zustaendigkeit = zustaendigkeit;
	}

	public abstract void print();

	@Override
	public String toString() {
		return "Name: " + this.getNachname() + " " + this.getVorname() + " Personalnummer: " + this.getPersonalNr()
				+ " Abteilung: " + this.getAbteilung() + " Zustaendigkeit: " + this.getZustaendigkeit() + " Gehalt: "
				+ this.getGehalt();
	}
}
