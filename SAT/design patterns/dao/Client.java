package dao;

import java.util.List;

public class Client {

	public static void main(String[] args) {
		SQLConnection con = null;
		try {
			con = new SQLConnection("SAT", "gast");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		OrtDao ortDAO = new OrtDao(con);
		List<Ort> alleOrte = ortDAO.retrieveAll();

		for (Ort o : alleOrte) {
			System.out.println(o);
		}

		ArtikelDao artikelDAO = new ArtikelDao(new ArtikelMapper(), con, ortDAO);
		List<Artikel> alleArtikel = artikelDAO.retrieveAll();

		for (Artikel a : alleArtikel) {
			System.out.println(a);
		}

		LagerSteuerung controller = new LagerSteuerung(ortDAO, artikelDAO);

		Ort naechsterFreierOrt = controller.ermittleEinenFreienOrt();
		System.out.println("Nächster freier Ort: " + naechsterFreierOrt);

		Artikel schuh1 = new Schuhe(1, 17, 35, 20, null, 40, "Leder", "spitz");
		schuh1.setEinlagerungsOrt(naechsterFreierOrt);

		if (artikelDAO.create(schuh1)) {
			schuh1 = artikelDAO.retrieve(schuh1.getArtikelID());
			System.out.println(schuh1);
		} else {
			System.out.println("Einfügen nicht möglich! Artikel bereits vorhanden.");
		}

		naechsterFreierOrt = controller.ermittleEinenFreienOrt();
		System.out.println("Nächster freier Ort: " + naechsterFreierOrt);
	}

}
