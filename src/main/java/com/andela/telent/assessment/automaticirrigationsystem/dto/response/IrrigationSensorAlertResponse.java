package com.andela.telent.assessment.automaticirrigationsystem.dto.response;

import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IrrigationSensorAlertResponse {
    private Long id;
    private IrrigationSensorResponse irrigationSensor;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private long index;
}
