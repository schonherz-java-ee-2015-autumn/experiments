package hu.schonherz.web.core;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import hu.schonherz.common.User;
import hu.schonherz.common.UserDAO;

public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate;

	public UserDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(User user) {
		jdbcTemplate.update(
				"INSERT INTO web_app.users" + "(username,first_name, last_name, pwd, email, birthdate)" + "VALUES"
						+ "(?,?,?,?,?,?);",
				user.getUsername(), user.getFirstName(), user.getLastName(), user.getPass(), user.getEmail(),
				user.getDateOfBirth());

	}

	@Override
	public User getUserByUsername(String username) {
		User user = jdbcTemplate
				.queryForObject("select * from web_app.users where username=?", new Object[] { username },
						(rs, rn) -> new User(rs.getString("username"), rs.getString("first_name"),
								rs.getString("last_name"), rs.getString("pwd"), rs.getString("email"),
								rs.getDate("birthdate")));
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> user = jdbcTemplate
				.query("select * from web_app.users",
						(rs, rn) -> new User(rs.getString("username"), rs.getString("first_name"),
								rs.getString("last_name"), rs.getString("pwd"), rs.getString("email"),
								rs.getDate("birthdate")));
		if (user.isEmpty() || user == null) {
			return null;
		} else {
			return user;
		}
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsers(String searchFor, int from, int lenght, String orderBy, String orderDirection) {
		String getUsersQuery = "select * from web_app.users " + "where first_name like ? or last_name like ?"
				+ " order by ? " + orderDirection + " limit ?,?";

		List<User> user = (List<User>) jdbcTemplate
				.queryForObject(getUsersQuery,
						new Object[] { "%" + searchFor + "%", "%" + searchFor + "%", orderBy, from, lenght },
						(rs, rn) -> new User(rs.getString("username"), rs.getString("first_name"),
								rs.getString("last_name"), rs.getString("pwd"), rs.getString("email"),
								rs.getDate("birthdate")));
		if (user.isEmpty() || user == null) {
			return null;
		} else {
			return user;
		}
	}

}
