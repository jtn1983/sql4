package ru.tenilin.sql4.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.tenilin.sql4.entity.Person;
import ru.tenilin.sql4.service.PersonService;

import javax.annotation.security.RolesAllowed;
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
    @Secured("ROLE_READ")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personService.getPersonByCity(city);
    }

    @GetMapping("/by-age")
    @ResponseBody
    @RolesAllowed("ROLE_WRITE")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return personService.getPersonByAge(age);
    }

    @GetMapping("/by-namesurname")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public List<Person> getPersonsByNameSurname(
            @RequestParam(required = false) Optional<String> name,
            @RequestParam(required = false) Optional<String> surname) {
        return personService.getPersonByNameSurname(name, surname);
    }

    @GetMapping("/by-city-nameuser")
    @ResponseBody
    @PreAuthorize("#username == authentication.principal.username")
    public List<Person> getPersonsByCityWithUsername(@RequestParam String city, @RequestParam String username) {
        return personService.getPersonByCity(city);
    }
}
