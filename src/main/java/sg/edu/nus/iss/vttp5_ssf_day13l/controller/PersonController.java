package sg.edu.nus.iss.vttp5_ssf_day13l.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.vttp5_ssf_day13l.service.PersonService;
import sg.edu.nus.iss.vttp5_ssf_day13l.model.*;;

@Controller
@RequestMapping(path = "")
public class PersonController {

    @Autowired
    PersonService personservice;

    @GetMapping("")
    public String personList(Model model){
        List<Person> personList = personservice.getPersonList();
        model.addAttribute("personList", personList);
        return "personlist";
    }

    @GetMapping("/create")
    public String createPerson(Model model){
        Person person = new Person();
        model.addAttribute("person", person); //need to add and empty object here for model attribute to work
        return "personcreate";
    }

    @PostMapping("/create")
    public String createPersonFilled(@Valid @ModelAttribute Person person, BindingResult binding, Model model){
        
        if (binding.hasErrors()){
            return "personcreate";
        }

        //below is needed as our current person does not have ID and wen need the constructors help with that
        Person p = new Person(person.getFirstName(),person.getLastName(),person.getSalary(),person.getEmail(),person.getDateOfBirth(),person.getTelephone(),person.getPostalcode());
        personservice.createPerson(p);
        return "redirect:/"; //not returning html file name. it is redirecting to URL "/person"
    }

    @GetMapping("/delete/{person-id}")
    public String deletePerson(@PathVariable("person-id") String personId, Model model){
        
        Person person = personservice.findById(personId);
        personservice.deletePerson(person);

        return "redirect:/";
    }
    
    @GetMapping("/update/{person-id}")
    public String updatePerson(@PathVariable("person-id") String personId, Model model){
        Person person = personservice.findById(personId);
        model.addAttribute("person", person); //need to add and empty object here for model attribute to work
        return "personupdate";
    }

    @PostMapping("/update")
    public String updatePersonFilled(@Valid @ModelAttribute Person person, BindingResult binding, Model model ){
        if (binding.hasErrors())
            return "personupdate";

        personservice.updatePerson(person);
        return "redirect:/";
    }

}
