package com.freecodecamp.demo.api;
import com.freecodecamp.demo.model.Person;
import com.freecodecamp.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    // Reference the PersonService in the Service layer
    private final PersonService personService;

    @Autowired
    // Constructor for personService
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> retrievePersons() {
        return personService.retrievePersons();
    }

    @GetMapping(path = "{id}")
    public Person retrievePersonById(@PathVariable("id") UUID personId) {
        return personService.retrievePersonById(personId)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID personId) {
        personService.deletePerson(personId);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID personId,
                             @Valid @NotNull @RequestBody Person updatedPerson) {
        personService.updatePerson(personId, updatedPerson);
    }
}
