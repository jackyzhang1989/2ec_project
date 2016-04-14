package cs.mum.edu.yongchao.serviceLayer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cs.mum.edu.yongchao.daoLayer.DirectorDao;
import cs.mum.edu.yongchao.entity.DirectorBean;
import cs.mum.edu.yongchao.serviceLayer.DirectorService;

@Transactional
public class DirectorServiceImpl implements DirectorService {
  private DirectorDao directorDao;

  @Autowired
  public void setDirectorDao(DirectorDao repository) {
    this.directorDao = repository;
  }

  public List<DirectorBean> getAll() {

    return directorDao.findAll();
  }

  public void create(DirectorBean director) {

    directorDao.save(director);
  }

  public void update(int id, DirectorBean director) {
    director.setId(id);
    directorDao.save(director);
  }

  public void delete(int id) {

    DirectorBean director = directorDao.findOne(id);
    directorDao.delete(director);
  }

  public DirectorBean get(int id) {

    return directorDao.findOne(id);
  }

}

