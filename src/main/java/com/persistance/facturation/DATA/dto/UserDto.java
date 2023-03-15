package com.persistance.facturation.DATA.dto;

import com.persistance.facturation.DATA.models.User;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;

/**
 * A DTO for the {@link User} entity
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private RoleDto idRole;
    private Collection<FactureDto> factures;
}