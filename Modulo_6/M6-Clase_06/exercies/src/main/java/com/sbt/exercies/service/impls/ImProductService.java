package com.sbt.exercies.service.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sbt.exercies.models.Product;
import com.sbt.exercies.repositories.ProductRepository;
import com.sbt.exercies.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImProductService implements ProductService {
    
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }

    public  Product create(Product product){
        return productRepository.save(product);
    };

    public void delete(Long id){
        productRepository.deleteById(id);
    };

    public List<Product> getByNameContainingIgnoreCase(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    };
    public List<Product> getByPrecioBetween(Double priceMin, Double priceMax){
        return productRepository.findByPriceBetween(priceMin, priceMax);
    };

}
