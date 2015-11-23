package hu.neuron.java.service.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.neuron.java.service.MessageConverter;
import hu.neuron.java.service.MessageServiceLocal;
import hu.neuron.java.service.MessageServiceRemote;
import hu.neuron.java.service.vo.MessageVO;
import hu.schonherz.java.dao.MessageDao;

@Stateless(mappedName = "MessageService")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@Local(MessageServiceLocal.class)
@Remote(MessageServiceRemote.class)
public class MessagesServiceImpl implements MessageServiceLocal, MessageServiceRemote {

	@Autowired
	MessageDao messageDao;

	@Override
	public void send(MessageVO messageVO) {
		messageDao.save(MessageConverter.toEntity(messageVO));

	}

	@Override
	public List<MessageVO> getMessages(Long from, Long to) {
		return MessageConverter.toVo(messageDao.findMessages(from, to));
	}

}
