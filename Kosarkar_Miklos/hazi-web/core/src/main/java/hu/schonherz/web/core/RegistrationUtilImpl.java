package hu.schonherz.web.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.schonherz.common.RegistrationUtil;
import hu.schonherz.common.User;

public class RegistrationUtilImpl implements RegistrationUtil {

	@Override
	public void saveUser(User user) {

		PreparedStatement insertUser = null;

		String insertUserQuery = "INSERT INTO web_app.users" + "(username,first_name, last_name, pwd, email, birthdate)"
				+ "VALUES" + "(?,?,?,?,?,?);";

		Connection conn = null;
		try {
			ConnectionUtil connection = new ConnectionUtil();
			conn = connection.getConnection();
			insertUser = conn.prepareStatement(insertUserQuery);
			insertUser.setString(1, user.getUsername());
			insertUser.setString(2, user.getFirstName());
			insertUser.setString(3, user.getLastName());
			insertUser.setString(4, user.getPass());
			insertUser.setString(5, user.getEmail());
			insertUser.setDate(6, new java.sql.Date(user.getDateOfBirth().getTime()));
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

		String getAllUserQuery = "select * from web_app.users";
		ResultSet result = null;
		List<User> users = new ArrayList<>();
		Connection conn = null;
		try {
			ConnectionUtil connection = new ConnectionUtil();
			conn = connection.getConnection();
			Statement stmt = conn.createStatement();
			result = stmt.executeQuery(getAllUserQuery);
			;
			while (result.next()) {
				String username = result.getString("username");
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String email = result.getString("email");
				Date dateOfBirth = result.getDate("birthdate");
				String password = result.getString("pwd");
				users.add(new User(username, firstName, lastName, password, email, dateOfBirth));
			}

		} catch (SQLException e) {

		} finally {
			if (result != null) {
				try {
					result.close();
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
		/*-----------------------*/

		return users;
	}

	@Override
	public User findUserByName(String username) {
		String getUserQuery = "select * from web_app.users where username = ?";
		ResultSet result = null;
		List<User> users = new ArrayList<>();
		Connection conn = null;
		PreparedStatement getUser = null;
		try {
			ConnectionUtil connection = new ConnectionUtil();
			conn = connection.getConnection();
			getUser = conn.prepareStatement(getUserQuery);
			getUser.setString(1, username);
			result = getUser.executeQuery();
			while (result.next()) {
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String email = result.getString("email");
				Date dateOfBirth = result.getDate("birthdate");
				String password = result.getString("pwd");
				users.add(new User(username, firstName, lastName, password, email, dateOfBirth));
			}

		} catch (SQLException e) {

		} finally {
			if (result != null) {
				try {
					result.close();
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
		if (!users.isEmpty() && users.size() < 2)
			return users.get(0);
		else
			return null;
	}

}
