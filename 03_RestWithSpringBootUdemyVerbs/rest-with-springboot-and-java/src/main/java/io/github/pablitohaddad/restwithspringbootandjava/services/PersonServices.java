package io.github.pablitohaddad.restwithspringbootandjava.services;

import io.github.pablitohaddad.restwithspringbootandjava.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service // para spring boot encare ele com um objeto que vai ser injetato em Runtime
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person create(Person person){
        logger.info("Create one person!");
        return person;
    }

    public Person update(Person person){
        logger.info("Update one person!");
        return person;
    }
    public void delete(String id){
        logger.info("Deleting one person!");
    }

    public Person findById(String id){
        logger.info("Finding person by id: " + id);
        // vamos retornar um mock agora
        return new Person(13L,"Pablo", "Haddad", "Cáceres", "M");
    }
    public List<Person> findAll(){
        logger.info("Finding all people");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }
    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name" + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address " + i);
        person.setGender("Male");
        return person;
    }

}
