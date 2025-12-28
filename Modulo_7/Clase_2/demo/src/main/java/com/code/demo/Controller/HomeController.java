package com.code.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/public")
public class HomeController {

    @GetMapping("/home")
    public String getMethodName() {
        return new String("Bienvenido a la página pública!");
    }
    
}
