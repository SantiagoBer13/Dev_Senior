package com.sbt.exercies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbt.exercies.models.Product;
import com.sbt.exercies.service.impls.ImProductService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ImProductService imProductService;

    @GetMapping("")
    public List<Product> getAllClients() {
        return imProductService.getAllProducts();
    }

    @GetMapping("{id}")
    public Optional<Product> getMethodName(@PathVariable Long id) {
        return imProductService.getById(id);
    }

    @PostMapping("")
    public Product createProduct(@Valid @RequestBody Product product) {
        return imProductService.create(product);
    }
    
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id){
        imProductService.delete(id);
    }

    @GetMapping("/nombre")
    public List<Product> getByNameContainingIgnoreCase(@RequestParam String name) {
        return imProductService.getByNameContainingIgnoreCase(name);
    }
    
    @GetMapping("/precio")
    public List<Product> getByPrecioBetween(@RequestParam Double priceMin, @RequestParam Double priceMax) {
        return imProductService.getByPrecioBetween(priceMin, priceMax);
    }
}
