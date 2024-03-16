package composite;

import java.util.LinkedList;

public class Chef extends Mitarbeiter {

	public Chef(Abteilung abt, float g, String vn, String nn, int persNr, String zust) {
		super(abt, g, vn, nn, persNr, zust);

		this.zugeordneteMitarbeiter = new LinkedList<Mitarbeiter>();
	}

	private LinkedList<Mitarbeiter> zugeordneteMitarbeiter;

	@Override
	public void print() {
		System.out.print(this);
		System.out.print(" Zugeordnete Mitarbeiter:" + System.lineSeparator() + "[" + System.lineSeparator());
		for (Mitarbeiter m : zugeordneteMitarbeiter) {
			System.out.print("\t");
			m.print();
		}
		System.out.print("]");
	}

	public boolean fuegeMitarbeiterHinzu(Mitarbeiter m) {
		return zugeordneteMitarbeiter.add(m);
	}

	public boolean entferneMitarbeiter(Mitarbeiter m) {
		return zugeordneteMitarbeiter.remove(m);
	}

	/*
	 * @Override public String toString() { return "Name: " + this.getNachname() +
	 * " " + this.getVorname() + " Personalnummer: " + this.getPersonalNr() +
	 * " Abteilung: " + this.getAbteilung() + " Zustaendigkeit: " +
	 * this.getZustaendigkeit() + " Gehalt: " + this.getGehalt(); }
	 */

}
