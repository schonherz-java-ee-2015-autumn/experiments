package hu.neuron.java.service;

import java.util.List;

import hu.neuron.java.service.vo.UserVO;

public interface UserService {

	public UserVO findUserByName(String name) throws Exception;

	public void registrationUser(UserVO userVO) throws Exception;

	public List<UserVO> getUserList(int i, int pageSize, String sortField,
			int dir, String filter, String filterColumnName);

	public Integer getUserCount();

	public void saveUser(UserVO selectedUser);

	

	
}
