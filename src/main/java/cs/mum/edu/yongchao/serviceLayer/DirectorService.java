package cs.mum.edu.yongchao.serviceLayer;

import java.util.List;

import cs.mum.edu.yongchao.entity.DirectorBean;

public interface DirectorService {

  List<DirectorBean> getAll();

  void create(DirectorBean director);

  void update(int id, DirectorBean director);

  void delete(int id);

  DirectorBean get(int id);
}
