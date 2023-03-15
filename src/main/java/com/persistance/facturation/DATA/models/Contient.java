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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Contient {
    @Id
    @Column(name = "id", columnDefinition = "INT UNSIGNED not null")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_facture", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Facture idFacture;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_article", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Article idArticle;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

}