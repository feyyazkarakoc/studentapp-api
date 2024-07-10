package com.tpe.repository;

import com.tpe.domain.Role;
import com.tpe.domain.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(UserRole roleType);
}
