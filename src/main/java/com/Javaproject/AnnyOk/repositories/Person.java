package com.Javaproject.AnnyOk.repositories;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
