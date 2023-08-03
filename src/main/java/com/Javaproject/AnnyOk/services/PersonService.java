package com.Javaproject.AnnyOk.services;

import com.Javaproject.AnnyOk.dao.PersonDao;
import com.Javaproject.AnnyOk.repositories.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final PersonDao personDao;
    private static final Logger logger = Logger.getLogger(PersonService.class.getName());
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao){
        this.personDao = personDao;

    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);

    }
    public List<Person>  selectAllPerson(){
        return personDao.selecetAllPeople();
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
