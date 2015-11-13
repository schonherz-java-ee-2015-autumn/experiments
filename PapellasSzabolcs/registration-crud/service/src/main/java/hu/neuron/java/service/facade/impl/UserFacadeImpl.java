package hu.neuron.java.service.facade.impl;

import hu.schonherz.common.service.UserService;
import hu.neuron.java.service.facade.UserFacade;
import hu.neuron.java.service.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserFacadeImpl implements UserFacade {

	@Autowired
	UserService userService;

	public UserFacadeImpl() {
	}

	@Override
	public UserVO findUserAndRolesByName(String name) throws Exception {
		UserVO userVO = userService.findUserByName(name);
		if (userVO != null) {
			userVO = userService.setUpRoles(userVO);
		}
		return userVO;
	}

	@Override
	public void registrationUser(UserVO userVO) throws Exception {
		userService.registrationUser(userVO);

	}

}
