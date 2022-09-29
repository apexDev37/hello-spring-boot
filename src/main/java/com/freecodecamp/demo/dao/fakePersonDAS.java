package com.freecodecamp.demo.dao;
import com.freecodecamp.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class fakePersonDAS implements PersonDao {

    // Database that stores a list of persons
    private static List<Person> personDB = new ArrayList<>();

    @Override
    public int insertPerson(UUID personId, Person person) {
        personDB.add(new Person(personId, person.getPersonName()));
        return 1;
    }

    @Override
    public List<Person> selectPersonEntities() {
        return personDB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID personId) {
        return personDB.stream()
                        .filter(person -> person.getPersonId().equals(personId))
                        .findFirst();
    }

    @Override
    public int deletePersonById(UUID personId) {
        Optional<Person> person = selectPersonById(personId);
        if (person.isPresent()) {
            personDB.remove(person.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonById(UUID personId, Person updatedPerson) {
        return selectPersonById(personId)
                .map(person -> {
                    int indexOfOldPerson = personDB.indexOf(person);
                    if (indexOfOldPerson >= 0) {
                        personDB.set(indexOfOldPerson, new Person(personId, updatedPerson.getPersonName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
