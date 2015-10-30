package hu.schonherz.web.core;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {

	public Connection getConnection() {
		Connection conn = null;
		InitialContext ic;
		DataSource myDS = null;
		try {
			ic = new InitialContext();
			myDS = (DataSource) ic.lookup("java:comp/env/jdbc/DSTest");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn =  myDS.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// conn = DriverManager.getConnection("jdbc:mysql://localhost/web_app",
		// "root", "");
		return conn;

	}

}
