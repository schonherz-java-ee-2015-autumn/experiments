package hu.dupetya.core.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import hu.dupetya.common.account.dao.DataAccessException;
import hu.dupetya.core.connection.Datasource;

public class DBUtil {

	public static int numberOfRecords(String string) throws DataAccessException {
		Connection connection = null;
		String sql = "SELECT count(*) from users";
		PreparedStatement query = null;
		ResultSet rs = null;
		int result = 0;
		try {
			connection = Datasource.getInstance().getConnection();
			query = connection.prepareStatement(sql);
			rs = query.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException | NamingException e) {
			throw new DataAccessException(e);
		} finally {
			close(connection, rs, query);
		}
		return result;
	}

	public static void close(AutoCloseable... closables) {
		for (AutoCloseable closeable : closables) {
			try {
				closeable.close();
			} catch (Exception e) {
			}
		}
	}

}
