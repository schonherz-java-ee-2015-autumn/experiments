package hu.schonherz.web.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/web_app", "root", "");
		} catch (SQLException e) {
		}
		return conn;

	}

}
