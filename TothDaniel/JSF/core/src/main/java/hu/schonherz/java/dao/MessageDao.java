package hu.schonherz.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hu.schonherz.java.entities.Message;

@Repository
public interface MessageDao extends JpaRepository<Message, Long> {


	List<Message> findMessages(@Param("from")Long target, @Param("to")Long send);
}
