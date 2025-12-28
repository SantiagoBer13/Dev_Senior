package com.code.demo.exception.exceptions;

public class ProjectAlreadyExistsException extends RuntimeException {
    public ProjectAlreadyExistsException(String title) {
        super("Ya existe una proyecto con el título: " + title);
    }
}
