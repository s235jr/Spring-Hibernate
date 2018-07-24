package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.PersonDTO;

@Controller
public class PersonDetailController {

    @RequestMapping("/personDTO")
    public String showRegistrationForm(Model model) {
        PersonDTO personDTO = new PersonDTO();
        model.addAttribute("personDTO", personDTO);
        return "personDetailsForm";
    }

    @ResponseBody
    @RequestMapping(value = "/personDTO", method = RequestMethod.POST)
    public String showRegistrationForm(@ModelAttribute PersonDTO personDTO) {
        return personDTO.toString();
    }


    @ModelAttribute("genders")
    public String[] genders() {
        String[] genders = {"M", "F"};
        return genders;
    }

    @ModelAttribute("countries")
    public String[] countries() {
        String[] countries = {"Polska", "Niemcy", "Rosja"};
        return countries;
    }

    @ModelAttribute("hobbies")
    public String[] hobbies() {
        String[] hobby = {"Ksiazka", "Film", "Sport"};
        return hobby;
    }

    @ModelAttribute("programmingSkills")
    public String[] programmingSkills() {
        String[] programmingSkills = {"Java", "JS", "C", "C++", "Python"};
        return programmingSkills;
    }

}
