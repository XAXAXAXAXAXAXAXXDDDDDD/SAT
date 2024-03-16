package dao;

public class ArtikelTO {

	protected Integer id;
	protected Integer laenge;
	protected Integer breite;
	protected Integer hoehe;
	protected Integer kleidergroesse;
	protected String bezeichnung;
	protected String farbe;
	protected Integer schrittlaenge;
	protected Integer wassersaeule;
	protected Integer schuhgroesse;
	protected String obermaterial;
	protected String absatzform;

	protected Integer ortID;

	protected String typeString;

	public ArtikelTO(Integer id, Integer laenge, Integer breite, Integer hoehe, Integer kleidergroesse,
			String bezeichnung, String farbe, Integer schrittlaenge, Integer wassersaeule, Integer schuhgroesse,
			String obermaterial, String absatzform, Integer ortID, String typeString) {
		super();
		this.id = id;
		this.laenge = laenge;
		this.breite = breite;
		this.hoehe = hoehe;
		this.kleidergroesse = kleidergroesse;
		this.bezeichnung = bezeichnung;
		this.farbe = farbe;
		this.schrittlaenge = schrittlaenge;
		this.wassersaeule = wassersaeule;
		this.schuhgroesse = schuhgroesse;
		this.obermaterial = obermaterial;
		this.absatzform = absatzform;
		this.ortID = ortID;
		this.typeString = typeString;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLaenge() {
		return laenge;
	}

	public void setLaenge(Integer laenge) {
		this.laenge = laenge;
	}

	public Integer getBreite() {
		return breite;
	}

	public void setBreite(Integer breite) {
		this.breite = breite;
	}

	public Integer getHoehe() {
		return hoehe;
	}

	public void setHoehe(Integer hoehe) {
		this.hoehe = hoehe;
	}

	public Integer getKleidergroesse() {
		return kleidergroesse;
	}

	public void setKleidergroesse(Integer kleidergroesse) {
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

	public Integer getSchrittlaenge() {
		return schrittlaenge;
	}

	public void setSchrittlaenge(Integer schrittlaenge) {
		this.schrittlaenge = schrittlaenge;
	}

	public Integer getWassersaeule() {
		return wassersaeule;
	}

	public void setWassersaeule(Integer wassersaeule) {
		this.wassersaeule = wassersaeule;
	}

	public Integer getSchuhgroesse() {
		return schuhgroesse;
	}

	public void setSchuhgroesse(Integer schuhgroesse) {
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

	public Integer getOrtID() {
		return ortID;
	}

	public void setOrtID(Integer ortID) {
		this.ortID = ortID;
	}

	public String getTypeString() {
		return typeString;
	}

	public void setTypeString(String typeString) {
		this.typeString = typeString;
	}

	public String toSQLFormat() {
		return this.id + ", " + this.breite + ", " + this.hoehe + ", " + this.laenge + ", " + this.kleidergroesse + ", "
				+ "\"" + this.bezeichnung + "\"" + ", " + "\"" + this.farbe + "\"" + ", " + this.schrittlaenge + ", "
				+ this.wassersaeule + ", " + this.schuhgroesse + ", " + "\"" + this.obermaterial + "\"" + ", " + "\""
				+ this.absatzform + "\"" + ", " + this.ortID + ", \"" + this.typeString + "\"";
	}

	// maybe typeString for easier conversion?
}
