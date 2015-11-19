package hu.neuron.java.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import hu.neuron.java.service.vo.UserVO;

public interface UserService {

	public UserVO findUserByName(String name) throws Exception;

	public void registrationUser(UserVO userVO) throws Exception;

	public UserVO loginUser(UserVO user);
	
	public List<UserVO> findAll(Sort sort);
	

}
