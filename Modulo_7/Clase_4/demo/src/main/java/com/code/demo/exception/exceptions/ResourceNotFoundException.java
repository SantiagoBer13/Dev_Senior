package com.code.demo.exception.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("El proyecto con el id " + id + " no existe.");
    }
}
