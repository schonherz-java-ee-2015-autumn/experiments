package hu.neuron.java.service;

import java.util.List;

import hu.neuron.java.service.vo.MessageVO;

public interface MessageService {
	public void sendMessage(MessageVO message);

	public MessageVO readMessage();
	
	public List<MessageVO> getMessages(Long id);
}
