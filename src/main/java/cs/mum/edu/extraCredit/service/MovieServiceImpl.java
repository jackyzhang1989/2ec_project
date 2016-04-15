package cs.mum.edu.extraCredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cs.mum.edu.extraCredit.dao.MovieDao;
import cs.mum.edu.extraCredit.model.Genre;
import cs.mum.edu.extraCredit.model.Movie;
import cs.mum.edu.extraCredit.model.Rating;

@Transactional
public class MovieServiceImpl implements MovieService {

	private MovieDao movieDao;

	@Autowired
	public void setMovieDao(MovieDao repository){
		this.movieDao = repository;
	}
	
	public List<Movie> getAll() {

		return movieDao.findAll();
	}

	public void create(Movie movie) {

		movieDao.save(movie);
	}

	public void update(int id, Movie movie) {
		movie.setId(id);	
		movieDao.save(movie);
	}

	public void delete(int id) {

		Movie movie = movieDao.findOne(id);
		movieDao.delete(movie);
	}

	public Movie get(int id) {

		return movieDao.findOne(id);
	}

	public List<Movie> findByName(String name) {
		return movieDao.findByName(name);
	}

	public List<Movie> findByYear(int year) {
		return movieDao.findByYear(year);
	}

	public List<Movie> findByGenres(String genres) {
		return movieDao.findByGenres(Genre.valueOf(genres));
	}

	public List<Movie> findByRating(Rating rating) {
		return movieDao.findByRating(rating);
	}

	public List<Movie> findByArtists(String name) {
		return movieDao.findByArtists(name);
	}

	public List<Movie> findByDirectors(String name) {
		return movieDao.findByDirectors(name);
	}

}
