package cs.mum.edu.yongchao.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs.mum.edu.yongchao.entity.Artist;
import cs.mum.edu.yongchao.entity.Director;

public interface DirectorDao extends JpaRepository<Director, Integer>{

	List<Artist> findByFirstName(String firstName);
	List<Artist> findByLastName(String lastName);
}
