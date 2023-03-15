package com.persistance.facturation.DATA.dto;

import com.persistance.facturation.DATA.models.Facture;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
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

    private BigDecimal total;
}