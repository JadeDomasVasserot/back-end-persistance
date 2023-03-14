package com.persistance.facturation.data.dto;

import com.persistance.facturation.data.models.Role;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link Role} entity
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {
    private Integer id;
    private String label;
}