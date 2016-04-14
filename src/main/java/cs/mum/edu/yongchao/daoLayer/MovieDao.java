package cs.mum.edu.yongchao.daoLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs.mum.edu.yongchao.entity.ArtistBean;
import cs.mum.edu.yongchao.entity.GenreBean;
import cs.mum.edu.yongchao.entity.MovieBean;
import cs.mum.edu.yongchao.entity.RatingBean;

import java.util.*;

public interface MovieDao extends JpaRepository<MovieBean, Integer> {

  List<MovieBean> findByName(String name);

  List<MovieBean> findByYear(int year);

  List<MovieBean> findByGenres(GenreBean genres);

  List<MovieBean> findByRating(RatingBean rating);

  @Query("FROM MovieBean m join m.artists a where LOWER(a.firstName) LIKE '%' + LOWER(:name) + '%' OR LOWER(a.lastName) LIKE '%' + LOWER(:name) + '%'")
  List<MovieBean> findByArtists(@Param("name") String name);

  @Query("FROM MovieBean m join m.directors a where LOWER(a.firstName) LIKE '%' + LOWER(:name) + '%' OR LOWER(a.lastName) LIKE '%' + LOWER(:name) + '%'")
  List<MovieBean> findByDirectors(@Param("name") String name);
}
