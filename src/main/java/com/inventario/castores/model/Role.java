package com.inventario.castores.model;
import lombok.Data;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Role {
    


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    
    public Role() {
    }
    public Role(String string) {
        this.name=string;
    }
}
