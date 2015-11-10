package hu.schonherz.kepzes.java.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.kepzes.java.common.UserDAO;
import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.common.UserException;
import hu.schonherz.kepzes.java.common.UserVO;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = UserException.class, propagation = Propagation.SUPPORTS)
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	private SimpleJdbcInsert insert;

	public UserDAOImpl() {

	}

	@SuppressWarnings("resource")
	public void init() {
		insert = new SimpleJdbcInsert(getDataSource()).withTableName("registration");
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(UserDTO user) throws UserException {
		try {
			insert.execute(new BeanPropertySqlParameterSource(user));
		} catch (DataAccessException e) {
			throw new UserException(e);
		}
	}

	@Override
	public void updateUser(UserDTO user) throws UserException {

	}

	@Override
	public void deleteUser(UserDTO user) throws UserException {
		String query = "delete from registration where user_name = ?";
		try {
			getJdbcTemplate().update(query, new Object[] { user.getUserName() });
		} catch (DataAccessException e) {
			throw new UserException(e);
		}
	}

	@Override
	public List<UserDTO> getUsers(String orderBy, String orderByMode) throws UserException {
		String query = "select * from registration order by ";
		String order = orderBy + " " + orderByMode + "";
		query += order;
		return getJdbcTemplate().query(query, new RowMapper<UserDTO>() {
			// Anonymous osztályka
			@Override
			public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDTO dto = new UserDTO();
				dto.setUserName(rs.getString(2));
				dto.seteMail(rs.getString(4));
				dto.setFullName(rs.getString(5));
				dto.setBirthDate(rs.getString(6));
				dto.setBirthPlace(rs.getString(7));
				// System.out.println(dto.toString());
				return dto;
			}
		});
	}

	@Override
	public UserDTO getUserById(long id) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO signInUser(UserVO user) throws UserException {
		String sql = "SELECT * from registration where user_name = ? and password = ? ";
		List<UserDTO> queriedUser = getJdbcTemplate().query(sql,
				new Object[] { user.getUserName(), user.getPassword() }, new RowMapper<UserDTO>() {

					@Override
					public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserDTO qUser = new UserDTO();
						qUser.setUserName(rs.getString(2));
						qUser.seteMail(rs.getString(4));
						qUser.setFullName(rs.getString(5));
						qUser.setBirthDate(rs.getString(6));
						qUser.setBirthPlace(rs.getString(7));

						return qUser;
					}
				});
		if (!queriedUser.isEmpty()) {
			return queriedUser.get(0);
		} else {
			return null;
		}
	}
}
