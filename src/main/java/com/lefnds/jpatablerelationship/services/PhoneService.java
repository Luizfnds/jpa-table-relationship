package com.lefnds.jpatablerelationship.services;

import com.lefnds.jpatablerelationship.models.Phone;
import com.lefnds.jpatablerelationship.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository;

    public Phone insert(Phone entity) {
        return repository.save(entity);
    }

    public List<Phone> findAll() {
        return repository.findAll();
    }

    public Phone findById(UUID id) {
        return repository.findById(id).get();
    }

    public void delete(UUID id) {
        repository.delete(repository.findById(id).get());
    }

    public Phone update(UUID id, Phone entityUpdated) {
        Phone entityNonUpdated = repository.findById(id).get();
        updateData(entityNonUpdated, entityUpdated);
        return repository.save(entityNonUpdated);
    }

    private void updateData(Phone entity, Phone user) {
        entity.setNumber(user.getNumber());
        entity.setHolder(user.getHolder());
    }
}
