package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
public class PersonController {

    @Autowired
    Validator validator;

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @RequestMapping(value = "/addperson")
    public String addPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "addPerson";
    }

    @RequestMapping(value = "/addperson", method = RequestMethod.POST)
    public String savePerson(@Valid Person person, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("person", person);
            return "addPerson";
        } else {
            personDao.save(person);
        }
        return "redirect:/persons";
    }

    @ResponseBody
    @RequestMapping("/getperson{param}")
    public String getBook(@PathVariable long param) {
        Person person = personDao.findById(param);
        return person.toString();
    }

    @ResponseBody
    @RequestMapping("/delperson{param}")
    public String delBook(@PathVariable long param) {
        Person person = personDao.findById(param);
        personDao.delete(person);
        return "--delete--";
    }

    @ResponseBody
    @RequestMapping("/editperson{param}")
    public String editBook(@PathVariable long param) {
        Person person = personDao.findById(param);
        person.setEmail("nowak@o2.pl");
        person.setLogin("nowak");
        person.setPassword("####@@@@");
        personDao.update(person);
        return "--edit--";
    }

    @RequestMapping("/persons")
    public String getList(Model model) {
        model.addAttribute("persons", personDao.getAll());
        return "personlist";
    }
}
