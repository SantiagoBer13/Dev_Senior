package com.code.demo.Contenido_Ejercicio.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.demo.Contenido_Ejercicio.Model.Dto.UserRegisterDTO;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRegisterDTO dto) {
        return ResponseEntity.ok("ok");
    }
    

}
