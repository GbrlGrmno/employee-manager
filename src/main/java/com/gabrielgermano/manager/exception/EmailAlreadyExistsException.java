package com.gabrielgermano.manager.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String employeeEmail) {
        super("An employee with email " + employeeEmail + " already exists");
    }
}
