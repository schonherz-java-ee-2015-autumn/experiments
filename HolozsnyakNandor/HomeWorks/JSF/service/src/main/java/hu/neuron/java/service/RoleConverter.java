package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.neuron.java.service.vo.RoleVO;
import hu.neuron.java.service.vo.UserVO;
import hu.schonherz.java.entities.Role;
import hu.schonherz.java.entities.User;

public class RoleConverter {
	
	static Mapper mapper = new DozerBeanMapper();
	public static RoleVO toVo(Role role) {
		if(role == null) {
			return null;
		}
		return mapper.map(role, RoleVO.class);		
	}
	
	public static Role toEntity(RoleVO RoleVO) {
		if(RoleVO == null) {
			return null;
		}
		return mapper.map(RoleVO, Role.class);		
	}
	
	public static List<RoleVO> toVo(List<Role> role) {
		List<RoleVO> rv = new ArrayList<>();
		
		for(Role roles:role) {
			rv.add(toVo(roles));
		}
		return rv;
	}
	
	public static List<Role> toEntity(List<RoleVO> user) {
		List<Role> rv = new ArrayList<>();
		
		for(RoleVO users:user) {
			rv.add(toEntity(users));
		}
		return rv;
	}
}
