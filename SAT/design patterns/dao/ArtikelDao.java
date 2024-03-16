package dao;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ArtikelDao implements Dao<Artikel> {

	protected SQLConnection connection;
	protected ArtikelMapper dtoMapper;
	protected OrtDao ortDAO;

	public ArtikelDao(ArtikelMapper mapper, SQLConnection connection, OrtDao ortDAO) {
		this.dtoMapper = mapper;
		this.connection = connection;
		this.ortDAO = ortDAO;
	}

	@Override
	public boolean create(Artikel t) {
		ArtikelTO artikelTO = this.createTO(t);

		// check if object with same id already exists
		if (this.retrieve(t.getArtikelID()) != null) {
			return false;
		}

		if (t.isEingelagert()) {
			ortDAO.create(t.getEinlagerungsOrt());
		}

		// query insert
		String insertQuery = "INSERT INTO Artikel VALUES (" + artikelTO.toSQLFormat() + ")";
		Statement stmt;
		try {
			stmt = connection.getDBConnection().createStatement();
			stmt.executeUpdate(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public Artikel retrieve(int id) {
		// query select
		String selectQuery = "SELECT * FROM Artikel WHERE ID = " + id;
		Statement stmt;
		ResultSet result;

		try {
			stmt = connection.getDBConnection().createStatement();
			result = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			if (result.next()) {
				int breite = result.getInt("breite");
				int hoehe = result.getInt("hoehe");
				int laenge = result.getInt("laenge");

				int kleidergroesse = result.getInt("kleidergroesse");
				String bezeichnung = result.getString("bezeichnung");
				String farbe = result.getString("farbe");

				int schrittlaenge = result.getInt("schrittlaenge");
				int wassersaeule = result.getInt("wassersaeule");
				int schuhgroesse = result.getInt("schuhgroesse");

				String obermaterial = result.getString("obermaterial");
				String absatzform = result.getString("absatzform");

				int ortID = result.getInt("OrtID");
				String typeString = result.getString("typ");

				ArtikelTO artikelTO = new ArtikelTO(id, laenge, breite, hoehe, kleidergroesse, bezeichnung, farbe,
						schrittlaenge, wassersaeule, schuhgroesse, obermaterial, absatzform, ortID, typeString);

				Artikel art = this.createArtikel(artikelTO);
				art.setEinlagerungsOrt(this.ortDAO.retrieve(ortID));

				return art;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean update(Artikel t, String[] params) {
		ArtikelTO artTO = this.createTO(t);

		// query update
		String updateQuery = "UPDATE Artikel SET " + "breite=" + artTO.getBreite() + ", hoehe=" + artTO.getHoehe()
				+ ", laenge=" + artTO.getLaenge() + ", kleidergroesse=" + artTO.getKleidergroesse() + ", bezeichnung=\""
				+ artTO.getBezeichnung() + "\", farbe=\"" + artTO.getFarbe() + "\", schrittlaenge="
				+ artTO.getSchrittlaenge() + ", wassersaeule=" + artTO.getWassersaeule() + ", schuhgroesse="
				+ artTO.getSchuhgroesse() + ", obermaterial=\"" + artTO.getObermaterial() + "\", absatzform="
				+ artTO.getAbsatzform() + "\", OrtID=" + artTO.getOrtID() + " WHERE ID = " + t.getArtikelID();
		Statement stmt;
		try {
			stmt = connection.getDBConnection().createStatement();
			stmt.executeUpdate(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean delete(Artikel t) {
		// query delete
		String deleteQuery = "DELETE FROM Artikel WHERE ID = " + t.getArtikelID();
		Statement stmt;
		try {
			stmt = connection.getDBConnection().createStatement();
			stmt.executeUpdate(deleteQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public List<Artikel> retrieveAll() {
		List<Artikel> artikel = new LinkedList<Artikel>();

		String selectQuery = "SELECT * FROM Artikel";
		Statement stmt;
		ResultSet result;

		try {
			stmt = connection.getDBConnection().createStatement();
			result = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		try {
			while (result.next()) {
				int id = result.getInt("ID");

				int breite = result.getInt("breite");
				int hoehe = result.getInt("hoehe");
				int laenge = result.getInt("laenge");

				int kleidergroesse = result.getInt("kleidergroesse");
				String bezeichnung = result.getString("bezeichnung");
				String farbe = result.getString("farbe");

				int schrittlaenge = result.getInt("schrittlaenge");
				int wassersaeule = result.getInt("wassersaeule");
				int schuhgroesse = result.getInt("schuhgroesse");

				String obermaterial = result.getString("obermaterial");
				String absatzform = result.getString("absatzform");

				int ortID = result.getInt("OrtID");
				String typeString = result.getString("typ");

				ArtikelTO artikelTO = new ArtikelTO(id, laenge, breite, hoehe, kleidergroesse, bezeichnung, farbe,
						schrittlaenge, wassersaeule, schuhgroesse, obermaterial, absatzform, ortID, typeString);

				Artikel art = this.createArtikel(artikelTO);
				art.setEinlagerungsOrt(this.ortDAO.retrieve(ortID));

				artikel.add(art);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return artikel;
	}

	protected ArtikelTO createTO(Artikel t) {
		return this.dtoMapper.toDto(t);
	}

	protected Artikel createArtikel(ArtikelTO dto) {
		return this.dtoMapper.toArtikel(dto);
	}

}
