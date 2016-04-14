package cs.mum.edu.yongchao.controllerLayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs.mum.edu.yongchao.entity.ArtistBean;
import cs.mum.edu.yongchao.entity.DirectorBean;
import cs.mum.edu.yongchao.entity.GenreBean;
import cs.mum.edu.yongchao.entity.MovieBean;
import cs.mum.edu.yongchao.entity.RatingBean;
import cs.mum.edu.yongchao.serviceLayer.ArtistService;
import cs.mum.edu.yongchao.serviceLayer.DirectorService;
import cs.mum.edu.yongchao.serviceLayer.MovieService;
import cs.mum.edu.yongchao.viewmodel.FilterCriteria;

@Controller
public class MovieController {

  @Autowired
  private MovieService movieService;

  @Autowired
  private ArtistService artistService;

  @Autowired
  private DirectorService directorService;

  // public void setMovieService(MovieService movieService) {
  // this.movieService = movieService;
  // }

  // @Autowired
  // private ConversionService conversionService;
  //
  // @InitBinder
  // protected void initBinder(ServletRequestDataBinder binder) {
  //
  // binder.setConversionService(conversionService);
  // }

  @RequestMapping(value = {"/", "/movie", "/movies"}, method = RequestMethod.GET)
  public String index(Model model) {

    String searchText = (String) model.asMap().get("searchText");
    String filterCriteria = (String) model.asMap().get("filterCriteria");

    List<MovieBean> movieList = new ArrayList<>();
    if (searchText != null && filterCriteria != null) {
      System.out.println("Filtering data with: " + searchText + " & " + filterCriteria);
      movieList = getFilteredMovies(searchText, filterCriteria);
    } else {

      movieList = movieService.getAll();
    }
    model.addAttribute("movieList", movieList);
    model.addAttribute("filter", new FilterCriteria());
    model.addAttribute("filterList", getFilterList());

    return "Movie/movieList";
  }

  @RequestMapping(value = "/movies/search", method = RequestMethod.POST)
  public String search(@Valid FilterCriteria filter, BindingResult result,
      RedirectAttributes redirectAttr) {

    System.out.println(filter.getId() + " " + filter.getText());
    redirectAttr.addFlashAttribute("searchText", filter.getText());
    redirectAttr.addFlashAttribute("filterCriteria", filter.getId());

    if (result.hasErrors())
      System.out.println("Searching for the term" + result.hasErrors());
    return "redirect:/movie";
  }

  @RequestMapping(value = "/movies/add", method = RequestMethod.GET)
  public String add(Model model) {

    MovieBean movie = new MovieBean();
    GenreBean[] genres = GenreBean.values();
    movie.setGenres(Arrays.asList(genres));

    RatingBean[] ratings = RatingBean.values();

    List<ArtistBean> artists = artistService.getAll();
    movie.setArtists(artists);

    List<DirectorBean> directors = directorService.getAll();
    movie.setDirectors(directors);

    model.addAttribute("movie", movie);
    model.addAttribute("ratings", Arrays.asList(ratings));
    return "Movie/addMovie";
  }

  @RequestMapping(value = "/movies/add", method = RequestMethod.POST)
  public String add(@Valid MovieBean movie, BindingResult result) {

    System.out.println(result.hasErrors());
    if (result.hasErrors())
      return "Movie/addMovie";

    movieService.create(movie);
    return "redirect:/movies";
  }

  @RequestMapping(value = "/movies/update/{id}", method = RequestMethod.GET)
  public String update(@PathVariable int id, Model model) {

    MovieBean movie = movieService.get(id);
    model.addAttribute("movie", movie);

    RatingBean[] ratings = RatingBean.values();
    model.addAttribute("ratings", Arrays.asList(ratings));

    GenreBean[] genres = GenreBean.values();
    model.addAttribute("genres", Arrays.asList(genres));

    model.addAttribute("artists", artistService.getAll());
    model.addAttribute("directors", directorService.getAll());

    return "Movie/updateMovie";
  }

  @RequestMapping(value = "/movies/update/{id}", method = RequestMethod.POST)
  public String update(@Valid MovieBean movie, @PathVariable int id, BindingResult result) {

    if (result.hasErrors())
      return "redirect:/movies/update/" + id;

    movieService.update(id, movie);

    return "redirect:/movies";
  }

  @RequestMapping(value = "/movies/delete/{id}", method = RequestMethod.POST)
  public String delete(@PathVariable int id) {

    movieService.delete(id);
    return "redirect:/movies";
  }

  private List<FilterCriteria> getFilterList() {

    List<FilterCriteria> list = new ArrayList<>();
    list.add(new FilterCriteria("1", "Name of Movie", ""));
    list.add(new FilterCriteria("2", "Genre of Movie", ""));
    list.add(new FilterCriteria("3", "Rating of Movie", ""));
    list.add(new FilterCriteria("4", "Year of Movie", ""));
    list.add(new FilterCriteria("5", "Name of Artist", ""));
    list.add(new FilterCriteria("6", "Director of Movie", ""));

    return list;

  }

  private List<MovieBean> getFilteredMovies(String text, String idVal) {

    switch (idVal) {
      case "2":
        return movieService.findByGenres(text);
      case "3":
        return movieService.findByRating(RatingBean.valueOf(text));

      case "4":
        return movieService.findByYear(Integer.parseInt(text));
      case "5":
        return movieService.findByArtists(text);
      case "6":
        return movieService.findByDirectors(text);

      default:
        return movieService.findByName(text);
    }

  }

}
