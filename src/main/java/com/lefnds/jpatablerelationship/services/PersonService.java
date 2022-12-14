package com.lefnds.jpatablerelationship.services;

import com.lefnds.jpatablerelationship.models.Person;
import com.lefnds.jpatablerelationship.repositories.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person save(Person entity) {
        return repository.save(entity);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(UUID id) {
        return repository.findById(id).get();
    }

    public void delete(UUID id) {
        repository.delete(repository.findById(id).get());
    }

    public Person update(UUID id, Person entityUpdated) {
        Person entityNonUpdated = repository.findById(id).get();
        updateData(entityNonUpdated, entityUpdated);
        return repository.save(entityNonUpdated);
    }

    private void updateData(Person entity, Person user) {
        entity.setName(user.getName());
        entity.setAge(user.getAge());
        entity.setGender(user.getGender());
        entity.setSpouse(user.getSpouse());
        entity.setPhone(user.getPhone());
        entity.setAdress(user.getAdress());
    }
}
