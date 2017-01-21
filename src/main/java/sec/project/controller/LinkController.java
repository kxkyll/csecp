package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Link;
import sec.project.repository.LinkRepository;

@Controller
public class LinkController {

    @Autowired
    private LinkRepository linkRepository;

    
    @RequestMapping(value = "/link", method = RequestMethod.GET)
    public String loadForm(Model model) {
        model.addAttribute("links", linkRepository.findAll());
        return "link";
    }

    @RequestMapping(value = "/linkform", method = RequestMethod.POST)
    public String submitForm(@RequestParam String title, @RequestParam String url, Model model) {
        
        linkRepository.save(new Link(title, url));
       
        model.addAttribute("links", linkRepository.findAll());
        return "link";
    }
    
    @RequestMapping(value = "/links", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("links", linkRepository.findAll());
      
        return "link";
    }

}
