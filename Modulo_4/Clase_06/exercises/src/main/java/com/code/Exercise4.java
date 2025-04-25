package com.code;

import java.util.Comparator;
import java.util.List;

public class Exercise4 {

    List<Product> products;

    public Exercise4(List<Product> products) {
        this.products = products;
    }

    public Product findProductMoreCaro(){
        return this.products.stream().max(Comparator.comparing(Product::getPrice)).orElse(null);
    }

    public Product findProductMoreCheap(){
        return this.products.stream().min(Comparator.comparing(Product::getPrice)).orElse(null);
    }

    public static class Product{
        private String name;
        private Double price;
        private String category;
        public Product(String name, Double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }
        public String getName() {
            return name;
        }
        public Double getPrice() {
            return price;
        }
        public String getCategory() {
            return category;
        }
    }
}
