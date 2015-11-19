package hu.neuron.java.service;

import java.util.List;

import hu.neuron.java.service.vo.RoleVO;

public interface RoleService {

	public RoleVO getRoleByName(String role);

	public List<RoleVO> getAllRoles();

}
