package hu.schonherz.training.registration;

import hu.schonherz.training.person.BeanParser;

public class PersonRegistrationRequestFactory {

	BeanParser<PersonRegistrationRequest> parser;

	public PersonRegistrationRequestFactory(BeanParser<PersonRegistrationRequest> parser) {
		super();
		this.parser = parser;
	}
	
	public PersonRegistrationRequest getInstance(){
		return parser.parse();
	}
	
}
