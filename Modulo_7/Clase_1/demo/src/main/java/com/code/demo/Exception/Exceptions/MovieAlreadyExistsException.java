package com.code.demo.Exception.Exceptions;

public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String title) {
        super("Ya existe una película con el título: " + title);
    }
}
