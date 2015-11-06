package hu.schonherz.training.usermanager;

import java.util.List;

import hu.schonherz.training.exception.ViolationException;
import hu.schonherz.training.person.Person;
import hu.schonherz.training.person.PublicPerson;
import hu.schonherz.training.refresher.RefreshRequest;
import hu.schonherz.training.registration.PersonRegistrationRequest;

public interface UserProvider {
	public List<PublicPerson> getUsers(RefreshRequest request) throws ManipulatedRequestException;
	
	public void deleteUser(Person person);
	
	public void registratePerson(PersonRegistrationRequest request) throws ViolationException;
	
	public void updatePerson(Person person);
	
	public boolean isUserNameOccupied(String userName);
}
