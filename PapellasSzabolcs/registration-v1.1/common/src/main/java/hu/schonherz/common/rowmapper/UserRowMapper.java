package hu.schonherz.common.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.common.dto.UserDTO;

public class UserRowMapper implements RowMapper<UserDTO> {

	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(rs.getInt(1));
		userDTO.setUserName(rs.getString(2));
		userDTO.setFirstName(rs.getString(3));
		userDTO.setLastName(rs.getString(4));
		userDTO.setEmail(rs.getString(5));
		userDTO.setPhone(rs.getString(6));
		userDTO.setLocation(rs.getString(7));
		userDTO.setPassword(rs.getString(8));
		userDTO.setGender(rs.getString(9));
		userDTO.setBirthday(rs.getString(10));
		return userDTO;
	}

}
