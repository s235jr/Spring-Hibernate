package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.ValidateBook;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidatorController {

    @Autowired
    Validator validator;

    @RequestMapping("/validate")
    public String validateBook(Model model){
        ValidateBook validateBook = new ValidateBook();
        validateBook.setTitle("Lato w miescie");
        //validateBook.setAuthors("Czeslaw");
        //validateBook.setPublisher("PWN");
        //validateBook.setRating(5);

        Set<ConstraintViolation<ValidateBook>> validate = validator.validate(validateBook);
//        for (ConstraintViolation<ValidateBook> validateBookConstraintViolation : validate) {
//            result += validateBookConstraintViolation.getPropertyPath() + " : "
//                    + validateBookConstraintViolation.getMessage() + "\n";
//        }
        model.addAttribute("valid", validate);
        return "validbook";
    }
}
