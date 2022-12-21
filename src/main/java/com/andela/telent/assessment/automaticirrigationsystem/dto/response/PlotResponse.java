package com.andela.telent.assessment.automaticirrigationsystem.dto.response;

import com.andela.telent.assessment.automaticirrigationsystem.common.enums.AgriculturalCropTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlotResponse {
    private Long id;
    private String name;
    private Long irrigationSensorId;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private AgriculturalCropTypeEnum agriculturalCropTypeEnum;
    private long index;
}
