package com.example.mealsdelivery.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mealsdelivery.models.ERole;
import com.example.mealsdelivery.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
  }