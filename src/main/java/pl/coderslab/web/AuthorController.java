package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import java.util.List;

@Controller
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/authors")
    public String showAuthors(Model model) {
        List<Author> authors = authorDao.getAll();
        model.addAttribute("authors", authors);
        return "authorList";
    }

    @RequestMapping("/addauthor")
    public String addAuthor(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "authorForm";
    }

    @RequestMapping(value = "/addauthor", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute Author author) {
        authorDao.save(author);
        return "redirect:/authors";
    }

    @ResponseBody
    @RequestMapping("/getauthor{param}")
    public String getAuthor(@PathVariable long param) {
        Author author = authorDao.findById(param);
        return author.toString();
    }

    @RequestMapping("/editauthor{param}")
    public String editAuthor(@PathVariable long param, Model model) {
        Author author = authorDao.findById(param);
        model.addAttribute("author", author);
        return "authorForm";
    }

    @RequestMapping(value = "/editauthor{param}", method = RequestMethod.POST)
    public String editAuthor(@PathVariable long param, @ModelAttribute Author author){
        author.setId(param);
        authorDao.update(author);
        return "redirect:/authors";
    }

    @RequestMapping("/delauthor{param}")
    public String delAuthor(@PathVariable long param, Model model) {
        model.addAttribute("id", param);
        return "/sureDelAuthor";
    }

    @RequestMapping(value = "/sureDelAuthor", method = RequestMethod.POST)
    public String delAuthorAfterAccept(@RequestParam long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect:/authors";
    }

}
