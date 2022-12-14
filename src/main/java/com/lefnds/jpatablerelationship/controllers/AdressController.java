package com.lefnds.jpatablerelationship.controllers;

import com.lefnds.jpatablerelationship.models.Adress;
import com.lefnds.jpatablerelationship.services.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/adress")
public class AdressController {

    @Autowired
    private AdressService service;

    @PostMapping
    public ResponseEntity<Adress> insertTest(@RequestBody Adress entity) {
        service.save(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @GetMapping
    public ResponseEntity<List<Adress>> findAll() {
        List list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Adress> findById(@PathVariable UUID id) {
        Adress entity = service.findById(id);
        return ResponseEntity.ok().body(entity);
    }

    @PutMapping(value = ("/{id}"))
    public ResponseEntity<Adress> update(@PathVariable UUID id, @RequestBody Adress entity){
        entity = service.update(id, entity);
        return ResponseEntity.ok().body(entity);
    }

    @PutMapping(value = ("/{idPerson}/spouse/{idSpouse}"))
    public ResponseEntity<Adress> updateWithSpouse(@PathVariable(value = "idPerson") UUID idPerson,
                                                   @PathVariable(value = "idSpouse") UUID idSpouse,
                                                   @RequestBody Adress adress){

        adress = service.update(idPerson, adress);
        return ResponseEntity.ok().body(adress);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
