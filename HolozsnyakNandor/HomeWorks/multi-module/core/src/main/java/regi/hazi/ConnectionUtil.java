package regi.hazi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {

	public Connection getConnection() {
		
		Connection conn = null;
		
		try {
			InitialContext ic = new InitialContext();
			DataSource myDS = (DataSource)ic.lookup("java:comp/env/jdbc/DSTest");
			conn = myDS.getConnection();
			//conn = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "mysql");
			System.out.println("Kapcsolódva!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

}
