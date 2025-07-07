package com.kulebiakin.shapes.exception;

public class InvalidSphereDataException extends Exception {

    public InvalidSphereDataException(String message) {
        super(message);
    }

    public InvalidSphereDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
