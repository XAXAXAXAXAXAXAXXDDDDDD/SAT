package composite;

public class Angestellter extends Mitarbeiter {

	public Angestellter(Abteilung abt, float g, String vn, String nn, int persNr, String zust) {
		super(abt, g, vn, nn, persNr, zust);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		System.out.println(this);
	}

	/*
	 * @Override public String toString() { return "Name: " + this.getNachname() +
	 * " " + this.getVorname() + " Personalnummer: " + this.getPersonalNr() +
	 * " Abteilung: " + this.getAbteilung() + " Zustaendigkeit: " +
	 * this.getZustaendigkeit() + " Gehalt: " + this.getGehalt(); }
	 */

}
