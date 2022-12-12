package com.lefnds.jpatablerelationship.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PHONE")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PHONE")
    private UUID id;
    @Column(name = "number")
    private String number;
    @ManyToOne
    @JoinColumn
    private Person holder;
}
