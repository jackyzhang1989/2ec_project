package cs.mum.edu.yongchao.controllerLayer;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs.mum.edu.yongchao.entity.DirectorBean;
import cs.mum.edu.yongchao.serviceLayer.DirectorService;

@Controller
public class DirectorController {


  @Autowired
  private DirectorService directorService;



  @RequestMapping(value = "/directors", method = RequestMethod.GET)
  public String index(Model model) {

    List<DirectorBean> directorList = directorService.getAll();
    model.addAttribute("directorList", directorList);

    return "Director/directorList";
  }

  @RequestMapping(value = "/directors/add", method = RequestMethod.GET)
  public String add(Model model) {

    model.addAttribute("director", new DirectorBean());
    return "Director/addDirector";
  }

  @RequestMapping(value = "/directors/add", method = RequestMethod.POST)
  public String add(@Valid DirectorBean director, BindingResult result) {

    System.out.println(result.hasErrors());
    if (result.hasErrors())
      return "Director/addDirector";

    directorService.create(director);
    return "redirect:/directors";
  }

  @RequestMapping(value = "/directors/update/{id}", method = RequestMethod.GET)
  public String update(@PathVariable int id, Model model) {

    DirectorBean director = directorService.get(id);
    model.addAttribute("director", director);

    return "Director/updateDirector";
  }

  @RequestMapping(value = "/directors/update/{id}", method = RequestMethod.POST)
  public String update(@Valid DirectorBean director, @PathVariable int id, BindingResult result) {

    if (result.hasErrors())
      return "redirect:/directors/update/" + id;

    directorService.update(id, director);

    return "redirect:/directors";
  }

  @RequestMapping(value = "/directors/delete/{id}", method = RequestMethod.POST)
  public String delete(@PathVariable int id) {

    directorService.delete(id);
    return "redirect:/directors";
  }


}
