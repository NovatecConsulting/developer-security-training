package com.demo.server.error;

import com.demo.server.error.exception.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;

/**
 * {@code ExceptionProcessor} processes exceptions at the application level and
 * is not restricted to any specific controller.
 */
@ControllerAdvice
@Slf4j
public class ExceptionProcessor {

    /**
     * Handles <tt>DataNotFoundException</tt> exception.It unwraps the root case
     * and coverts it into an <tt>ErrorInfo</tt> object.
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
        ErrorInfo info = getErrorInfo(req, HttpStatus.NOT_FOUND);
        info.setMessage(ex.getMessage());

        return info;
    }

    private ErrorInfo getErrorInfo(HttpServletRequest req,
            HttpStatus httpStatus) {
        ErrorInfo info = new ErrorInfo();
        ServletUriComponentsBuilder builder =
                ServletUriComponentsBuilder.fromServletMapping(req);
        info.setPath(builder.path(
                req.getRequestURI()).build().getPath());
        info.setCode(httpStatus.value());
        info.setType(httpStatus.getReasonPhrase());
        return info;
    }
}
