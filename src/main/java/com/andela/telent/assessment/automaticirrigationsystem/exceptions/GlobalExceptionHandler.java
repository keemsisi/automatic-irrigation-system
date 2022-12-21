package com.andela.telent.assessment.automaticirrigationsystem.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.util.Date;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends DefaultResponseErrorHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    private ResponseEntity<ExceptionResponse> exception(final Exception exception) {
        String ERROR_CODE = RandomStringUtils.randomAlphanumeric(20);
        final ExceptionResponse errorResponse = ExceptionResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .timestamp(new Date()).message(String.format("An internal server error occurred with ERROR_CODE:: %s", ERROR_CODE)).build();
        log.info("----||||ERROR OCCURRED||||----",exception);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
