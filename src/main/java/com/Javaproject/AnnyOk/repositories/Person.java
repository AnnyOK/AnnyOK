package com.Javaproject.AnnyOk.repositories;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.UUID;

@ToString
public class Person {
    private final UUID id;
    private final String name;
    public Person(@JsonProperty("id") UUID id,@JsonProperty("name") String name){
        this.id =id;
        this.name= name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
