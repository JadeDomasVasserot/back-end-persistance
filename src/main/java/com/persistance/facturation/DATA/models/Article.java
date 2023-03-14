package com.persistance.facturation.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashSet;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 45)
    private String nom;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "prix", nullable = false, precision = 10)
    private BigDecimal prix;

    @OneToMany(mappedBy = "idArticle")
    private Collection<Contient> contients = new LinkedHashSet<>();

}