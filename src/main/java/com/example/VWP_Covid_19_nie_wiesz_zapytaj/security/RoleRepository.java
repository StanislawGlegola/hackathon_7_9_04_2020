package com.example.VWP_Covid_19_nie_wiesz_zapytaj.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select r from Role r where r.role = ?1")
    Role findRoleByName(String role);
}
