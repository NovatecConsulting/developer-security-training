package com.demo.client.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * {@code ErrorInfo} represents an error response object which is exposed to
 * the external client in a human readable format.
 */
@NoArgsConstructor
@Getter
@Setter
public class ErrorInfo implements Serializable {

    private int code;

    private String type;

    private String message;
}
