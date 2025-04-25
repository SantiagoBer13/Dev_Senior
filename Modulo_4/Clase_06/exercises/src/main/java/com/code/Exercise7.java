package com.code;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise7 {

    private List<Producto> productos;
    
    public Exercise7(List<Producto> productos){
        this.productos = productos;
    }

    public Map<String, List<Producto>> gruopingByCategory(){
        return this.productos.parallelStream()
               .collect(Collectors.groupingBy(product -> product.getCategory()));
    }

    public Double calculatePriceAverage(){
        return this.productos.parallelStream()
               .collect(Collectors.averagingDouble(product -> product.getPrice()));
    }

    public static class Producto{

        private String name;
        private Double price;
        private String category;
        
        public Producto(String name, Double price, String category) {
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
