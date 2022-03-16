package ru.tenilin.sql4.controller;

import org.springframework.web.bind.annotation.*;
import ru.tenilin.sql4.entity.Persons;
import ru.tenilin.sql4.repository.PersonsRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private PersonsRepository personsRepository;

    public PersonController(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @GetMapping("/by-city")
    @ResponseBody
    public List<Persons> getPersonsByCity(@RequestParam String city) {
        return personsRepository.getPersonByCity(city);
    }
}
