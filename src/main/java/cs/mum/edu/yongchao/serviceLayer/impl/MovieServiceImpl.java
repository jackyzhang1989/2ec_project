package cs.mum.edu.yongchao.serviceLayer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cs.mum.edu.yongchao.daoLayer.MovieDao;
import cs.mum.edu.yongchao.entity.GenreBean;
import cs.mum.edu.yongchao.entity.MovieBean;
import cs.mum.edu.yongchao.entity.RatingBean;
import cs.mum.edu.yongchao.serviceLayer.MovieService;

@Transactional
public class MovieServiceImpl implements MovieService {

  private MovieDao movieDao;

  @Autowired
  public void setMovieDao(MovieDao repository) {
    this.movieDao = repository;
  }


  public void create(MovieBean movie) {

    movieDao.save(movie);
  }

  public List<MovieBean> getAll() {
    
    return movieDao.findAll();
  }

  public void delete(int id) {

    MovieBean movie = movieDao.findOne(id);
    movieDao.delete(movie);
  }

  public MovieBean get(int id) {

    return movieDao.findOne(id);
  }
  public List<MovieBean> findByYear(int year) {
    return movieDao.findByYear(year);
  }
  
  public List<MovieBean> findByDirectors(String name) {
    return movieDao.findByDirectors(name);
  }
  
  public void update(int id, MovieBean movie) {
    movie.setId(id);
    movieDao.save(movie);
  }

  public List<MovieBean> findByName(String name) {
    return movieDao.findByName(name);
  }

  public List<MovieBean> findByRating(RatingBean rating) {
    return movieDao.findByRating(rating);
  }
  public List<MovieBean> findByGenres(String genres) {
    return movieDao.findByGenres(GenreBean.valueOf(genres));
  }


  public List<MovieBean> findByArtists(String name) {
    return movieDao.findByArtists(name);
  }

}
