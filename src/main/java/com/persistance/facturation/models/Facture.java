package com.persistance.facturation.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Column(name = "date", nullable = false)
    private Instant date;
    @OneToMany(mappedBy = "idFacture")
    private Collection<Contient> contients = new LinkedHashSet<>();

/*
    TODO [JPA Buddy] create field to map the 'total' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "total", columnDefinition = "DECIMAL(10) UNSIGNED not null")
    private Object total;
*/
}