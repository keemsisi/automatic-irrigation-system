package com.andela.telent.assessment.automaticirrigationsystem.dto.request.events;

import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import com.andela.telent.assessment.automaticirrigationsystem.entity.PlotIrrigationSensorSlot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlotSensorNewSlotEventDTO {
    private Plot plot;
    private PlotIrrigationSensorSlot plotIrrigationSensorSlot;
}
