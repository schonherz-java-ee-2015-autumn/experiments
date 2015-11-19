package hu.schonherz.java.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message  extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1;
	
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date sentOnDate;
	@OneToOne
	User fromUser;
	@OneToOne
	User toUser;
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
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
	}
	
	

}
