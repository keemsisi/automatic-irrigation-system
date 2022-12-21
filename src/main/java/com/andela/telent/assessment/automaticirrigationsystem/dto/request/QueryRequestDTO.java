package com.andela.telent.assessment.automaticirrigationsystem.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryRequestDTO {
    private long index;
    private long limit = 20;
    private Sort.Direction order = Sort.Direction.DESC;
    private String[] sortBy;
}