package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {

	protected Connection con;

	public SQLConnection(String username, String password) throws Exception {
		int counter = 0;
		do {
			counter++;
			System.out.println("Trying to establish Data Base Connection... Try no. " + counter + ":");
		} while (!init(username, password) && counter < 10);

		if (con != null) {
			System.out.println("Successfully connected to Data Base.");
		} else {
			System.out.println("No connection possible.");
			throw new Exception();
		}
	}

	protected boolean init(String username, String password) {
		// init db connection
		try {
			// Treiber laden für MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Failure Class Not Found: " + " " + ex.getMessage());
			return false;
		}
		try {
			// Verbindung aufbauen zu Datenbank
			String url = "jdbc:mysql://127.0.0.1:3306/sat_dao?user=" + username + "&password=" + password;
			con = DriverManager.getConnection(url);
			if (con != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Failure: " + " " + e.getMessage());
			return false;
		}
	}

	public Connection getDBConnection() {
		return this.con;
	}

}
