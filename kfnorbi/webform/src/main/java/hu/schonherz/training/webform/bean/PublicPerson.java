package hu.schonherz.training.webform.bean;

import java.io.Serializable;
import java.util.Date;

public class PublicPerson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String userName;
	protected String name;
	protected Date dateOfBirth;
	protected String email;
	protected String phoneNumber;
	protected String city;

	public PublicPerson(Person p) {
		this.userName = p.getUserName();
		this.name = p.getTitle() + " " + p.getFirstName() + " " + p.getLastName();
		this.dateOfBirth = p.getDateOfBirth();
		this.email = p.getEmail();
		this.phoneNumber = p.getPhoneNumber();
		this.city = p.getCity();
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

}
