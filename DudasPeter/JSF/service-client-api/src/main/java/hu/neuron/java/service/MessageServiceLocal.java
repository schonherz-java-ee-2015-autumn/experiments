package hu.neuron.java.service;

import java.util.List;

import hu.neuron.java.service.vo.MessageVO;

public interface MessageServiceLocal {

	void send(MessageVO messageVO);

	List<MessageVO> getMessages(Long from, Long to);
}
