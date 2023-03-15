package com.persistance.facturation.DATA.repositories;

import com.persistance.facturation.DATA.models.Contient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContientRepository extends JpaRepository<Contient, Long> {
    List<Contient> findByIdFacture_Id(Integer id);
}