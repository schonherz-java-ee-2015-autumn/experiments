package hu.schonherz.common.service;

import java.util.List;

import hu.schonherz.common.dto.UserDTO;

public interface UserService {

	public Long saveUser(UserDTO user) throws ServiceException;

	public UserDTO getUser(int userId) throws ServiceException;

	public void deleteUser(int userId) throws ServiceException;

	public List<UserDTO> getAllUser() throws ServiceException;

	UserDTO isUserExists(String userName) throws ServiceException;

	boolean checkUserByName(String userName) throws ServiceException;

	boolean checkUserByMail(String email) throws ServiceException;
}
