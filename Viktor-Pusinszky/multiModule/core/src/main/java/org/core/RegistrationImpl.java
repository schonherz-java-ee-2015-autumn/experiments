package org.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class RegistrationImpl implements IRegistration {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<UserDAO> getAllUser() {
		System.out.println("RegistrationUtilImpl + getAllUsr");
		String sql = "SELECT * from registration";
		return jdbcTemplate.query(sql,new UserMapper());
	}
	
	@Override
	public void saveRegistration(UserDAO user) {
		System.out.println("RegistrationUtilImpl + saveRegistration");
		String sql = "INSERT INTO registration"
		+ "(user_name," 
		+ "passwords,"
		+ "email,"
		+ "Bdate)"
		+ "VALUES(?,?,?,?);";
		jdbcTemplate.update(sql, 
				new Object[] {
						user.getName(),
						user.getPassword(),
						user.getEmail(),
						user.getDate()
				});
	}
	
	private static final class UserMapper implements RowMapper<UserDAO>{

		@Override
		public UserDAO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			UserDAO user = new UserDAO();
			user.setName(resultSet.getString("user_name"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("passwords"));
			user.setDate(resultSet.getString("Bdate"));
			return user;
		}
	}

	public List<UserDAO> getUserLimit(String startLimit, String endLimit) {
		System.out.println("RegistrationUtilImpl + getUserLimit");
		ArrayList<UserDAO> userList = new ArrayList<UserDAO>();
		PreparedStatement ps = null;
		Connection conn = null;
			try {
				conn = dataSource.getConnection();
				ps = conn.prepareStatement("SELECT * from registration LIMIT ?,?");
				ps.setString(1, startLimit);
				ps.setString(2, endLimit);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					userList.add(new UserDAO(
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
	public UserDAO findUserByName() {
		return null;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
