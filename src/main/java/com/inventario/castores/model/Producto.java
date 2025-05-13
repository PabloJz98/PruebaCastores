package com.inventario.castores.model;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    
    private String nombre;
    
    private Double precio;

    private Integer cantidad;

    private Boolean status;
}