package com.persistance.facturation.data.repositories;

import com.persistance.facturation.data.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}