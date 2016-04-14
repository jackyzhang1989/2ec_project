package cs.mum.edu.yongchao.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Director")
public class DirectorBean {

  @Id
  @GeneratedValue
  private int id;
  private String firstName;
  private String lastName;

  @ManyToMany(mappedBy = "directors")
  private List<MovieBean> movies = new ArrayList<>();

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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
