package com.code.demo.config;

import com.code.demo.Models.User;
import com.code.demo.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedUsers(UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {

            if (!userRepository.existsByUsername("user")) {
                User u = new User();
                u.setUsername("user");
                u.setPassword(encoder.encode("password"));
                u.setRoles(Set.of("ROLE_USER"));
                userRepository.save(u);
            }

            if (!userRepository.existsByUsername("admin")) {
                User a = new User();
                a.setUsername("admin");
                a.setPassword(encoder.encode("adminpass")); 
                a.setRoles(Set.of("ROLE_ADMIN", "ROLE_USER"));
                userRepository.save(a);
            }

            if (!userRepository.existsByUsername("tecnico")) {
                User u = new User();
                u.setUsername("tecnico");
                u.setPassword(encoder.encode("password")); 
                u.setRoles(Set.of("ROLE_ADMIN", "ROLE_USER"));
                userRepository.save(u);
            }
        };
    }
}
