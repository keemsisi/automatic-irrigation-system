package com.andela.telent.assessment.automaticirrigationsystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse<T>{
    private T data;
    private HttpStatus httpStatus;
    private String description;
    private LocalDateTime timeStamp;
}
