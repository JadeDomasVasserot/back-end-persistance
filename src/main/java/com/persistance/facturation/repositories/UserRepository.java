package com.persistance.facturation.repositories;

import com.persistance.facturation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}