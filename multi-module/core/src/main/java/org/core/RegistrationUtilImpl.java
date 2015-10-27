package org.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.common.RegistrationUtil;
import org.common.User;

public class RegistrationUtilImpl implements RegistrationUtil {

	@Override
	public void saveRegistration(User user) {

		PreparedStatement insertUser = null;

		String insertUserString = "INSERT INTO `pelda`.`registration`" + "(`id`," + "`username`," + "`firstname`,"
				+ "`lastname`," + "`pass`," + "`email`," + "`birthdate`)" + "VALUES" + "(?," + "?," + "?," + "?," + "?,"
				+ "?," + "?);";

		Connection conn = null;
		try {
			ConnectionUtil connection = new ConnectionUtil();
			conn = connection.getConnection();
			insertUser = conn.prepareStatement(insertUserString);
			insertUser.execute();

		} catch (SQLException e) {

		} finally {
			if (insertUser != null) {
				try {
					insertUser.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByName() {
		// TODO Auto-generated method stub
		return null;
	}

}
