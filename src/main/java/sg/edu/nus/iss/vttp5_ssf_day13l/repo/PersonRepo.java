package sg.edu.nus.iss.vttp5_ssf_day13l.repo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5_ssf_day13l.model.Person;

@Repository
public class PersonRepo {
    private List<Person> personList = new ArrayList<>();

    public PersonRepo() throws ParseException{
        String birthDate = "1988-12-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(birthDate);
        Person person1 = new Person("Daniel", "Loo", 12000, "danielloo@iss.edu.sg", birthday, "91456823", 689234);
        personList.add(person1);
    }



    public Person findById(String personId){
        Person person = personList.stream().filter(a -> a.getId().equals(personId)).findFirst().get();
        return person;
    }

    public List<Person> getPersonList(){
        return personList;
    }

    public Boolean createPerson(Person person){
        personList.add(person);
        return true;
    }

    public Boolean deletePerson(Person person){
        Integer index = personList.indexOf(person);
        if (index >= 0){
            personList.remove(person);
            return true;
        }
        return false;
    }


    public Boolean updatePerson(Person person){
        String personId = person.getId();
        Person oldPerson = personList.stream().filter(a -> a.getId().equals(personId)).findFirst().get();
        personList.remove(oldPerson);
        personList.add(person);
        return true;

    }
}
