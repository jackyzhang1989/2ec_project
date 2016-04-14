package cs.mum.edu.yongchao.daoLayer;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs.mum.edu.yongchao.entity.ArtistBean;

public interface ArtistDao extends JpaRepository<ArtistBean, Integer> {

  List<ArtistBean> findByFirstName(String firstName);

  List<ArtistBean> findByLastName(String lastName);



}
