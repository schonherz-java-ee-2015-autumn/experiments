package hu.schonherz.java.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.schonherz.java.entities.News;
@Repository
public interface NewsDao extends JpaRepository<News, Long> {
	List<News> selectAll();	
	
}
