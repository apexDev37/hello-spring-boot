package com.freecodecamp.demo.service;
import com.freecodecamp.demo.dao.PersonDao;
import com.freecodecamp.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    // Service layer that handles our applications business logic
    // Reference the PersonDao interface in the Database layer
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    // Service operation to add a person
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    // Service operation to retrieve all person entities
    public List<Person> retrievePersons() {
        return personDao.selectPersonEntities();
    }

    // Service operation to retrieve all person entities
    public Optional<Person> retrievePersonById(UUID personId) {
        return personDao.selectPersonById(personId);
    }

    public int deletePerson(UUID personId) {
        return personDao.deletePersonById(personId);
    }

    public int updatePerson(UUID personId, Person updatedPerson) {
        return personDao.updatePersonById(personId, updatedPerson);
    }

}
