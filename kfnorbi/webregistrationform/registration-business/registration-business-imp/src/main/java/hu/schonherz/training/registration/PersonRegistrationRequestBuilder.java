package hu.schonherz.training.registration;
@Deprecated
public class PersonRegistrationRequestBuilder {

	protected String userName;
	protected String title;
	protected String firstName;
	protected String lastName;
	protected String dateOfBirth;
	protected String email;
	protected String phoneNumber;
	protected String password;
	protected String city;
	protected String passwordConfirmation;

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public PersonRegistrationRequestBuilder setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public PersonRegistrationRequestBuilder setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public PersonRegistrationRequestBuilder setTitle(String title) {
		this.title = title;
		return this;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public PersonRegistrationRequestBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public PersonRegistrationRequestBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public PersonRegistrationRequestBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public PersonRegistrationRequestBuilder setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public PersonRegistrationRequestBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public PersonRegistrationRequestBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	/**
	 * @param passwordConfirmation
	 *            the passwordConfirmation to set
	 */
	public PersonRegistrationRequestBuilder setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
		return this;
	}

	public PersonRegistrationRequest build() {
		return new PersonRegistrationRequest(userName, title, firstName, lastName, dateOfBirth, email, phoneNumber,
				password, city, passwordConfirmation);
	}

}
