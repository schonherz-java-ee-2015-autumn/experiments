package hu.neuron.java.service;

import hu.neuron.java.service.vo.MessageVO;

public interface MessageService {
	public void sendMessage(MessageVO message);

	public MessageVO readMessage();
}
