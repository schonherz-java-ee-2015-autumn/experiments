package org.core;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	public List<UserDTO> getAllUser() {
		System.out.println("RegistrationUtilImpl + getAllUsr");
		String sql = "SELECT * from registration";
		return jdbcTemplate.query(sql,new UserMapper());
	}
	
	@Override
	public void saveRegistration(UserDTO user) {
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
	
	private static final class UserMapper implements RowMapper<UserDTO>{

		@Override
		public UserDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			UserDTO user = new UserDTO();
			user.setName(resultSet.getString("user_name"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("passwords"));
			user.setDate(resultSet.getString("Bdate"));
			return user;
		}
	}

	@Override
	public UserDTO findUserByName(String name) {
		return null;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
