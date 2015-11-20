package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.service.vo.MessageVO;
import hu.neuron.java.service.vo.UserVO;
import hu.schonherz.java.dao.MessageDAO;
import hu.schonherz.java.entities.Message;


@Service("messageService")
@Transactional(propagation=Propagation.REQUIRED)
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	MessageDAO messageDAO;

	@Override
	public List<MessageVO> getMessages(UserVO userVO) {
		List<Message> messages = messageDAO.findAll();
		if(messages!=null)
		return MessageConverter.toVO(messages);
		else
			return null;
	}

	@Override
	public void sendMessage(UserVO from , UserVO  to, String message) {
		MessageVO messageVO = new MessageVO();
		messageVO.setFromUser(from);
		messageVO.setToUser(to);
		messageVO.setContent(message);
		messageDAO.save(MessageConverter.toEntity(messageVO));

	}

}
