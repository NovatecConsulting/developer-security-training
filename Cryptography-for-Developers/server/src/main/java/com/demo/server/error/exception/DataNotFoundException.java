package com.demo.server.error.exception;

/**
 * {@code DataNotFoundException} exception is thrown when no item is found during databsase look up.
 */
public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
    }
}
