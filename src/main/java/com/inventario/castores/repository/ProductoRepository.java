package com.inventario.castores.repository;

import com.inventario.castores.model.Producto;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByStatus(boolean status);
}
