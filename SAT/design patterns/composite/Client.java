package composite;

public class Client {

	public static void main(String[] args) {

		// erstellung nicht über mitarbeiter sondern konkrete ausprägung
		// dokumentation über Klassendiagramm

		Abteilung medien = new Abteilung("MEDIEN");
		Abteilung management = new Abteilung("MANAGEMENT");

		Angestellter medien_angestellter1 = new Angestellter(medien, 2000.0f, "Peter", "Meyer", 32000,
				"Sachbearbeiter");
		Angestellter medien_angestellter2 = new Angestellter(medien, 2020.0f, "Konrad", "Schmitt", 30000,
				"Sachbearbeiter");

		// LinkedList<Mitarbeiter> medienMitarbeiter = new LinkedList<Mitarbeiter>();
		// medienMitarbeiter.add(medien_angestellter1);
		// medienMitarbeiter.add(medien_angestellter2);

		Chef medien_kappo = new Chef(medien, 4020.03f, "Lars", "FAUL", 304909, "Leiter Medienabteilung");
		medien_kappo.fuegeMitarbeiterHinzu(medien_angestellter1);
		medien_kappo.fuegeMitarbeiterHinzu(medien_angestellter2);
		// LinkedList<Mitarbeiter> unter_kappos = new LinkedList<Mitarbeiter>();
		// unter_kappos.add(medien_kappo);

		Chef ober_kappo = new Chef(management, 40239.39f, "Egon", "REICH", 258762, "Geschaeftsfuehrer");
		ober_kappo.fuegeMitarbeiterHinzu(medien_kappo);

		ober_kappo.print();
	}

}
