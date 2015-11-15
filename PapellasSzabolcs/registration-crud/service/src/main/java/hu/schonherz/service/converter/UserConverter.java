package hu.schonherz.service.converter;

import hu.neuron.java.common.dto.UserDTO;
import hu.neuron.java.service.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

	public static UserVO toVO(UserDTO dto) {
		if (dto == null) {
			return null;
		}
		UserVO vo = new UserVO();
		vo.setId(dto.getId());
		vo.setPassword(dto.getPassword());
		vo.setUserName(dto.getUserName());

		return vo;
	}

	public static List<UserVO> toVO(List<UserDTO> dtos) {
		if (dtos == null) {
			return null;
		}
		List<UserVO> vos = new ArrayList<UserVO>();
		for (UserDTO dto : dtos) {
			vos.add(toVO(dto));
		}
		return vos;
	}

	public static UserDTO toDTO(UserVO vo) {
		if (vo == null) {
			return null;
		}
		UserDTO dto = new UserDTO();
		dto.setId(vo.getId());
		dto.setPassword(vo.getPassword());
		dto.setUserName(vo.getUserName());
		return dto;
	}

	public static List<UserDTO> toDTO(List<UserVO> vos) {
		if (vos == null) {
			return null;
		}
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for (UserVO vo : vos) {
			dtos.add(toDTO(vo));
		}
		return dtos;
	}
}
