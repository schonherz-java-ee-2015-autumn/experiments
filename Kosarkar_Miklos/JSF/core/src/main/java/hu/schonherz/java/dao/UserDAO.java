package hu.schonherz.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.schonherz.java.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	User findByUsername(String username);
	
	Long countByUsername(String username);
}
