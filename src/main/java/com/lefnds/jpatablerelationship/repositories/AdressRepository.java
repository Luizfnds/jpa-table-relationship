package com.lefnds.jpatablerelationship.repositories;

import com.lefnds.jpatablerelationship.models.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdressRepository extends JpaRepository<Adress, UUID> {
}
