package com.code.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.code.demo.Models.User;
import com.code.demo.Service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    private final CustomUserDetailsService customUserDetailsService; // Inyecta tu UserDetailsService
    // private final PasswordEncoder passwordEncoder; // Mantén la inyección si la necesitas directamente

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
        // this.passwordEncoder = passwordEncoder; // Si inyectas PasswordEncoder también
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Deshabilita CSRF si es una API REST sin sesiones
                .csrf(csrf -> {
                    //csrf.ignoringRequestMatchers("/api/public/**"); // Excluir rutas públicas si es necesario
                    csrf.disable();
                })
                // Define las reglas de autorización para las solicitudes HTTP
                .authorizeHttpRequests(authz -> authz
                        // 1. Permitir acceso público a Swagger UI
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html","/public/home").permitAll()
                        // 2. Permitir acceso público a una ruta específica, ej. /api/publicaciones
                        .requestMatchers("/api/publicaciones/**").permitAll()
                        // 3. Proteger las rutas de admin (solo usuarios con rol ADMIN)
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        // 4. Proteger las rutas de cursos (solo usuarios autenticados)
                        .requestMatchers("/api/cursos/**").authenticated()
                        // 5. Cualquier otra solicitud DEBE estar autenticada
                        .anyRequest().authenticated())
                // Habilita autenticación HTTP Basic (útil para APIs REST)
                .httpBasic(httpBasic -> {
                }); // O .formLogin(form -> {}); para login con formulario

        return http.build();
    }

}
