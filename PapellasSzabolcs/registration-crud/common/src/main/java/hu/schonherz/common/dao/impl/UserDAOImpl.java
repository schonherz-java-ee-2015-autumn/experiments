package hu.schonherz.common.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.common.dao.PersistenceException;
import hu.schonherz.common.dao.UserDAO;
import hu.schonherz.common.dto.UserDTO;
import hu.schonherz.common.rowmapper.UserRowMapper;

public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	private SimpleJdbcInsert insert;

	public void init() {
		insert = new SimpleJdbcInsert(getDataSource()).withTableName("users").usingGeneratedKeyColumns("id");
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = PersistenceException.class, propagation = Propagation.REQUIRED)
	@Override
	public Long saveUser(UserDTO user) throws PersistenceException {
		try {
			Number id = insert.executeAndReturnKey(new BeanPropertySqlParameterSource(user));

			if (id != null) {
				return id.longValue();
			}

			return null;

		} catch (DataAccessException e) {
			throw new PersistenceException(e);
		}

	}

	@Override
	public UserDTO getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Transactional(readOnly = false)
	@Override
	public List<UserDTO> getAllUser() throws PersistenceException {
		return getJdbcTemplate().query("SELECT * FROM users", new UserRowMapper());
	}

	public UserDTO isUserExists(String userName) throws PersistenceException {

		String sql = "SELECT * FROM users WHERE user_name = ?";
		try {
			return (UserDTO) getJdbcTemplate().queryForObject(sql, new Object[] { userName }, new UserRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public boolean checkUserByName(String userName) throws PersistenceException {
		String sql = "SELECT EXISTS(SELECT 1 FROM users WHERE user_name = ?)";
		return getJdbcTemplate().queryForObject(sql, new Object[] { userName }, Boolean.class);

	}

	@Override
	public boolean checkUserByMail(String email) throws PersistenceException {
		String sql = "SELECT EXISTS(SELECT 1 FROM users WHERE email = ?)";
		return getJdbcTemplate().queryForObject(sql, new Object[] { email }, Boolean.class);

	}

}
