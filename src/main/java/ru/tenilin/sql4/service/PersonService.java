package ru.tenilin.sql4.service;

import org.springframework.stereotype.Service;
import ru.tenilin.sql4.entity.Person;
import ru.tenilin.sql4.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }

    public List<Person> getPersonByAge(int age) {
        return personRepository.findByNameSurnameAge_AgeLessThanOrderByNameSurnameAge_AgeAsc(age);
    }

    public List<Person> getPersonByNameSurname(Optional<String> name, Optional<String> surname) {
        return personRepository.findByNameSurname(name, surname);
    }
}
