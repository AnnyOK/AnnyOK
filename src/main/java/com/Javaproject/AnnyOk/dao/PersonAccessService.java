package com.Javaproject.AnnyOk.dao;

import com.Javaproject.AnnyOk.repositories.Person;
import com.Javaproject.AnnyOk.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Repository("postgres")
public class PersonAccessService implements  PersonDao{
//    @Autowired
    private final JdbcTemplate jdbcTemplate;
//    private static final Logger logger = Logger.getLogger(PersonAcccessService.class.getName());

    public PersonAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate= jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
//logger.info(person,id);
        return 0;
    }

    @Override
    public int insertPerson(Person person) {
        return PersonDao.super.insertPerson(person);
    }

    @Override
    public List<Object> selectAllPeople() {
        final String sql = "SELECT id,name FROM person;";
        try {
            return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String name = resultSet.getString("name");
                return new Person(id, name);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return 0;
    }

}
