package com.code;

public class Producto implements Comparable<Producto>{
    
    private String name;
    private Double price;
    private Integer quantity;

    public Producto(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Producto producto) {
        return Double.compare(this.price, producto.getPrice());
    }

    public Integer getQuantity() {
        return quantity;
    }

    

}