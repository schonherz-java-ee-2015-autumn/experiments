package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.neuron.java.service.vo.MessageVO;
import hu.schonherz.java.entities.Message;

public class MessageConverter {
	static Mapper mapper = new DozerBeanMapper();
	
	static MessageVO toVO(Message m){
		if(m==null)
			return null;
		return mapper.map(m, MessageVO.class);
	}
	
	public static Message toEntity(MessageVO mVO){
		if(mVO==null)
			return null;
		return mapper.map(mVO, Message.class);
	}
	
	public static List<MessageVO> toVO(List<Message> Messages){
		List<MessageVO> rv = new ArrayList<>();
		for(Message u: Messages)
			rv.add(mapper.map(u, MessageVO.class));
		return rv;
	}
	
	public static List<Message> toMessage(List<MessageVO> rv){
		List<Message> messages = new ArrayList<>();
		for(MessageVO u: rv)
			messages.add(mapper.map(u, Message.class));
		return messages;
	}
}
