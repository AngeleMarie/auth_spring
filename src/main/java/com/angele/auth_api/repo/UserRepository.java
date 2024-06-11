package com.angele.auth_api.repo;

import com.angele.auth_api.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{

Optional<User >findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail2);

boolean existsByEmail(String email);

  
}