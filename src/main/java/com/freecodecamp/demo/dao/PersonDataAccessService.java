package com.freecodecamp.demo.dao;
import com.freecodecamp.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
    @Override
    public int insertPerson(UUID personId, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectPersonEntities() {
        return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
    }

    @Override
    public Optional<Person> selectPersonById(UUID personId) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID personId) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID personId, Person updatedPerson) {
        return 0;
    }
}
