package com.andela.telent.assessment.automaticirrigationsystem.service;

import com.andela.telent.assessment.automaticirrigationsystem.dto.request.IrrigationSensorSlotRequest;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.PlotIrrigationSensorSlot;

import java.util.List;

public interface IrrigationSensorSlotService {
    GenericResponse<PlotIrrigationSensorSlot> createSensorSlot(IrrigationSensorSlotRequest request);

    GenericResponse<List<PlotIrrigationSensorSlot>> fetchAllSensorSlot(QueryRequestDTO request);

    GenericResponse<PlotIrrigationSensorSlot> fetchSensorSlotById(Long slotId);
}
