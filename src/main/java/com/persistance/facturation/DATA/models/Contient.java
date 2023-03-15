package com.persistance.facturation.data.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contient")

public class Contient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "INT")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_facture", referencedColumnName = "id",nullable = false)
    private com.persistance.facturation.data.models.Facture idFacture;

    @ManyToOne
    @JoinColumn(name = "id_article",referencedColumnName = "id",  nullable = false)
    private com.persistance.facturation.data.models.Article idArticle;

    @Basic
    @Column(name = "quantite", nullable = false)
    private Integer quantite;

}