package com.lefnds.jpatablerelationship.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "TB_ADRESS")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ADRESS")
    private UUID id;
    @Column(name = "CEP")
    private String cep;
    @ManyToMany(mappedBy = "adress", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Person> residents = new ArrayList<>();
}
