package com.andela.telent.assessment.automaticirrigationsystem.dto.response;

import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IrrigationSensorResponse {
    private Long id;
    private String sensorApiUrl;
    private Plot plot;
    private List<IrrigationSensorAlertResponse> irrigationSensorAlert;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private long index;
}
