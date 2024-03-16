package dao;

public class ArtikelMapper {

	public ArtikelTO toDto(Artikel a) {
		ArtikelTO dto = null;
		
		String className = a.getClass().getCanonicalName();
		Ort ort = a.getEinlagerungsOrt();
		Integer ortID = ort == null ? null : ort.getOrtsID();

		if (Jeans.class.isInstance(a)) {
			Jeans je = Jeans.class.cast(a);
			dto = new ArtikelTO(je.getArtikelID(), je.getBreite(), je.getTiefe(), je.getHoehe(), je.getKleidergroesse(),
					je.getBezeichnung(), je.getFarbe(), je.getSchrittlaenge(), null, null, null, null, ortID,
					className);
		} else if (Jacke.class.isInstance(a)) {
			Jacke ja = Jacke.class.cast(a);
			dto = new ArtikelTO(ja.getArtikelID(), ja.getBreite(), ja.getTiefe(), ja.getHoehe(), ja.getKleidergroesse(),
					ja.getBezeichnung(), ja.getFarbe(), null, ja.getWassersaeule(), null, null, null, ortID, className);
		} else if (Schuhe.class.isInstance(a)) {
			Schuhe s = Schuhe.class.cast(a);
			dto = new ArtikelTO(s.getArtikelID(), s.getBreite(), s.getTiefe(), s.getHoehe(), null, null, null, null,
					null, s.getSchuhgroesse(), s.getObermaterial(), s.getAbsatzform(), ortID, className);
		} else if (Kleidungsstück.class.isInstance(a)) {
			Kleidungsstück kl = Kleidungsstück.class.cast(a);
			dto = new ArtikelTO(kl.getArtikelID(), kl.getBreite(), kl.getTiefe(), kl.getHoehe(), kl.getKleidergroesse(),
					kl.getBezeichnung(), kl.getFarbe(), null, null, null, null, null, ortID, className);
		} else {
			// type Artikel
			dto = new ArtikelTO(a.getArtikelID(), a.getBreite(), a.getTiefe(), a.getHoehe(), null, null, null, null,
					null, null, null, null, ortID, className);
		}

		return dto;
	}

	public Artikel toArtikel(ArtikelTO dto) {
		Artikel a = null;

		switch (dto.getTypeString()) {
		case "dao.Artikel":
			a = new Artikel(dto.getId(), dto.getBreite(), dto.getHoehe(), dto.getLaenge(), null);
			break;
		case "dao.Jeans":
			a = new Jeans(dto.getId(), dto.getBreite(), dto.getHoehe(), dto.getLaenge(), null, dto.getKleidergroesse(),
					dto.getBezeichnung(), dto.getFarbe(), dto.getSchrittlaenge());
			break;
		case "dao.Jacke":
			a = new Jacke(dto.getId(), dto.getBreite(), dto.getHoehe(), dto.getLaenge(), null, dto.getKleidergroesse(),
					dto.getBezeichnung(), dto.getFarbe(), dto.getWassersaeule());
			break;
		case "dao.Schuhe":
			a = new Schuhe(dto.getId(), dto.getBreite(), dto.getHoehe(), dto.getLaenge(), null, dto.getSchuhgroesse(),
					dto.getObermaterial(), dto.getAbsatzform());
			break;
		case "dao.Kleidungsstück":
			a = new Kleidungsstück(dto.getId(), dto.getBreite(), dto.getHoehe(), dto.getLaenge(), null,
					dto.getKleidergroesse(), dto.getBezeichnung(), dto.getFarbe());
			break;
		}

		return a;
	}
}
