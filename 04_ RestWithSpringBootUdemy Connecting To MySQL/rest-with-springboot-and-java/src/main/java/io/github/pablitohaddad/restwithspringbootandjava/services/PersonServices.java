package io.github.pablitohaddad.restwithspringbootandjava.services;

import io.github.pablitohaddad.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import io.github.pablitohaddad.restwithspringbootandjava.model.Person;
import io.github.pablitohaddad.restwithspringbootandjava.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service // para spring boot encare ele com um objeto que vai ser injetato em Runtime
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person create(Person person){
        logger.info("Create one person!");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Update one person!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }
    public void delete(Long id){
        logger.info("Deleting one person!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        repository.delete(entity);
    }

    public Person findById(Long id){
        logger.info("Finding person by id: " + id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
    }
    public List<Person> findAll(){
        logger.info("Finding all people");
        return repository.findAll();
    }

}
