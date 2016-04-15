package cs.mum.edu.yongchao.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs.mum.edu.yongchao.entity.Artist;

public interface ArtistDao extends JpaRepository<Artist, Integer>{

	List<Artist> findByFirstName(String firstName);
	List<Artist> findByLastName(String lastName);
	
	
	
}
