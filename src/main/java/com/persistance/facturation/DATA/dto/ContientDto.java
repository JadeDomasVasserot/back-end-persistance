package com.persistance.facturation.data.dto;

import com.persistance.facturation.data.models.Contient;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link Contient} entity
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContientDto implements Serializable {
    private Long id;
    private ArticleDto idArticle;
    private Integer quantite;
}