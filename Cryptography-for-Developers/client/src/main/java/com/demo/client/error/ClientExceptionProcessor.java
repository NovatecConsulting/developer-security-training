package com.demo.client.error;

import com.demo.client.error.exception.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * {@code ClientExceptionProcessor} processes exceptions at the application
 * level and is not restricted to any specific controller.
 */
@ControllerAdvice
@Slf4j
public class ClientExceptionProcessor {

    /**
     * Handles {@code DataNotFoundException} exception.
     *
     * @param req HTTP request to extract the URL
     * @param ex  exception to be processed
     * @return ths error information that is sent to the client
     */
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleDataNotFoundException(
            HttpServletRequest req, DataNotFoundException ex) {
        return ex.getErrorInfo();
    }
}
