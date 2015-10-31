package hu.dupetya.core.connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Datasource {
	private static volatile Datasource datasource;
	private ComboPooledDataSource cpds;

	private Datasource() throws NamingException {
		InitialContext initialContext = new InitialContext();
		cpds = (ComboPooledDataSource) initialContext.lookup("java:comp/env/jdbc/DSTest");

		cpds.setMinPoolSize(10);
		cpds.setAcquireIncrement(10);
		cpds.setMaxPoolSize(100);
	}

	public static Datasource getInstance() throws NamingException {
		if (datasource == null) {
			synchronized (Datasource.class) {
				if (datasource == null) {
					datasource = new Datasource();
				}
			}
		}
		return datasource;
	}

	public Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}
}
