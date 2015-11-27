package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.neuron.java.service.vo.MessageVO;
import hu.schonherz.java.entities.Message;

public class MessageConverter {

	static Mapper mapper = new DozerBeanMapper();

	public static MessageVO toVo(Message Message) {
		if (Message == null) {
			return null;
		}
		return mapper.map(Message, MessageVO.class);
	}

	public static Message toEntity(MessageVO MessageVO) {
		if (MessageVO == null) {
			return null;
		}
		return mapper.map(MessageVO, Message.class);
	}

	public static List<MessageVO> toVo(List<Message> Message) {
		List<MessageVO> rv = new ArrayList<>();
		for (Message Messages : Message) {
			rv.add(toVo(Messages));
		}
		return rv;
	}

	public static List<Message> toEntity(List<MessageVO> Message) {
		List<Message> rv = new ArrayList<>();
		for (MessageVO Messages : Message) {
			rv.add(toEntity(Messages));
		}
		return rv;
	}
}
