package com.demo.client.error;

import com.demo.client.error.exception.DataNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

/**
 * {@code CustomErrorHandler} handles HTTP client error response.
 */
public class CustomErrorHandler extends DefaultResponseErrorHandler {

    private final ObjectMapper objectMapper;

    public CustomErrorHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    protected void handleError(ClientHttpResponse response,
            HttpStatus statusCode) throws IOException {
        if (statusCode == HttpStatus.NOT_FOUND) {
            String message = new String(getResponseBody(response));
            ErrorInfo info = objectMapper.readValue(message, ErrorInfo.class);
            throw new DataNotFoundException(info);
        }
    }
}
