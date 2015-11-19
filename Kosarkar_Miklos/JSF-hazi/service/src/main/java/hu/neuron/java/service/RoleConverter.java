package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.neuron.java.service.vo.RoleVO;
import hu.schonherz.java.entities.Role;

public class RoleConverter {
	static Mapper mapper = new DozerBeanMapper();
	
	static RoleVO toVO(Role m){
		if(m==null)
			return null;
		return mapper.map(m, RoleVO.class);
	}
	
	public static Role toEntity(RoleVO mVO){
		if(mVO==null)
			return null;
		return mapper.map(mVO, Role.class);
	}
	
	public static List<RoleVO> toVO(List<Role> Roles){
		List<RoleVO> rv = new ArrayList<>();
		for(Role u: Roles)
			rv.add(mapper.map(u, RoleVO.class));
		return rv;
	}
	
	public static List<Role> toRole(List<RoleVO> rv){
		List<Role> Roles = new ArrayList<>();
		for(RoleVO u: rv)
			Roles.add(mapper.map(u, Role.class));
		return Roles;
	}
}
