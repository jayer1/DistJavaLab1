package hibernate.controller;

import hibernate.entity.Dogs;
import hibernate.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dogs")
public class DogsController {

    @Autowired
    private DogService dogService;

    @RequestMapping("/list")
    public String listDogs(Model theModel) {
        List<Dogs> dogsList = dogService.listAllDogs();
        theModel.addAttribute("dogs", dogsList);
        return "list-dogs";
    }

    @PostMapping("/save")
    public String saveDogs(@ModelAttribute("dogs") Dogs myDog) {
        dogService.createDog(myDog);
        return "redirect:/dogs/list";
    }


}
