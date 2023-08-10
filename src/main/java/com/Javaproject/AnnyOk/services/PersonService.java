package com.Javaproject.AnnyOk.services;

import com.Javaproject.AnnyOk.dao.PersonDao;
import com.Javaproject.AnnyOk.repositories.Person;
import com.Javaproject.AnnyOk.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final PersonDao personDao;
    private final PersonRepository personRepository;
    private static final Logger logger = Logger.getLogger(PersonService.class.getName());
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao, PersonRepository personRepository){
        this.personDao = personDao;

        this.personRepository = personRepository;
    }
    public int addPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return savedPerson != null ? 1 : 0;
//        return personDao.insertPerson(person);

    }
    public List<Person> selectAllPerson() throws SQLException {
        return personRepository.findAll();
//        return personDao.selectAllPeople();
    }
    public Optional<Person> selectPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }
    public int updatePerson( UUID id,Person person){
//        logger.info(id,person);
        return personDao.updatePerson(id,person);
    }

}
