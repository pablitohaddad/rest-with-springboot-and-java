package io.github.pablitohaddad.restwithspringbootandjava.repositories;

import io.github.pablitohaddad.restwithspringbootandjava.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{}
