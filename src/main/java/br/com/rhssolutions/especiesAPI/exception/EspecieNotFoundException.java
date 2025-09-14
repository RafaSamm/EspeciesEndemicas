package br.com.rhssolutions.especiesAPI.exception;

public class EspecieNotFoundException extends RuntimeException {

    public EspecieNotFoundException(String message) {
        super(message);
    }
}
