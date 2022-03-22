package ru.tenilin.sql4.controller;

import org.springframework.web.bind.annotation.*;
import ru.tenilin.sql4.entity.Persons;
import ru.tenilin.sql4.repository.PersonsRepository;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/by-age")
    @ResponseBody
    public List<Persons> getPersonsByAge(@RequestParam int age) {
        return personsRepository.getPersonByAge(age);
    }

    @GetMapping("/by-namesurname")
    @ResponseBody
    public List<Persons> getPersonsByNameSurname(
            @RequestParam(required = false) Optional<String> name,
            @RequestParam(required = false) Optional<String> surname) {
        return personsRepository.getPersonByNameSurname(name, surname);
    }
}
