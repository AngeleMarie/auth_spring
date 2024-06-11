package com.angele.auth_api.dto;

import java.util.HashSet;
import java.util.Set;

import com.angele.auth_api.models.Role;

public class RegisterDto {

    private String name;
    private String username;
    private String email;
    private String password;
     private Set<Role> roles = new HashSet<>(); 

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
