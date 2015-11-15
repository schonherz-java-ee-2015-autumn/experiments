package hu.neuron.java.service.impl;

import hu.neuron.java.common.dao.RoleDAO;
import hu.neuron.java.common.dao.UserDAO;
import hu.neuron.java.common.dto.RoleDTO;
import hu.neuron.java.service.UserService;
import hu.neuron.java.service.vo.UserVO;
import hu.schonherz.service.converter.RoleConverter;
import hu.schonherz.service.converter.UserConverter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;

	@Autowired
	RoleDAO roleDAO;

	public UserServiceImpl() {
	}

	@Override
	public UserVO findUserByName(String name) throws Exception {
		UserVO vo = UserConverter.toVO(userDAO.findUserByName(name));
		return vo;

	}

	@Override
	public UserVO setUpRoles(UserVO vo) throws Exception {
		List<RoleDTO> roles;
		try {
			roles = roleDAO.findRolesByUserId(vo.getId());
			vo.setRoles(RoleConverter.toVO(roles));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;

	}

	@Override
	public void registrationUser(UserVO userVO) throws Exception {

		Long userId = userDAO.save(UserConverter.toDTO(userVO));
		RoleDTO userRole = roleDAO.findRoleByName("ROLE_USER");
		roleDAO.addRoleToUser(userRole.getId(), userId);
	}

}
