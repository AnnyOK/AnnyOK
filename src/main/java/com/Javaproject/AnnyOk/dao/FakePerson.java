package com.Javaproject.AnnyOk.dao;

import com.Javaproject.AnnyOk.repositories.Person;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.*;

import org.slf4j.LoggerFactory;

@Repository("fakeDao")

public class FakePerson implements PersonDao{
    private List<Person> DB = new ArrayList<>();
    private static final Logger logger= LoggerFactory.getLogger(FakePerson.class);
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Object> selectAllPeople() {
        return Collections.singletonList(DB);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person->person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personvalue = selectPersonById(id);
        if(personvalue.isEmpty()){
            return 0;
        }
        DB.remove(personvalue.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
         return selectPersonById(id).map(p->{
            int indexToReplace = DB.indexOf(p);
            if(indexToReplace>=0){
                DB.set(indexToReplace,new Person(id,person.getName()));
                return 1;
            }
            return 0;
        })
        .orElse(0);
    }
}
