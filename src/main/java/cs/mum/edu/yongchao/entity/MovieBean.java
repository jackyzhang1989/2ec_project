package cs.mum.edu.yongchao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotBlank;

import java.util.*;

@Entity
@Table(name="Movie")
@SecondaryTable(name = "MoviePoster")
public class MovieBean {

  @Id
  @GeneratedValue
  private int id;

  @NotNull(message = "MovieBean release year cannot be blank")
  private int year;

  @NotBlank(message = "MovieBean name cannot be blank")
  private String name;

  @Lob
  @Column(table = "MoviePoster")
  private byte[] poster;

  @NotBlank(message = "MovieBean summary cannot be blank")
  private String summary;

  @Enumerated(EnumType.STRING)
  private RatingBean rating;

  @ElementCollection(fetch = FetchType.EAGER)
  @OrderColumn(name = "position")
  @Enumerated(EnumType.STRING)
  private List<GenreBean> genres = new ArrayList<>();

  @ElementCollection(fetch = FetchType.EAGER)
  @OrderColumn(name = "position")
  private List<String> comments = new ArrayList<>();


  @ManyToMany(fetch = FetchType.EAGER)
  @Cascade(value = {org.hibernate.annotations.CascadeType.DELETE})
  @JoinTable(name = "MovieDirector")
  private List<DirectorBean> directors = new ArrayList<>();

  @ManyToMany(fetch = FetchType.EAGER)
  @Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
  @JoinTable(name = "MovieArtist")
  private List<ArtistBean> artists = new ArrayList<>();

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getName() {
    return name;
  }

  public void setName(String title) {
    this.name = title;
  }

  public byte[] getPoster() {
    return poster;
  }

  public void setPoster(byte[] poster) {
    this.poster = poster;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public RatingBean getRating() {
    return rating;
  }

  public void setRating(RatingBean rating) {
    this.rating = rating;
  }

  public List<GenreBean> getGenres() {
    return genres;
  }

  public void setGenres(List<GenreBean> genres) {
    this.genres = genres;
  }

  public List<String> getComments() {
    return comments;
  }

  public void setComments(List<String> comments) {
    this.comments = comments;
  }

  public List<DirectorBean> getDirectors() {
    return directors;
  }

  public void setDirectors(List<DirectorBean> directors) {
    this.directors = directors;
  }

  public List<ArtistBean> getArtists() {
    return artists;
  }

  public void setArtists(List<ArtistBean> artists) {
    this.artists = artists;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
