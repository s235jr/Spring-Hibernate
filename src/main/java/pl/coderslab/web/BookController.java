package pl.coderslab.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.entity.ValidateBook;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
public class BookController {

    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final PublisherDao publisherDao;

    @Autowired
    Validator validator;

    public BookController(BookDao bookDao, AuthorDao authorDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.publisherDao = publisherDao;
    }

    @ModelAttribute("publisher")
    public List<Publisher> getPublisher() {
        return publisherDao.getAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthors() {
        return authorDao.getAll();
    }

    @RequestMapping("/books")
    public String getList(Model model) {
        model.addAttribute("books", bookDao.getAll());
        return "bookList";
    }

    @RequestMapping("/addbook")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "bookForm";
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String saveBook(@Valid Book book, BindingResult result) {
        System.out.println(book);
        if (result.hasErrors()) {
            return "bookForm";
        }
        bookDao.save(book);
        return "redirect:/books";
    }

    @ResponseBody
    @RequestMapping("/getbook{param}")
    public String getBook(@PathVariable long param) {
        Book book = bookDao.findByIdWithAuthors(param);
        return book.toString();
    }

    @RequestMapping("/delbook{param}")
    public String delBook(@PathVariable long param, Model model) {
        model.addAttribute("id", param);
        return "/sureDelBook";
    }

    @RequestMapping(value = "/sureDelBook", method = RequestMethod.POST)
    public String delBookAfterAccept(@RequestParam long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "redirect:/books";
    }

    @RequestMapping("/editbook{param}")
    public String editBook(@PathVariable long param, Model model) {
        Book book = bookDao.findById(param);
        model.addAttribute("book", book);
        return "bookForm";
    }

    @RequestMapping(value = "/editbook{param}", method = RequestMethod.POST)
    public String editBook(@PathVariable long param, @ModelAttribute Book book) {
        book.setId(param);
        System.out.println(book.toString());
        bookDao.update(book);
        return "redirect:/books";
    }

    @RequestMapping("/rating{param}")
    @ResponseBody
    public String getRatingList(@PathVariable int param) {
        List<Book> ratingList = bookDao.getRatingList(param);
        return ratingList.toString();
    }
}
