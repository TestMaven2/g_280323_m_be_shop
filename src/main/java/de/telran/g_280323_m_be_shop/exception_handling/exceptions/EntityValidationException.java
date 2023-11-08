package de.telran.g_280323_m_be_shop.exception_handling.exceptions;

public class EntityValidationException extends RuntimeException {
    public EntityValidationException(String message) {
        super(message);
    }
}