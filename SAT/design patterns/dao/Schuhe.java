package dao;

public class Schuhe extends Artikel {

	protected int schuhgroesse;
	protected String obermaterial;
	protected String absatzform;

	public Schuhe(int artikelID, int breite, int hoehe, int tiefe, Ort eingelagerungsOrt, int schuhgroesse,
			String obermaterial, String absatzform) {
		super(artikelID, breite, hoehe, tiefe, eingelagerungsOrt);
		this.schuhgroesse = schuhgroesse;
		this.obermaterial = obermaterial;
		this.absatzform = absatzform;
	}

	public int getSchuhgroesse() {
		return schuhgroesse;
	}

	public void setSchuhgroesse(int schuhgroesse) {
		this.schuhgroesse = schuhgroesse;
	}

	public String getObermaterial() {
		return obermaterial;
	}

	public void setObermaterial(String obermaterial) {
		this.obermaterial = obermaterial;
	}

	public String getAbsatzform() {
		return absatzform;
	}

	public void setAbsatzform(String absatzform) {
		this.absatzform = absatzform;
	}

	@Override
	public String toString() {
		return "Schuhe [schuhgroesse=" + schuhgroesse + ", obermaterial=" + obermaterial + ", absatzform=" + absatzform
				+ ", artikelID=" + artikelID + ", breite=" + breite + ", hoehe=" + hoehe + ", tiefe=" + tiefe
				+ ", einlagerungsOrt=" + einlagerungsOrt + "]";
	}

}
