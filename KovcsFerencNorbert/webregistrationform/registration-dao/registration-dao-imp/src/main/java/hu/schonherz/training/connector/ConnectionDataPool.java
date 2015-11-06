package hu.schonherz.training.connector;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionDataPool {
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			InitialContext ic = new InitialContext();
			DataSource myDS = (DataSource) ic.lookup("java:comp/env/jdbc/DSTest");
			conn = myDS.getConnection();
//			System.out.println("connected......");
		} catch (SQLException e) {
//			System.out.println("sqlexceltion");
		} catch (NamingException e) {
//			System.out.println("nameexception");
		}
//		System.out.println(conn);
		return conn;

	}
}
