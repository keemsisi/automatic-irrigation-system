package com.andela.telent.assessment.automaticirrigationsystem.service;

import com.andela.telent.assessment.automaticirrigationsystem.dto.request.IrrigationSensorSlotRequest;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import com.andela.telent.assessment.automaticirrigationsystem.entity.PlotIrrigationSensorSlot;

import java.util.Optional;

public interface IrrigationSensorSlotService {
    GenericResponse<PlotIrrigationSensorSlot> createSensorSlot(IrrigationSensorSlotRequest request);
}
