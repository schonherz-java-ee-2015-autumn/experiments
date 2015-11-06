package hu.schonherz.training.registration;

import java.util.Arrays;

import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.person.BeanFactory;
import hu.schonherz.training.person.BeanParser;
import hu.schonherz.training.person.Person;
import hu.schonherz.training.validation.RuleValidator;
import hu.schonherz.training.validation.rulesimpl.DateStringRule;
import hu.schonherz.training.validation.rulesimpl.EmailValidatorRule;
import hu.schonherz.training.validation.rulesimpl.FirstNameRule;
import hu.schonherz.training.validation.rulesimpl.LastNameRule;
import hu.schonherz.training.validation.rulesimpl.LocationValidatorRule;
import hu.schonherz.training.validation.rulesimpl.PasswordConfirmationIsTheSameRule;
import hu.schonherz.training.validation.rulesimpl.PasswordValidationRule;
import hu.schonherz.training.validation.rulesimpl.PhoneNumberRule;
import hu.schonherz.training.validation.rulesimpl.UserNameOccupiedRule;

public class PersonRegistrationRequestToPersonConverter implements Converter<Person> {

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

		BeanFactory<Person> personFactory = new BeanFactory<Person>(new BeanParser<Person>() {

			@Override
			public Person parse() {
				return new Person(request.getUserName(), request.getTitle(), request.getFirstName(),
						request.getLastName(), request.getDateOfBirth(), request.getEmail(), request.getPhoneNumber(),
						request.getPassword(), request.getCity());
			}
		});

		return personFactory.getInstance();
	}

}
