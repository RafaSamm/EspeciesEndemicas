package br.com.rhssolutions.especiesAPI.exception;

public class PaisNotFoundException extends RuntimeException {

    public PaisNotFoundException(String message) {
        super(message);
    }
}
