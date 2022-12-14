package com.lefnds.jpatablerelationship.controllers;

import com.lefnds.jpatablerelationship.models.Adress;
import com.lefnds.jpatablerelationship.models.Person;
import com.lefnds.jpatablerelationship.models.Phone;
import com.lefnds.jpatablerelationship.repositories.PersonRepository;
import com.lefnds.jpatablerelationship.services.AdressService;
import com.lefnds.jpatablerelationship.services.PersonService;
import com.lefnds.jpatablerelationship.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AdressService adressService;
    @Autowired
    private PhoneService phoneService;


    @PostMapping
    public ResponseEntity<Person> insertTest(@RequestBody Person entity) {
        service.save(entity);
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

    @PutMapping(value = ("/{idPerson}/spouse/{idSpouse}"))
    public ResponseEntity<Person> updateSpouse(@PathVariable(value = "idPerson") UUID idPerson,
                                         @PathVariable(value = "idSpouse") UUID idSpouse) {
        Person person = service.findById(idPerson);
        Person spouse = service.findById(idSpouse);
        person.setSpouse(spouse);
        spouse.setSpouse(person);
        service.save(person);
        service.save(spouse);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @PutMapping(value = ("/{idPerson}/resident/{idAdress}"))
    public ResponseEntity<Person> updateAdress(@PathVariable(value = "idPerson") UUID idPerson,
                                               @PathVariable(value = "idAdress") UUID idAdress) {
        Person person = service.findById(idPerson);
        Adress adress = adressService.findById(idAdress);
        person.getAdress().add(adress);
        adress.getResidents().add(person);
        service.save(person);
        adressService.save(adress);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @PutMapping(value = ("/{idPerson}/phone/{idPhone}"))
    public ResponseEntity<Person> updatePhone(@PathVariable(value = "idPerson") UUID idPerson,
                                               @PathVariable(value = "idPhone") UUID idPhone) {
        Person person = service.findById(idPerson);
        Phone phone = phoneService.findById(idPhone);
        person.getPhone().add(phone);
        phone.setHolder(person);
        service.save(person);
        phoneService.save(phone);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
