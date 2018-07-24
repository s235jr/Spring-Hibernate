package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

@Controller
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @RequestMapping(value = "/addperson", method = RequestMethod.GET)
    public String addPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        personDao.save(person);
        return "addPerson";
    }
    @ResponseBody
    @RequestMapping(value = "/addperson", method = RequestMethod.POST)
    public String savePerson(Model model, @RequestParam String login,
                           @RequestParam String email, @RequestParam String password) {

        Person person = new Person();
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);
        personDao.save(person);
        return person.toString();
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

    //@ResponseBody
    @RequestMapping("/persons")
    public String getList(Model model) {
        model.addAttribute("persons", personDao.getAll());
        return "personlist";
    }


}
