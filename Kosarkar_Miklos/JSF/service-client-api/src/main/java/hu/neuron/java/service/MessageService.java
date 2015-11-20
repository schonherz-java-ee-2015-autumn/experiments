package hu.neuron.java.service;

import java.util.List;

import hu.neuron.java.service.vo.MessageVO;
import hu.neuron.java.service.vo.UserVO;

public interface MessageService {

	public List<MessageVO> getMessages(UserVO userVO);

	public void sendMessage(UserVO from, UserVO to, String message);

	

	
}
