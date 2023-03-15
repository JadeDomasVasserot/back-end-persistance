package com.persistance.facturation.data.repositories;

import com.persistance.facturation.data.models.Contient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContientRepository extends JpaRepository<Contient, Long> {
    List<Contient> findByIdFacture_Id(Integer id);
}