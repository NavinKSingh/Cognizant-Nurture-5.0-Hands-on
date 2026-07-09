package com.cognizant.springlearn;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.converter.HttpMessageNotReadableException;

/**
 * Hands on doc 4: "Include global exception handler for validation errors"
 * + "If string value is included in a numeric field... include a new method
 * in global exception handler".
 *
 * NOTE: Spring 6 (used by Spring Boot 3) changed the `status` parameter type
 * on ResponseEntityExceptionHandler overrides from HttpStatus to
 * HttpStatusCode compared to the original hands-on document (written for an
 * older Spring Boot 2 version) — signatures below are updated accordingly so
 * this actually compiles and overrides correctly on Boot 3.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        LOGGER.info("Start");

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        body.put("errors", errors);

        LOGGER.info("End");
        return new ResponseEntity<>(body, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        LOGGER.info("Start");

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        body.put("error", "Bad Request");

        List<String> errors = new ArrayList<>();
        Throwable cause = ex.getCause() == null ? ex : ex.getCause();
        if (cause instanceof InvalidFormatException ife) {
            for (InvalidFormatException.Reference reference : ife.getPath()) {
                body.put("message", "Incorrect format for field '" + reference.getFieldName() + "'");
            }
        } else {
            body.put("message", "Malformed JSON request");
        }
        body.put("errors", errors);

        LOGGER.info("End");
        return new ResponseEntity<>(body, headers, status);
    }
}
