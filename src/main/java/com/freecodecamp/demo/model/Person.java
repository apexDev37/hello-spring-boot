package com.freecodecamp.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Person {

    // Person class represents a DB model

    // Class members
    private final UUID personId;

    @NotBlank
    private final String personName;

    // Class constructors

    public Person(
            @JsonProperty("id") UUID personId,
            @JsonProperty("name") String personName) {

        this.personId = personId;
        this.personName = personName;
    }

    public UUID getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }
}
