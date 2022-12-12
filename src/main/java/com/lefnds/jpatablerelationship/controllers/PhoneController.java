package com.lefnds.jpatablerelationship.controllers;

import com.lefnds.jpatablerelationship.models.Person;
import com.lefnds.jpatablerelationship.models.Phone;
import com.lefnds.jpatablerelationship.services.PersonService;
import com.lefnds.jpatablerelationship.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/phone")
public class PhoneController {

    @Autowired
    private PhoneService service;

    @PostMapping
    public ResponseEntity<Phone> insertTest(@RequestBody Phone entity) {
        service.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<Phone>> findAll() {
        List list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Phone> findById(@PathVariable UUID id) {
        Phone entity = service.findById(id);
        return ResponseEntity.ok().body(entity);
    }


    @PutMapping(value = ("/{id}"))
    public ResponseEntity<Phone> update(@PathVariable UUID id, @RequestBody Phone entity){
        entity = service.update(id, entity);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
