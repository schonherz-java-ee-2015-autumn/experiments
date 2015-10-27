package hu.schonherz.training.webform.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonBuilder {
	protected String userName;
	protected String title;
	protected String firstname;
	protected String lastname;
	protected Date dateOfBirth;
	protected String email;
	protected String phoneNumber;
	protected String password;
	protected String city;

	
	
	/**
	 * @param userName the userName to set
	 */
	public PersonBuilder setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public PersonBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public PersonBuilder setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public PersonBuilder setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public PersonBuilder setDateOfBirth(String dateOfBirth) {
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		try {
			this.dateOfBirth = format.parse(dateOfBirth);
		} catch (ParseException e) {
		}
		return this;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public PersonBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public PersonBuilder setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public PersonBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public PersonBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	public Person build() {
		return new Person(userName, title, firstname, lastname, dateOfBirth, email, phoneNumber, password, city);
	}

}
