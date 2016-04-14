package cs.mum.edu.yongchao.daoLayer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs.mum.edu.yongchao.entity.ArtistBean;
import cs.mum.edu.yongchao.entity.DirectorBean;

public interface DirectorDao extends JpaRepository<DirectorBean, Integer> {

  List<ArtistBean> findByFirstName(String firstName);

  List<ArtistBean> findByLastName(String lastName);
}
