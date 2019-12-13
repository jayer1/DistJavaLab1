package hibernate.controller;

import hibernate.entity.Dogs;
import hibernate.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    @RequestMapping("/user/showAddDogForm")
    public String showAddDonutForm(Model theModel) {
        Dogs theDog = new Dogs();

        theModel.addAttribute("dog", theDog);

        theModel.addAttribute("breeds", dogService.listAllBreeds());
        theModel.addAttribute("genders", dogService.listAllGenders());
        theModel.addAttribute("declaweds",dogService.listAllDeclawed());

        //theModel.addAttribute("donutShops", donutShopService.getDonutShops());

        return "dog-form";
    }

    @PostMapping("/save")
    public String saveDogs(@RequestParam("image") MultipartFile file, @Valid @ModelAttribute("dog") Dogs myDog,
                           BindingResult bindingResult,
                           HttpServletRequest request,
                           Model theModel) {
        // Any validation errors?
        if (bindingResult.hasErrors()) {
            // Display the errors in the console
            System.out.println(bindingResult);

            // Put list of donut shops back in the new model
            theModel.addAttribute("genders", dogService.listAllGenders());
            theModel.addAttribute("breeds", dogService.listAllBreeds());
            theModel.addAttribute("declaweds", dogService.listAllDeclawed());

            // Send back to form with error messages
            return "dog-form";
        }

        // Find the complete path of the application
        String applicationPath = request.getServletContext().getRealPath("/");

        // Use the service to save the donut
        dogService.createDog(myDog, file, applicationPath);

        // Redirect back to the donut list
        return "redirect:/dogs/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm, Model theModel) {
        List<Dogs> matchingDogs = dogService.getDogsByName(theSearchTerm);

        theModel.addAttribute("dogs", matchingDogs);

        return "list-dogs";
    }

    @GetMapping("/admin/delete")
    public String deleteDog(@RequestParam("dogId") int theId) {
        dogService.deleteDog(theId);
        return "redirect:/dogs/list";
    }

    @RequestMapping("/admin/showUpdateDogForm")
    public String showUpdateDogForm(@RequestParam("dogId") int theId, Model theModel) {

        Dogs theDog = dogService.getDog(theId);
        theModel.addAttribute("dog", theDog);

        theModel.addAttribute("breeds", dogService.listAllBreeds());
        theModel.addAttribute("genders", dogService.listAllGenders());
        theModel.addAttribute("declaweds", dogService.listAllDeclawed());

        return "dog-form";
    }

    @RequestMapping("/showDogDetail")
    public String showDogDetail(@RequestParam("dogId") int theId, Model theModel) {

        Dogs theDog = dogService.getDog(theId);
        theModel.addAttribute("dog", theDog);

        theModel.addAttribute("breeds", dogService.listAllBreeds());
        theModel.addAttribute("genders", dogService.listAllGenders());
        theModel.addAttribute("declaweds", dogService.listAllDeclawed());

        return "dog-detail-form";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // Trim whitespace from all string form parameters read by this controller
        // If the entire string is whitespace, trim it to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e) {
        e.printStackTrace();
    }


}
