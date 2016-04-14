package cs.mum.edu.yongchao.serviceLayer;

import java.util.List;

import cs.mum.edu.yongchao.entity.ArtistBean;

public interface ArtistService {

  List<ArtistBean> getAll();

  void create(ArtistBean artist);

  void update(int id, ArtistBean artist);

  void delete(int id);

  ArtistBean get(int id);
}
