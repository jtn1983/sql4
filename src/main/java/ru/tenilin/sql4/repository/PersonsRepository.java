package ru.tenilin.sql4.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tenilin.sql4.entity.Persons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonsRepository {

    @Autowired
    PersonRepository personRepository;

    public List<Persons> getPersonByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }

    public List<Persons> getPersonByAge(int age) {
        return personRepository.findByNameSurnameAge_AgeLessThanOrderByNameSurnameAge_AgeAsc(age);
    }

    public List<Persons> getPersonByNameSurname(Optional<String> name, Optional<String> surname) {
        return personRepository.findByNameSurname(name, surname);
    }


}
