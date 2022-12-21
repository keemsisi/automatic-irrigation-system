package com.andela.telent.assessment.automaticirrigationsystem.dto.response;


import com.andela.telent.assessment.automaticirrigationsystem.config.SlotStatusEnum;
import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlotIrrigationSensorSlotResponse {
    private Long id;
    private float amountOfWater;
    private LocalDateTime slotStartTime;
    private LocalDateTime slotEndTime;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private SlotStatusEnum slotStatusEnum;
    private Plot plot;
    private long index;
}
