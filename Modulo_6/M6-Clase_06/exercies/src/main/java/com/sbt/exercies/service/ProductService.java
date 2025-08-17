package com.sbt.exercies.service;

import java.util.List;
import java.util.Optional;

import com.sbt.exercies.models.Product;

public interface ProductService {
    
     List<Product> getAllProducts();
     Optional<Product> getById(Long id);
     Product create(Product product);
     //Product update(Long id, Product product);
     void delete(Long id);
     List<Product> getByNameContainingIgnoreCase(String name);
     List<Product> getByPrecioBetween(Double priceMin, Double priceMax);
}
