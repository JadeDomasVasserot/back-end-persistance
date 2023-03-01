package com.persistance.facturation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contient")
public class Contient {
    @Id
    @Column(name = "id", columnDefinition = "INT UNSIGNED not null")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_facture", nullable = false)
    private Facture idFacture;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_article", nullable = false)
    private Article idArticle;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

}