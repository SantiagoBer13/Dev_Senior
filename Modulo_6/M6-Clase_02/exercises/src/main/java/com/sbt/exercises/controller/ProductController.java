package com.sbt.exercises.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbt.exercises.model.Dto.ProductDto;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private List<ProductDto> products = new ArrayList<>(Arrays.asList(
        new ProductDto("Product 1", 100.0),
        new ProductDto("Product 2", 200.0),
        new ProductDto("Product 3", 300.0)
    ));

    @GetMapping
    public List<ProductDto> getProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return products.stream()
            .filter(product -> product.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto product) {
        products.add(product);
        return product;
    }

}
