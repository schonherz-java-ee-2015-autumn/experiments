package hu.neuron.java.service.vo;

import java.util.Date;

public class MessageVO {

	private String content;

	
	private Date sendDate;
	
	
	private UserVO sendUser;
	
	
	private UserVO targetUser;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public UserVO getSendUser() {
		return sendUser;
	}

	public void setSendUser(UserVO sendUser) {
		this.sendUser = sendUser;
	}

	public UserVO getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(UserVO targetUser) {
		this.targetUser = targetUser;
	}
}
