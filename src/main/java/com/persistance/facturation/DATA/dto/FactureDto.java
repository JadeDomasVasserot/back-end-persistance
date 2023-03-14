package com.persistance.facturation.data.dto;

import com.persistance.facturation.data.models.Facture;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;

/**
 * A DTO for the {@link Facture} entity
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureDto implements Serializable {
    private Integer id;
    private Instant date;
    private String name;
    private Collection<ContientDto> contients;
}