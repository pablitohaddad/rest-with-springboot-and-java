package io.github.pablitohaddad.restwithspringbootandjava.mapper.custom;

import io.github.pablitohaddad.restwithspringbootandjava.data.vo.v2.PersonVOV2;
import io.github.pablitohaddad.restwithspringbootandjava.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setBirthDate(new Date());
        vo.setGender(person.getGender());
        vo.setAddress(person.getAddress());
        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 entity){
        Person vo = new Person();
        vo.setId(entity.getId());
        vo.setFirstName(entity.getFirstName());
        vo.setLastName(entity.getLastName());
        vo.setGender(entity.getGender());
        vo.setAddress(entity.getAddress());
        return vo;
    }


}
