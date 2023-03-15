package com.persistance.facturation.DATA.dto;

import com.persistance.facturation.DATA.models.Contient;
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