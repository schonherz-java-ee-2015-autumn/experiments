package hu.schonherz.common.dao;

import java.util.List;

import hu.schonherz.common.dto.UserDTO;

public interface UserDAO {

	public Long saveUser(UserDTO user) throws PersistenceException;

	public UserDTO getUser(int userId) throws PersistenceException;

	public void deleteUser(int userId) throws PersistenceException;

	public List<UserDTO> getAllUser() throws PersistenceException;

	UserDTO isUserExists(String userName) throws PersistenceException;

	boolean checkUserByName(String userName) throws PersistenceException;

	boolean checkUserByMail(String email) throws PersistenceException;
}
