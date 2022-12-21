package com.andela.telent.assessment.automaticirrigationsystem.common.utils;

import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseUtil {
    public static <T> GenericResponse<T> generateResponse(T data, String message, HttpStatus httpStatus) {
        return new GenericResponse<>(data, httpStatus, message, LocalDateTime.now());
    }
}
