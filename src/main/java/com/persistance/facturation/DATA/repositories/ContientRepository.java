package com.persistance.facturation.data.repositories;

import com.persistance.facturation.data.models.Contient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContientRepository extends JpaRepository<Contient, Long> {
}