package hu.schonherz.service.converter;

import hu.neuron.java.common.dto.RoleDTO;
import hu.neuron.java.service.vo.RoleVO;

import java.util.ArrayList;
import java.util.List;

public class RoleConverter {
	public static RoleVO toVO(RoleDTO dto) {
		if (dto == null) {
			return null;
		}
		RoleVO vo = new RoleVO();
		vo.setId(dto.getId());
		vo.setName(dto.getName());
		return vo;
	}

	public static List<RoleVO> toVO(List<RoleDTO> dtos) {
		if (dtos == null) {
			return null;
		}
		List<RoleVO> vos = new ArrayList<RoleVO>();
		for (RoleDTO dto : dtos) {
			vos.add(toVO(dto));
		}
		return vos;
	}

	public static RoleDTO toDTO(RoleVO vo) {
		if (vo == null) {
			return null;
		}
		RoleDTO dto = new RoleDTO();
		dto.setId(vo.getId());
		dto.setName(vo.getName());
		return dto;
	}

	public static List<RoleDTO> toDTO(List<RoleVO> vos) {
		if (vos == null) {
			return null;
		}
		List<RoleDTO> dtos = new ArrayList<RoleDTO>();
		for (RoleVO vo : vos) {
			dtos.add(toDTO(vo));
		}
		return dtos;
	}

}
