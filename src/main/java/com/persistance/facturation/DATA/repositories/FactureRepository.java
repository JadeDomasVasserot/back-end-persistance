package com.persistance.facturation.DATA.repositories;

import com.persistance.facturation.DATA.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Integer> {
    @Query("SELECT f FROM Facture f where date(f.date) = ?1 order by f.date desc")
    List<Facture> findByDateOrderByDateDesc(Date date);

    List<com.persistance.facturation.DATA.models.Facture> findByUser_Id(Integer id);



}