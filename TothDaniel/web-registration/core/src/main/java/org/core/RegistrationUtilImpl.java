package org.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.common.RegistrationUtil;
import org.common.User;

public class RegistrationUtilImpl implements RegistrationUtil {

	private static final String DATE_FORMAT = "yyyy.MM.dd HH:mm:ss:SSS";

	protected final Connection conn;

	public RegistrationUtilImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void saveRegistration(User user) {

		PreparedStatement stmt = null;

		String insertUserString = "insert into registration( username,firstname," + "lastname, pass,email,birthdate )"
				+ "VALUES" + "(?,?,?,?,?,?);";
		try {
			stmt = this.conn.prepareStatement(insertUserString);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3, user.getLastName());
			stmt.setString(4, user.getPass());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, new SimpleDateFormat(DATE_FORMAT).format(user.getDateOfBirth()));

			int n = stmt.executeUpdate();
			stmt.execute();

		} catch (SQLException e) {

		} finally {
			if (stmt != null) {
				try {
					stmt.close();
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

		List<User> userList = new ArrayList<User>();

		try (PreparedStatement stmt = this.conn.prepareStatement("Select * from registration");) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setPass(rs.getString("pass"));
				user.setEmail(rs.getString("email"));
				user.setDateOfBirth(rs.getDate("birthdate"));

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User findUserByName(String name) {
		User user = null;
		try (PreparedStatement stmt = this.conn.prepareStatement("Select * from registration where name= ?");) {
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while (rs.next() && user == null) {
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setPass(rs.getString("pass"));
				user.setEmail(rs.getString("email"));
				user.setDateOfBirth(rs.getDate("birthdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
