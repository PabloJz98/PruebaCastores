package com.inventario.castores.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.inventario.castores.repository.UserRepository;
import com.inventario.castores.repository.RoleRepository;
import com.inventario.castores.model.Role;
import com.inventario.castores.model.User;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Role userRole =new Role();
        Role adminRole =new Role();

        if (roleRepository.findByName("USER") == null) {

            userRole.setName("USER");
            if (userRole != null){
                User user = new User("user", "user");
                user.getRoles().add(userRole);
                userRepository.save(user);
                roleRepository.save(userRole);
            }
        }
        if (roleRepository.findByName("ADMIN")== null) {
            adminRole .setName("ADMIN");
            if (adminRole != null){
                User admin = new User("admin", "admin");
                admin.getRoles().add(adminRole);
                userRepository.save(admin);
                roleRepository.save(adminRole);
            }
        }

        
        
    }
}
