package com.lefnds.jpatablerelationship.controllers;

import com.lefnds.jpatablerelationship.models.Person;
import com.lefnds.jpatablerelationship.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<Person> insertTest(@RequestBody Person entity) {
        service.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> findById(@PathVariable UUID id) {
        Person entity = service.findById(id);
        return ResponseEntity.ok().body(entity);
    }


    @PutMapping(value = ("/{id}"))
    public ResponseEntity<Person> update(@PathVariable UUID id, @RequestBody Person entity){
        entity = service.update(id, entity);
        return ResponseEntity.ok().body(entity);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
