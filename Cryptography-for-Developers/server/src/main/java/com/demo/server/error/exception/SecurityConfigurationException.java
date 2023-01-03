package com.demo.server.error.exception;

/**
 * {@code SecurityConfigurationException} exception is thrown if any problem
 * is encountered during security setup.
 */
public class SecurityConfigurationException extends RuntimeException {

    public SecurityConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
