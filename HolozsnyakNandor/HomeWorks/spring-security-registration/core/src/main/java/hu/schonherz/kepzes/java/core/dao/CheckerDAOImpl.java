package hu.schonherz.kepzes.java.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.kepzes.java.common.CheckerDAO;
import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.common.UserException;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = UserException.class, propagation = Propagation.SUPPORTS)
public class CheckerDAOImpl extends JdbcDaoSupport implements CheckerDAO{
	
	@Autowired
    private JdbcTemplate temp;
   	
	@Override
	public boolean checkUserByUsername(String userName) {
		String sql = "SELECT user_name from registration where user_name = ? ";
		List<UserDTO> queriedUser = temp.query(sql, new Object[]{userName},
				new RowMapper<UserDTO>() {

					@Override
					public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserDTO qUser = new UserDTO();
						qUser.setUserName(rs.getString(1));
						System.out.println("User:"+qUser.getUserName());
						return qUser;
					}
		});
		
		boolean alreadyUser = !queriedUser.isEmpty();
		return alreadyUser;
	}

	@Override
	public boolean checkUserByEmail(String eMail) {
		String sql = "SELECT email from registration where email = ? ";
		List<UserDTO> queriedUser = temp.query(sql, new Object[]{eMail},
				new RowMapper<UserDTO>() {
					@Override
					public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserDTO qUser = new UserDTO();
						qUser.seteMail(rs.getString(1));
						System.out.println("Email:"+qUser.geteMail());
						return qUser;
					}
		});
		
		boolean alreadyEmail = !queriedUser.isEmpty();
		return alreadyEmail;
	}

	@Override
	public void setDatabase(DataSource dataSource) {
		temp = new JdbcTemplate(dataSource);
		
	}

}
