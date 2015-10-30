package org.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionHandler {
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/pelda", "root", "MySQL");
			System.out.println("Sikeres kapcsolód");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
}
