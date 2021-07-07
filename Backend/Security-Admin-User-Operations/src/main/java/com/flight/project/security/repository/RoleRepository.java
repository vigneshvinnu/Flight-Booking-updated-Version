package com.flight.project.security.repository;

import com.flight.project.security.model.ERole;
import com.flight.project.security.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
