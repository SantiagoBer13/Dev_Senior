package com.code;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalisisVentas {

    private List<Venta> ventas;
    
    public AnalisisVentas(List<String> ventas) {
        this.ventas = ventas.stream().map(e -> {
            String[] datos = e.split(",");
            return new Venta(
                datos[0],
                Integer.parseInt(datos[1]),
                Double.parseDouble(datos[2]) 
            );
        }).collect(Collectors.toList());
    }

    public Double calculateTotalIncome() {
        return this.ventas.stream()
            .mapToDouble(v -> v.getTotal())
            .sum();
    }

    public Map<String, Integer> countPurchaseByProduct(){
        return this.ventas.stream()
            .collect(Collectors.groupingBy(Venta::getProduct, Collectors.summingInt(Venta::getQuantitySold)));
    }

    public List<Venta> filterPurchasesHigher(double amount){
        return this.ventas.stream()
            .filter(e -> e.getTotal() > amount)
            .collect(Collectors.toList());
    }

    public Venta getProductMorePurchased(){
        return this.ventas.stream()
            .max(Comparator.comparing(Venta::getQuantitySold))
            .orElse(null); 
    }

    public static class Venta {
        private String product;
        private Integer quantitySold;
        private Double priceUnit;

        public Venta(String product, Integer quantitySold, Double priceUnit) {
            this.product = product;
            this.quantitySold = quantitySold;
            this.priceUnit = priceUnit;
        }

        public String getProduct() {
            return product;
        }

        public Integer getQuantitySold() {
            return quantitySold;
        }

        public Double getPriceUnit() {
            return priceUnit;
        }

        public Double getTotal() {
            return this.quantitySold * this.priceUnit;
        }
    }
}