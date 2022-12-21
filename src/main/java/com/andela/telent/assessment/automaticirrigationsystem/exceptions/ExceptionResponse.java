package com.andela.telent.assessment.automaticirrigationsystem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ExceptionResponse {

    private int status;

    private Date timestamp;

    private String message;

    private String error;

}
