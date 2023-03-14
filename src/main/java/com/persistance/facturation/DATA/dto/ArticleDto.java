package com.persistance.facturation.data.dto;

import com.persistance.facturation.data.models.Article;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link Article} entity
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto implements Serializable {
    private Integer id;
    private String nom;
    private String description;
    private BigDecimal prix;
}