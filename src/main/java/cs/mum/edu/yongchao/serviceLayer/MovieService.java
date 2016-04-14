package cs.mum.edu.yongchao.serviceLayer;

import java.util.List;

import cs.mum.edu.yongchao.entity.GenreBean;
import cs.mum.edu.yongchao.entity.MovieBean;
import cs.mum.edu.yongchao.entity.RatingBean;

public interface MovieService {

  List<MovieBean> getAll();

  void create(MovieBean movie);

  void update(int id, MovieBean movie);

  void delete(int id);

  MovieBean get(int id);

  List<MovieBean> findByName(String name);

  List<MovieBean> findByYear(int year);

  List<MovieBean> findByGenres(String genres);

  List<MovieBean> findByRating(RatingBean rating);

  List<MovieBean> findByArtists(String name);

  List<MovieBean> findByDirectors(String name);
}
