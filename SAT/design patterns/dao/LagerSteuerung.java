package dao;

import java.util.*;

public class LagerSteuerung {

	protected OrtDao ortDAO;
	protected ArtikelDao artikelDAO;

	public LagerSteuerung(OrtDao ortDAO, ArtikelDao artikelDAO) {
		this.ortDAO = ortDAO;
		this.artikelDAO = artikelDAO;
	}

	public Ort ermittleEinenFreienOrt() {
		List<Ort> allOrte = ortDAO.retrieveAll();
		List<Artikel> allArtikel = artikelDAO.retrieveAll();

		if (allOrte == null || allArtikel == null) {
			throw new UnsupportedOperationException("Konnte keine Orte oder Artikel ermitteln!");
		}

		HashMap<Integer, Artikel> ortIDToArtikel = new HashMap<Integer, Artikel>(allArtikel.size());

		for (Artikel a : allArtikel) {
			if (a.getEinlagerungsOrt() == null) {
				continue;
			}

			ortIDToArtikel.put(a.getEinlagerungsOrt().getOrtsID(), a);
		}

		for (Ort o : allOrte) {
			if (!ortIDToArtikel.containsKey(o.getOrtsID())) {
				return o;
			}
		}

		return null;
	}

}
