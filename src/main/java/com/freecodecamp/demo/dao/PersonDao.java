package com.freecodecamp.demo.dao;
import com.freecodecamp.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    // Manually generate a user person ID
    int insertPerson(UUID personId, Person person);

    // Auto generate a user person ID
    default int insertPerson(Person person) {
        UUID generatedId = UUID.randomUUID();
        return insertPerson(generatedId, person);
    }

    // Return a list of Person entities
    List<Person> selectPersonEntities();

    // Return a single Person entity
    Optional<Person> selectPersonById(UUID personId);

    // Delete a Person entity from the DB
    int deletePersonById(UUID personId);

    // Update a Person entity from the DB
    int updatePersonById(UUID personId, Person updatedPerson);
}
