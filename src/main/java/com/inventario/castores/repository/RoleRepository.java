package com.inventario.castores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventario.castores.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
