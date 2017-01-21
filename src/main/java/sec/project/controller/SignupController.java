package sec.project.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address,@RequestParam String phone, Model model) {
        signupRepository.save(new Signup(name, address, phone));
        model.addAttribute("participants", signupRepository.findAll());
        return "done";
    }
    
    @RequestMapping(value = "/participant", method = RequestMethod.GET)
    public String searchParticipant() {
        return "participant";
    }
    
    @RequestMapping(value = "/searchform", method = RequestMethod.POST)
    public String searchForm(@RequestParam String name, Model model) {
        //System.out.println("eikös tänne päästäkään--------------------------??");
        //System.out.println("name: " +name);
        //List<Signup> findByName = signupRepository.findByName(name);
        //System.out.println(findByName.size());
        List<Signup> all = signupRepository.findAll();
        List<Signup> found = new ArrayList<Signup>();
        for (Signup one: all) {
            if (one.getName().equals(name)) {
                found.add(one);
                
            }
            
        }
        model.addAttribute("participants", found);
        //model.addAttribute("participants", findByName);
        return "participant";
    }
}
