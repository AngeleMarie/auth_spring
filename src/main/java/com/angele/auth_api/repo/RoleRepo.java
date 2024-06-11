package com.angele.auth_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angele.auth_api.models.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);
}