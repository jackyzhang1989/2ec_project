package cs.mum.edu.yongchao.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cs.mum.edu.yongchao.daoLayer.ArtistDao;
import cs.mum.edu.yongchao.entity.ArtistBean;


public final class ArtistFormatter implements Converter<String[], List<ArtistBean>> {


  private ArtistDao artistDao;

  @Autowired
  public void setArtistDao(ArtistDao repository) {
    this.artistDao = repository;
  }

  @Override
  public List<ArtistBean> convert(String[] source) {

    List<ArtistBean> artists = new ArrayList<>();

    for (String idVal : source) {
      int id = Integer.parseInt(idVal);

      artists.add(artistDao.getOne(id));
    }

    return artists;
  }

}
