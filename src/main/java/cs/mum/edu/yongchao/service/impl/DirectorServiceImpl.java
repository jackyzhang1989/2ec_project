package cs.mum.edu.yongchao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cs.mum.edu.yongchao.dao.DirectorDao;
import cs.mum.edu.yongchao.entity.Director;
import cs.mum.edu.yongchao.service.DirectorService;

@Transactional
public class DirectorServiceImpl implements DirectorService{
	private DirectorDao directorDao;

	@Autowired
	public void setDirectorDao(DirectorDao repository){
		this.directorDao = repository;
	}
	
	public List<Director> getAll() {

		return directorDao.findAll();
	}

	public void create(Director director) {

		directorDao.save(director);
	}

	public void update(int id, Director director) {
		director.setId(id);	
		directorDao.save(director);
	}

	public void delete(int id) {

		Director director = directorDao.findOne(id);
		directorDao.delete(director);
	}

	public Director get(int id) {

		return directorDao.findOne(id);
	}

}

