package com.bismark.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bismark.dao.PersonDao;
import com.bismark.models.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao){
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        UUID id = UUID.randomUUID();
        return personDao.insertPerson(id,person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person person){
        return personDao.updatePersonById(id, person);
    }
}
