package com.persistance.facturation.DATA.repositories;

import com.persistance.facturation.DATA.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}