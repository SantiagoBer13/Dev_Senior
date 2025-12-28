package com.code.demo.Exception.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id) {
        super("La pelicula con el id " + id + " no existe.");
    }
}
