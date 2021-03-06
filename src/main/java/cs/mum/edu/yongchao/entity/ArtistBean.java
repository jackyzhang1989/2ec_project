package cs.mum.edu.yongchao.entity;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Artist")
@SecondaryTable(name = "ArtistImage")
public class ArtistBean {

  @Id
  @GeneratedValue
  private int id;

  @NotBlank(message = "FirstName cannot be blank")
  private String firstName;

  @NotBlank(message = "LastName cannot be blank")
  private String lastName;

  @NotNull(message = "DOB cannot be blank")
  @Temporal(TemporalType.TIMESTAMP)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Past
  private Date dateOfBirth;

  @NotBlank(message = "Place of Birth cannot be blank")
  private String placeOfBirth;

  @NotBlank(message = "Biography cannot be blank")
  @Lob
  @Column
  private String biography;

  @Lob
  @Column(table = "ArtistImage")
  private byte[] image;

  @ManyToMany(mappedBy = "artists")
  private List<MovieBean> movies = new ArrayList<>();

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dob) {
    this.dateOfBirth = dob;
  }

  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public List<MovieBean> getMovies() {
    return movies;
  }

  public void setMovies(List<MovieBean> movies) {
    this.movies = movies;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return this.firstName + " " + this.lastName;
  }

}
