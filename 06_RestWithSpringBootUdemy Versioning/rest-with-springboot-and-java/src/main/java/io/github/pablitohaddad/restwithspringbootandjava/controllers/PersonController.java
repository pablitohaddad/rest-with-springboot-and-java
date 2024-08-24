package io.github.pablitohaddad.restwithspringbootandjava.controllers;

import io.github.pablitohaddad.restwithspringbootandjava.data.vo.v1.PersonVO;
import io.github.pablitohaddad.restwithspringbootandjava.data.vo.v2.PersonVOV2;
import io.github.pablitohaddad.restwithspringbootandjava.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// Combination of ResponseBody and Controller;
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(@RequestBody PersonVO person){
        return services.create(person);
    }

    @PostMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person){
        return services.createV2(person);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@RequestBody PersonVO person){
        return services.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception{ // recupera dados da URL
        services.delete(id);
        return ResponseEntity.noContent().build(); // 204 No content
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable("id") Long id) throws Exception{
        return services.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll(){
        return services.findAll();
    }
}
