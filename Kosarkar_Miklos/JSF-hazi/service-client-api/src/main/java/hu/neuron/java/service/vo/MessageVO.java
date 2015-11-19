package hu.neuron.java.service.vo;

import java.util.Date;

public class MessageVO {

	private Long id;
	private String content;
	private Date sentOnDate;
	private UserVO fromUser;
	private UserVO toUser;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSentOnDate() {
		return sentOnDate;
	}
	public void setSentOnDate(Date sentOnDate) {
		this.sentOnDate = sentOnDate;
	}
	public UserVO getFromUser() {
		return fromUser;
	}
	public void setFromUser(UserVO fromUser) {
		this.fromUser = fromUser;
	}
	public UserVO getToUser() {
		return toUser;
	}
	public void setToUser(UserVO toUser) {
		this.toUser = toUser;
	}

	
}
