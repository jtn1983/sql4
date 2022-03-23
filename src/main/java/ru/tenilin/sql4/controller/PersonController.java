package ru.tenilin.sql4.controller;

import org.springframework.web.bind.annotation.*;
import ru.tenilin.sql4.entity.Person;
import ru.tenilin.sql4.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/by-city")
    @ResponseBody
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personService.getPersonByCity(city);
    }

    @GetMapping("/by-age")
    @ResponseBody
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return personService.getPersonByAge(age);
    }

    @GetMapping("/by-namesurname")
    @ResponseBody
    public List<Person> getPersonsByNameSurname(
            @RequestParam(required = false) Optional<String> name,
            @RequestParam(required = false) Optional<String> surname) {
        return personService.getPersonByNameSurname(name, surname);
    }
}
