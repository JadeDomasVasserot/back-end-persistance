package com.persistance.facturation.data.repositories;

import com.persistance.facturation.data.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Integer> {

    @Query("SELECT f FROM Facture f where f.user = ?1 ")
    List<Facture> findFacByUser(int userId);

}