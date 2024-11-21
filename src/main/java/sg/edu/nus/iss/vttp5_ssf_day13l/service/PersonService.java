package sg.edu.nus.iss.vttp5_ssf_day13l.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5_ssf_day13l.repo.PersonRepo;
import sg.edu.nus.iss.vttp5_ssf_day13l.model.Person;

@Service
public class PersonService {
    

    @Autowired
    PersonRepo personrepo;

    public List<Person> getPersonList(){
        return personrepo.getPersonList();
    }

    public Boolean createPerson(Person person){
        return personrepo.createPerson(person);
    }

    public Boolean deletePerson(Person person){
        return personrepo.deletePerson(person);
    }

    public Boolean updatePerson(Person person) {
        return personrepo.updatePerson(person);
    }
    
    public Person findById(String personId) {
        return personrepo.findById(personId);
    }

}
