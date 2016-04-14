package cs.mum.edu.yongchao.service;

import java.util.List;

import cs.mum.edu.yongchao.entity.Artist;

public interface ArtistService {

  List<Artist> getAll();

  void create(Artist artist);

  void update(int id, Artist artist);

  void delete(int id);

  Artist get(int id);
}
