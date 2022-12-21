package com.andela.telent.assessment.automaticirrigationsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlotIrrigationConfigRequestDTO {
    @NotNull(message = "plotId can not be null")
    private Long plotId;
    @NotNull(message = "plot sensorBaseUrl can not be empty")
    private String sensorBaseApi;
}
