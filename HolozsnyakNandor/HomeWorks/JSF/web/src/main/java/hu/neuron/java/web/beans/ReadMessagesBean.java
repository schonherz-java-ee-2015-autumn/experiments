package hu.neuron.java.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import hu.neuron.java.service.MessageService;
import hu.neuron.java.service.UserService;
import hu.neuron.java.service.vo.MessageVO;

@ManagedBean
@ViewScoped
public class ReadMessagesBean implements Serializable {

	@ManagedProperty(value = "#{messageService}")
	MessageService messageService;

	@ManagedProperty(value = "#{userService}")
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public List<MessageVO> getMessages() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Long id = null;
		try {
			id = userService.findUserByName(auth.getName()).getId();
			return messageService.getMessages(id);
		} catch (Exception e) {
			System.out.println("Exception caught while getting user messages!");
		}
		return null;
		
	}

	public void setMessages(List<MessageVO> messages) {
		this.messages = messages;
	}

	public MessageVO getSelectedMessage() {
		return selectedMessage;
	}

	public void setSelectedMessage(MessageVO selectedMessage) {
		this.selectedMessage = selectedMessage;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<MessageVO> messages;
	
	private MessageVO selectedMessage;
	
	private List<String> shortMessages;
	
	public void onRowSelect(SelectEvent event) {
		selectedMessage = (MessageVO) event.getObject();
        //FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
    	selectedMessage = null;
        //FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	public List<String> getShortMessages() {
		List<String> msgs = new ArrayList<String>();
		int i = 0;
		String temp = "";
		
		System.out.println("Üzeneteid:");
		messages = getMessages();
		for(MessageVO m: messages) {
			temp = "";
			temp = m.getContent().substring(0, 15);
			temp = temp.replace("[","");
			temp = temp.replace("]", "");
			temp+="...";
			msgs.add(temp);
			System.out.println(msgs.get(i++));
		}
		setShortMessages(msgs);
		return shortMessages;
	}

	public void setShortMessages(List<String> shortMessages) {
		this.shortMessages = shortMessages;
	}
}
