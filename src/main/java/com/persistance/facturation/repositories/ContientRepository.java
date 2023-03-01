package com.persistance.facturation.repositories;

import com.persistance.facturation.model.Contient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContientRepository extends JpaRepository<Contient, Long> {
}