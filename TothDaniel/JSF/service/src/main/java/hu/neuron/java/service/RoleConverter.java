package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.neuron.java.service.vo.RoleVO;
import hu.schonherz.java.entities.Role;

public class RoleConverter {

	static Mapper mapper = new DozerBeanMapper();

	public static RoleVO toVo(Role Role) {
		if (Role == null) {
			return null;
		}
		return mapper.map(Role, RoleVO.class);
	}

	public static Role toEntity(RoleVO RoleVO) {
		if (RoleVO == null) {
			return null;
		}
		return mapper.map(RoleVO, Role.class);
	}

	public static List<RoleVO> toVo(List<Role> Role) {
		List<RoleVO> rv = new ArrayList<>();
		for (Role Roles : Role) {
			rv.add(toVo(Roles));
		}
		return rv;
	}

	public static List<Role> toEntity(List<RoleVO> Role) {
		List<Role> rv = new ArrayList<>();
		for (RoleVO Roles : Role) {
			rv.add(toEntity(Roles));
		}
		return rv;
	}
}
