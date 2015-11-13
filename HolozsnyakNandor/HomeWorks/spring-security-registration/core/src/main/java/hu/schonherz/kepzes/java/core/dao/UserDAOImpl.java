package hu.schonherz.kepzes.java.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
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
	@Transactional(readOnly = false)
	public void updateUser(UserDTO user) throws UserException {
		//System.out.println("Modding user in dao: " + user.toString());
		String updateQuery = "update registration set user_name = ?, email=?,full_name=?,birth_date=?,birth_place=? where id = ?";
		Object[] params = {
					user.getUserName(),
					user.geteMail(),
					user.getFullName(),
					user.getBirthDate(),
					user.getBirthPlace(),
					user.getUserId()
					};
	     int[] types = {
	    		 Types.VARCHAR,
	    		 Types.VARCHAR,
	    		 Types.VARCHAR,
	    		 Types.VARCHAR,
	    		 Types.VARCHAR,
	    		 Types.INTEGER};
		try {
			int i = getJdbcTemplate().update(updateQuery, params,types);
			//System.out.println("Rows affected:" + i);
		} catch(DataAccessException e) {
			System.out.println("Can not mod user in DAO!");
			e.printStackTrace();
			throw new UserException(e);
		}
	}

	@Override
	@Transactional(readOnly = false)
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
		System.out.println("Getting user by Id");
		String sql = "SELECT id,user_name,email,full_name,birth_date,birth_place from registration where id = ?";
		List<UserDTO> queriedUser = getJdbcTemplate().query(sql, new Object[] { id }, new RowMapper<UserDTO>() {

			@Override
			public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDTO qUser = new UserDTO();
				qUser.setUserId(rs.getInt(1));
				qUser.setUserName(rs.getString(2));
				qUser.seteMail(rs.getString(3));
				qUser.setFullName(rs.getString(4));
				qUser.setBirthDate(rs.getString(5));
				qUser.setBirthPlace(rs.getString(6));
				System.out.println(qUser.toString());
				return qUser;
			}
		});
		
		if (!queriedUser.isEmpty()) {
			System.out.println(queriedUser.get(0).toString());
			return queriedUser.get(0);
		} else {
			return null;
		}
	}

	@Override
	public UserDTO signInUser(UserVO user) throws UserException {
		String sql = "SELECT * from registration where user_name = ? and password = ? ";
		List<UserDTO> queriedUser = getJdbcTemplate().query(sql,
				new Object[] { user.getUserName(), user.getPassword() }, new RowMapper<UserDTO>() {

					@Override
					public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserDTO qUser = new UserDTO();
						qUser.setUserId(rs.getInt(1));
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

	public UserDTO getUserByName(String username) throws UserException {

		String sql = "SELECT id,user_name,email,full_name,birth_date,birth_place from registration where user_name = ?";
		List<UserDTO> queriedUser = getJdbcTemplate().query(sql, new Object[] { username }, new RowMapper<UserDTO>() {

			@Override
			public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDTO qUser = new UserDTO();
				qUser.setUserId(rs.getInt(1));
				qUser.setUserName(rs.getString(2));
				qUser.seteMail(rs.getString(3));
				qUser.setFullName(rs.getString(4));
				qUser.setBirthDate(rs.getString(5));
				qUser.setBirthPlace(rs.getString(6));
				return qUser;
			}
		});
		if (!queriedUser.isEmpty()) {
			System.out.println(queriedUser.get(0).toString());
			return queriedUser.get(0);
		} else {
			return null;
		}
	}
}
