package com.andela.telent.assessment.automaticirrigationsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    private ResponseEntity<ExceptionResponse> exception(final Exception exception, final HttpStatus httpStatus) {
        String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        final ExceptionResponse errorResponse = ExceptionResponse.builder()
                .status(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .timestamp(new Date())
                .message(message)
                .build();
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
