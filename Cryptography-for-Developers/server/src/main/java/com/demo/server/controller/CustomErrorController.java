package com.demo.server.controller;

import com.demo.server.error.ErrorInfo;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

/**
 * {@code CustomErrorController} used for showing error messages.
 */
@RestController
@SuppressWarnings({"squid:S1075"})
public class CustomErrorController implements ErrorController {

    private static final Logger
            log = LoggerFactory.getLogger(CustomErrorController.class);

    private static final String PATH = "/error";

    @Value("${debug:true}")
    private String debug;

    private final ErrorAttributes errorAttributes;

    @Autowired
    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = PATH)
    public ResponseEntity<ErrorInfo> error(HttpServletRequest request,
                                           HttpServletResponse response) {
        WebRequest webRequest =
                new ServletWebRequest(request);

        Map<String, Object> attributes =
                errorAttributes.getErrorAttributes(webRequest,
                        ErrorAttributeOptions.of(
                                ErrorAttributeOptions.Include.MESSAGE,
                                ErrorAttributeOptions.Include.EXCEPTION,
                                ErrorAttributeOptions.Include.BINDING_ERRORS,
                                ErrorAttributeOptions.Include.STACK_TRACE)
                );

        ErrorInfo info = new ErrorInfo();
        info.setCode(response.getStatus());
        info.setMessage((String) attributes.get("message"));
        log.error((String) attributes.get("com/demo/server/error"));

        HttpStatus statusCode = HttpStatus.valueOf(response.getStatus());

        Throwable error = errorAttributes.getError(webRequest);
        if (error instanceof RequestRejectedException) {
            info.setCode(HttpStatus.BAD_REQUEST.value());
            statusCode = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(info, statusCode);
    }

    /*@Override
    public String getErrorPath() {
        return PATH;
    }*/
}