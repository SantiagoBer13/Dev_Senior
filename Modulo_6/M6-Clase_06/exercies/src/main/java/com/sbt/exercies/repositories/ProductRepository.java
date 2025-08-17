package com.sbt.exercies.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbt.exercies.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long>  {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByPriceBetween(Double priceMin, Double priceMax);
}
