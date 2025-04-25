package com.code;

public class Empleado {

    private String name;
    private Integer age;
    private Double salario;
    
    public Empleado(String name, Integer age, Double salario) {
        this.name = name;
        this.age = age;
        this.salario = salario;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getSalario() {
        return salario;
    }
    
}
