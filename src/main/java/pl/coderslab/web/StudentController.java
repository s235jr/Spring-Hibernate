package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Student;

@Controller
public class StudentController {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processSimple(@RequestParam String firstName,
                                @RequestParam String lastName, Model model) {
        Student student = new Student(firstName, lastName);
        model.addAttribute("student", student);
        return "student";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Student student = new Student("Jan","Kowalski");
        model.addAttribute("student", student);
        return "form"; }
}
