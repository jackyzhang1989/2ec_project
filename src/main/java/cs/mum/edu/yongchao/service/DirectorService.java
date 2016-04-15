package cs.mum.edu.yongchao.service;

import java.util.List;

import cs.mum.edu.yongchao.entity.Director;

public interface DirectorService {

	List<Director> getAll();
	void create(Director director);
	void update(int id, Director director);
	void delete(int id);
	Director get(int id);
}
