package com.lefnds.jpatablerelationship.services;

import com.lefnds.jpatablerelationship.models.Adress;
import com.lefnds.jpatablerelationship.repositories.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdressService {

    @Autowired
    private AdressRepository repository;

    public Adress save(Adress entity) {
        return repository.save(entity);
    }

    public List<Adress> findAll() {
        return repository.findAll();
    }

    public Adress findById(UUID id) {
        return repository.findById(id).get();
    }

    public void delete(UUID id) {
        repository.delete(repository.findById(id).get());
    }

    public Adress update(UUID id, Adress entityUpdated) {
        Adress entityNonUpdated = repository.findById(id).get();
        updateData(entityNonUpdated, entityUpdated);
        return repository.save(entityNonUpdated);
    }

    private void updateData(Adress entity, Adress user) {
        entity.setCep(user.getCep());
        entity.setResidents(user.getResidents());
    }
}
