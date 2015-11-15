package hu.schonherz.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.schonherz.java.entities.Role;
import hu.schonherz.java.entities.User;
@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
		Role findByName(String name);
}
