package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Controller
public class PublisherController {

    public final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }


    @RequestMapping("/publishers")
    public String showPublishers(Model model) {
        List<Publisher> publishers = publisherDao.getAll();
        model.addAttribute("publishers", publishers);
        return "publisherList";
    }


    @RequestMapping("/addpublisher")
    public String addPublisher(Model model) {
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);
        return "publisherForm";
    }

    @RequestMapping(value = "/addpublisher", method = RequestMethod.POST)
    public String addPublisher(@ModelAttribute Publisher publisher) {
        publisherDao.save(publisher);
        return "redirect:/publishers";
    }

    @ResponseBody
    @RequestMapping("/getpublisher{param}")
    public String getBook(@PathVariable long param) {
        Publisher publisher = publisherDao.findById(param);
        return publisher.toString();
    }

    @RequestMapping("/delpublisher{param}")
    public String delBook(@PathVariable long param, Model model) {
        model.addAttribute("id", param);
        return "/sureDelPublisher";
    }

    @RequestMapping(value = "/sureDelPublisher", method = RequestMethod.POST)
    public String delPublisherAfterAccepted(@RequestParam long id) {
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "redirect:/publishers";
    }

    @RequestMapping("/editpublisher{param}")
    public String editBook(@PathVariable long param, Model model) {
        Publisher publisher = publisherDao.findById(param);
        model.addAttribute("publisher", publisher);
        return "publisherForm";
    }

    @RequestMapping(value = "/editpublisher{param}", method = RequestMethod.POST)
    public String editBook(@PathVariable long param, @ModelAttribute Publisher publisher) {
        publisher.setId(param);
        publisherDao.update(publisher);
        return "redirect:/publishers";
    }
}
