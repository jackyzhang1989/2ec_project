package cs.mum.edu.extraCredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cs.mum.edu.extraCredit.dao.ArtistDao;
import cs.mum.edu.extraCredit.model.Artist;

@Transactional
public class ArtistServiceImpl implements ArtistService {

	private ArtistDao artistDao;

	@Autowired
	public void setArtistDao(ArtistDao repository){
		this.artistDao = repository;
	}

	
	public List<Artist> getAll() {

		return artistDao.findAll();
	}

	public void create(Artist artist) {

		artistDao.save(artist);
	}

	public void update(int id, Artist artist) {
		artist.setId(id);	
		artistDao.save(artist);
	}

	public void delete(int id) {

		Artist artist = artistDao.findOne(id);
		artistDao.delete(artist);
	}

	public Artist get(int id) {

		return artistDao.findOne(id);
	}

}
