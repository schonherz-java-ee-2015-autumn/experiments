package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.neuron.java.service.vo.UserVO;
import hu.schonherz.java.entities.User;

public class UserConverter {
	static Mapper mapper = new DozerBeanMapper();
	
	static UserVO toVO(User user){
		if(user==null)
			return null;
		return mapper.map(user, UserVO.class);
	}
	
	public static User toEntity(UserVO userVO){
		if(userVO==null)
			return null;
		return mapper.map(userVO, User.class);
	}
	
	public static List<UserVO> toVO(List<User> users){
		List<UserVO> rv = new ArrayList<>();
		for(User u: users)
			rv.add(mapper.map(u, UserVO.class));
		return rv;
	}
	
	public static List<User> toUser(List<UserVO> rv){
		List<User> users = new ArrayList<>();
		for(UserVO u: rv)
			users.add(mapper.map(u, User.class));
		return users;
	}
}
