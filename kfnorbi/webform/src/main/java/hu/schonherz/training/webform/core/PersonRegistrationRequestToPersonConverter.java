package hu.schonherz.training.webform.core;

import java.util.Arrays;

import hu.schonherz.training.validation.RuleValidator;
import hu.schonherz.training.validation.ViolationException;
import hu.schonherz.training.validation.webform.rules.DateStringRule;
import hu.schonherz.training.validation.webform.rules.EmailValidatorRule;
import hu.schonherz.training.validation.webform.rules.FirstNameRule;
import hu.schonherz.training.validation.webform.rules.LastNameRule;
import hu.schonherz.training.validation.webform.rules.LocationValidatorRule;
import hu.schonherz.training.validation.webform.rules.PasswordConfirmationIsTheSameRule;
import hu.schonherz.training.validation.webform.rules.PasswordValidationRule;
import hu.schonherz.training.validation.webform.rules.PhoneNumberRule;
import hu.schonherz.training.validation.webform.rules.UserNameOccupiedRule;
import hu.schonherz.training.webform.bean.Person;
import hu.schonherz.training.webform.bean.PersonBuilder;

public class PersonRegistrationRequestToPersonConverter {

	PersonRegistrationRequest request;

	public PersonRegistrationRequestToPersonConverter(PersonRegistrationRequest request) {
		this.request = request;
	}

	public Person convert() throws ViolationException {

		RuleValidator<PersonRegistrationRequest> ruleValidator = new RuleValidator<PersonRegistrationRequest>(
				Arrays.asList(new DateStringRule(), new EmailValidatorRule(), new FirstNameRule(), new LastNameRule(),
						new PhoneNumberRule(), new UserNameOccupiedRule(), new PasswordConfirmationIsTheSameRule(),
						new LocationValidatorRule(), new PasswordValidationRule()));

		ruleValidator.validate(request);

		PersonBuilder builder = new PersonBuilder();

		Person p = builder.setUserName(request.getUserName()).setFirstname(request.getFirstName())
				.setLastname(request.getLastName()).setTitle(request.getTitle())
				.setDateOfBirth(request.getDateOfBirth()).setPassword(request.getPassword())
				.setPhoneNumber(request.getPhoneNumber()).setEmail(request.getEmail()).setCity(request.getCity())
				.build();

		return p;
	}

}
