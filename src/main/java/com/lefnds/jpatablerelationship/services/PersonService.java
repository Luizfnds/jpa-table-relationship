package com.lefnds.jpatablerelationship.services;

import com.lefnds.jpatablerelationship.models.Person;
import com.lefnds.jpatablerelationship.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person insert(Person entity) {
        return repository.save(entity);
    }


}
