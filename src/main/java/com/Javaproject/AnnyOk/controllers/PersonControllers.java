package com.Javaproject.AnnyOk.controllers;

import com.Javaproject.AnnyOk.repositories.Person;
import com.Javaproject.AnnyOk.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/person")
public class PersonControllers {
    private final PersonService personService;
    private static final Logger logger = Logger.getLogger(PersonControllers.class.getName());
@Autowired
    public PersonControllers(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody() Person person)throws Exception{

         personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPerson()throws Exception{
    return personService.selectAllPerson();
    }
    @GetMapping("{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id){
    return personService.selectPersonById(id);
    }
    @DeleteMapping("{id}")
    public int deletePerson(@PathVariable("id") UUID id) throws Exception{
    return personService.deletePerson(id);
    }
    @PutMapping("{id}")
    public int updatePerson(@PathVariable("id") UUID id, @RequestBody Person person) throws Exception{
logger.info("id="+person.getName());
        return personService.updatePerson(id,person);

    }
}
