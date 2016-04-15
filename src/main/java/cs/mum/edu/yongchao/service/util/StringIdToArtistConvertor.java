package cs.mum.edu.yongchao.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import cs.mum.edu.yongchao.dao.ArtistDao;
import cs.mum.edu.yongchao.entity.Artist;

public class StringIdToArtistConvertor implements Converter<String[], List<Artist>> {

private ArtistDao artistDao;
	
	@Autowired
	public void setArtistDao(ArtistDao repository){
		this.artistDao = repository;
	}
	
	@Override
	public List<Artist> convert(String[] source) {
		
		List<Artist> artists = new ArrayList<>();
		
		for(String idVal: source){
			int id = Integer.parseInt(idVal);
			
			artists.add(artistDao.getOne(id));
		}
		
		return artists;
	}
}
