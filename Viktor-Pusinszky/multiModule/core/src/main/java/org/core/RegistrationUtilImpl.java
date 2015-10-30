package org.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.common.*;

public class RegistrationUtilImpl implements RegistrationUtil {

	@Override
	public void saveRegistration(User user) {
		System.out.println("RegistrationUtilImpl + saveRegistration");
		PreparedStatement insertUser = null;
		String insertUserString = "INSERT INTO registration"
		+ "(user_name," 
		+ "passwords,"
		+ "email,"
		+ "Bdate)"
		+ "VALUES(?,?,?,?);";
		Connection conn = null;
		try {
			ConnectionHandler connection = new ConnectionHandler();
			conn = connection.getConnection();
			insertUser = conn.prepareStatement(insertUserString);
			insertUser.setString(1, user.getName());
			insertUser.setString(2, user.getPassword());
			insertUser.setString(3, user.getEmail());
			insertUser.setString(4, user.getDate());
			insertUser.execute();

		} catch (SQLException e) {
				e.printStackTrace();
		} finally {
				try {
					insertUser.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

	@Override
	public List<User> getAllUser() {
		System.out.println("RegistrationUtilImpl + getAllUser");
		ArrayList<User> userList = new ArrayList<User>();
		PreparedStatement ps = null;
		Connection conn = null;
			try {
				ConnectionHandler connection = new ConnectionHandler();
				conn = connection.getConnection();
				ps = conn.prepareStatement("SELECT * from registration");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					userList.add(new User(
							rs.getString("user_name"), 
							rs.getString("passwords"),
							rs.getString("email"),
							rs.getString("Bdate")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
					try {
						ps.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		return userList;
	}
	public List<User> getUserLimit(String startLimit, String endLimit) {
		System.out.println("RegistrationUtilImpl + getUserLimit");
		ArrayList<User> userList = new ArrayList<User>();
		PreparedStatement ps = null;
		Connection conn = null;
			try {
				ConnectionHandler connection = new ConnectionHandler();
				conn = connection.getConnection();
				ps = conn.prepareStatement("SELECT * from registration LIMIT ?,?");
				ps.setString(1, startLimit);
				ps.setString(2, endLimit);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					userList.add(new User(
							rs.getString("user_name"), 
							rs.getString("passwords"),
							rs.getString("email"),
							rs.getString("Bdate")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
					try {
						ps.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		return userList;
	}
	@Override
	public User findUserByName() {
		return null;
	}

}
