package com.lefnds.jpatablerelationship.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lefnds.jpatablerelationship.models.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PERSON")
    private UUID id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "GENDER")
    private Gender gender;
    @OneToOne
    @JsonIgnore
    private Person spouse;
    @OneToMany
    @JsonIgnore
    private List<Phone> phone;
//    @ManyToMany
//    private List<Person> Parents;
}
