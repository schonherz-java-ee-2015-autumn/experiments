package hu.schonherz.training.registrator;

import java.util.List;

import hu.schonherz.training.person.Person;
import hu.schonherz.training.person.PublicPerson;
import hu.schonherz.training.refresher.RefreshParams;

public interface DataHandlerDAO {
	
	public List<PublicPerson> getAllUsers(RefreshParams params);

	public Long register(Person person);
	
	public void update(Person person) throws NullPointerException;
	
	public void delete(Person person) throws NullPointerException;
	
	public boolean isOccupied(String userName);
	
}
