package hu.neuron.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.service.MessageConverter;
import hu.neuron.java.service.MessageService;
import hu.neuron.java.service.vo.MessageVO;
import hu.schonherz.java.dao.MessageDao;
import hu.schonherz.java.dao.UserDao;
import hu.schonherz.java.entities.Message;
import hu.schonherz.java.entities.User;

@Service("messageService")
@Transactional(propagation = Propagation.REQUIRED)
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDao messageDao;
	@Autowired
	UserDao userDao;
	
	@Override
	public void sendMessage(MessageVO message) {
		Message msg = MessageConverter.toEntity(message);
		User sendUser = userDao.findByUsername(message.getSendUser().getUsername());
		User targetUser = userDao.findByUsername(message.getTargetUser().getUsername());
		System.out.println("Küldő fél:"+ sendUser.getUsername());
		System.out.println("Fogadó fél:"+ targetUser.getUsername());
		System.out.println("Üzenet:" + msg.getContent());
		msg.setSendUser(sendUser);
		msg.setTargetUser(targetUser);
		
		if (message != null) {
			messageDao.save(msg);
		}

	}

	@Override
	public MessageVO readMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<MessageVO> getMessages(Long id) {
		List<Message> messages = messageDao.findByTargetUserIdOrderBySendDateDesc(id);
		List<MessageVO> convertedMessages = new ArrayList<>();
	
		for(Message m:messages) {
			convertedMessages.add(MessageConverter.toVo(m));
			System.out.println("Levelek adatai:"+m.toString());
		}
		return convertedMessages;
	}

}
