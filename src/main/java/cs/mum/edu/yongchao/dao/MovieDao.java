package cs.mum.edu.yongchao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cs.mum.edu.yongchao.entity.Artist;
import cs.mum.edu.yongchao.entity.Genre;
import cs.mum.edu.yongchao.entity.Movie;
import cs.mum.edu.yongchao.entity.Rating;

import java.util.*;

public interface MovieDao extends JpaRepository<Movie, Integer>{

	List<Movie> findByName(String name);
	List<Movie> findByYear(int year);
	List<Movie> findByGenres(Genre genres);
	List<Movie> findByRating(Rating rating);
	
	@Query("FROM Movie m join m.artists a where LOWER(a.firstName) LIKE '%' + LOWER(:name) + '%' OR LOWER(a.lastName) LIKE '%' + LOWER(:name) + '%'")
	List<Movie> findByArtists(@Param("name") String name);
	
	@Query("FROM Movie m join m.directors a where LOWER(a.firstName) LIKE '%' + LOWER(:name) + '%' OR LOWER(a.lastName) LIKE '%' + LOWER(:name) + '%'")
	List<Movie> findByDirectors(@Param("name") String name);
}
