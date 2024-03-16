package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.LinkedList;

public class OrtDao implements Dao<Ort> {

	protected SQLConnection connection;

	public OrtDao(SQLConnection connection) {
		this.connection = connection;
	}

	@Override
	public boolean create(Ort t) {
		// check if object with same id already exists
		if (this.retrieve(t.ortsID) != null) {
			return false;
		}

		// query insert
		String insertQuery = "INSERT INTO Ort VALUES (" + t.getOrtsID() + ", " + t.getX() + ", " + t.getY() + ", "
				+ t.getZ() + ")";
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
	public Ort retrieve(int id) {
		// query select
		String selectQuery = "SELECT * FROM Ort WHERE ID = " + id;
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
				int x = result.getInt("x");
				int y = result.getInt("y");
				int z = result.getInt("z");

				Ort ort = new Ort(id, x, y, z);
				return ort;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean update(Ort t, String[] params) {
		// query update
		String updateQuery = "UPDATE Ort SET " + "x=" + t.getX() + ", y=" + t.getY() + ", z=" + t.getZ()
				+ " WHERE ID = " + t.getOrtsID();
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
	public boolean delete(Ort t) {
		// query delete
		String deleteQuery = "DELETE FROM Ort WHERE ID = " + t.getOrtsID();
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
	public List<Ort> retrieveAll() {
		LinkedList<Ort> orte = new LinkedList<Ort>();

		// query select
		String selectQuery = "SELECT * FROM Ort";
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
				int x = result.getInt("x");
				int y = result.getInt("y");
				int z = result.getInt("z");

				Ort ort = new Ort(id, x, y, z);
				orte.add(ort);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orte;
	}

}
