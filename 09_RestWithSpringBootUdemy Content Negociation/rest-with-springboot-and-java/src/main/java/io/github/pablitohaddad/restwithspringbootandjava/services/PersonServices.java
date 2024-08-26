package io.github.pablitohaddad.restwithspringbootandjava.services;

import io.github.pablitohaddad.restwithspringbootandjava.data.vo.v1.PersonVO;
import io.github.pablitohaddad.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import io.github.pablitohaddad.restwithspringbootandjava.mapper.Mapper;
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

    public PersonVO create(PersonVO person){
        logger.info("Create one person!");
        var entity = Mapper.parseObject(person, Person.class);
        var vo = Mapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person){
        logger.info("Update one person!");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = Mapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }
    public void delete(Long id){
        logger.info("Deleting one person!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        repository.delete(entity);
    }

    public PersonVO findById(Long id){
        logger.info("Finding person by id: " + id);
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        return Mapper.parseObject(entity, PersonVO.class);
    }
    public List<PersonVO> findAll(){
        logger.info("Finding all people");
        return Mapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

}
