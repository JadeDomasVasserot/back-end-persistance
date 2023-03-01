package com.persistance.facturation.repositories;

import com.persistance.facturation.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Integer> {
}