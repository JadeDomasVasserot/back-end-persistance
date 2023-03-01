package com.persistance.facturation.repositories;

import com.persistance.facturation.models.Contient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContientRepository extends JpaRepository<Contient, Long> {
}