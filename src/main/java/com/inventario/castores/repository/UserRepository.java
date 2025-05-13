package com.inventario.castores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventario.castores.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
