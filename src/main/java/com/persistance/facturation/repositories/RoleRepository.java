package com.persistance.facturation.repositories;

import com.persistance.facturation.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}