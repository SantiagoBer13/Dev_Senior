package com.sbt.exercises.model.Dto;

public class ProductDto {
    private static Long nextId = 0L;
    private Long id;
    private String name;
    private Double price;

    public ProductDto() {
        nextId++;
        this.id = nextId;
    }

    public ProductDto( String name, Double price) {
        nextId++;
        this.id = nextId;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDto [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
