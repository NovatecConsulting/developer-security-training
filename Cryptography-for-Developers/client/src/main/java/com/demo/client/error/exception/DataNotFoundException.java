package com.demo.client.error.exception;

import com.demo.client.error.ErrorInfo;
import lombok.Getter;

/**
 * {@code DataNotFoundException} exception is thrown when no item is found
 * while making an external call to the remote server.
 * <p/>
 *
 * @author Indra Basak
 * @since 02/20/18
 */
public class DataNotFoundException extends RuntimeException {

    @Getter
    private final transient ErrorInfo errorInfo;

    public DataNotFoundException(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
}
