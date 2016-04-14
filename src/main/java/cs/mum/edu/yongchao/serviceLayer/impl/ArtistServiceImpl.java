package cs.mum.edu.yongchao.serviceLayer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cs.mum.edu.yongchao.daoLayer.ArtistDao;
import cs.mum.edu.yongchao.entity.ArtistBean;
import cs.mum.edu.yongchao.serviceLayer.ArtistService;

@Transactional
public class ArtistServiceImpl implements ArtistService {

  private ArtistDao artistDao;

  @Autowired
  public void setArtistDao(ArtistDao repository) {
    this.artistDao = repository;
  }


  public List<ArtistBean> getAll() {

    return artistDao.findAll();
  }

  public void create(ArtistBean artist) {

    artistDao.save(artist);
  }

  public void update(int id, ArtistBean artist) {
    artist.setId(id);
    artistDao.save(artist);
  }

  public void delete(int id) {

    ArtistBean artist = artistDao.findOne(id);
    artistDao.delete(artist);
  }

  public ArtistBean get(int id) {

    return artistDao.findOne(id);
  }

}
