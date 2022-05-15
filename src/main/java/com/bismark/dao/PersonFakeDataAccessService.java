package com.bismark.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bismark.models.Person;

import org.springframework.stereotype.Repository;

@Repository("mongodb")
public class PersonFakeDataAccessService implements PersonDao{

   private static List<Person> DB = new ArrayList<>();
    
    @Override
    public int insertPerson(UUID id, Person person) {
        // TODO Auto-generated method stub
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> maybePerson = selectPersonById(id);
        if(maybePerson.isEmpty()){
            return 0;
        }else{
            DB.remove(maybePerson.get());
           return 1;
        }
    }

    @Override
    public int updatePersonById(UUID id,Person person) {
        return selectPersonById(id).map(p->{
            int indexOf = DB.indexOf(p);
            if(indexOf >= 0){
                DB.set(indexOf, new Person(id,person.getName()));
                return 1;
            }

            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().
        filter(person->{
          return person.getID().equals(id);
        }).findFirst();
    }
    
}
