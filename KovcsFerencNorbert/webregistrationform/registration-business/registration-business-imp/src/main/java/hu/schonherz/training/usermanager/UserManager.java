package hu.schonherz.training.usermanager;

import java.util.List;

import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.person.Person;
import hu.schonherz.training.person.PublicPerson;
import hu.schonherz.training.refresher.RefreshRequest;
import hu.schonherz.training.refresher.RefreshRequestToRequestParamsConverter;
import hu.schonherz.training.registration.PersonRegistrationRequest;
import hu.schonherz.training.registration.PersonRegistrationRequestToPersonConverter;
import hu.schonherz.training.registrator.DataHandlerDAO;
import hu.schonherz.training.registrator.PersonRegister;

public class UserManager implements UserProvider {

	
	
	public List<PublicPerson> getUsers(RefreshRequest request) throws ManipulatedRequestException {

		RefreshRequestToRequestParamsConverter converter = new RefreshRequestToRequestParamsConverter(request);

		DataHandlerDAO dao = new PersonRegister();

		try {
			return dao.getAllUsers(converter.convert());
		} catch (ViolationException e) {
			throw new ManipulatedRequestException(e);
		}

	}

	@Override
	public void deleteUser(Person person) {
		DataHandlerDAO dao = new PersonRegister();

		dao.delete(person);
	}

	@Override
	public void registratePerson(PersonRegistrationRequest request) throws ViolationException {
		PersonRegistrationRequestToPersonConverter converter = new PersonRegistrationRequestToPersonConverter(request);

		DataHandlerDAO dao = new PersonRegister();

		dao.register(converter.convert());
	}

	@Override
	public void updatePerson(Person person) {
		DataHandlerDAO dao = new PersonRegister();

		dao.update(person);
	}

	@Override
	public boolean isUserNameOccupied(String userName) {
		DataHandlerDAO dao = new PersonRegister();

		return dao.isOccupied(userName);
	}
}
