package com.bismark.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bismark.models.Person;

public interface PersonDao {


    int insertPerson(UUID id,Person person);

    default int addPerson(Person person){
        UUID uuid = UUID.randomUUID();
        return insertPerson(uuid,person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);
    
    int updatePersonById(UUID id,Person person);
}
