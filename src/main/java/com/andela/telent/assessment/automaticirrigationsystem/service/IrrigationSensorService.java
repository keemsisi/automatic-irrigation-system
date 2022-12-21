package com.andela.telent.assessment.automaticirrigationsystem.service;

import com.andela.telent.assessment.automaticirrigationsystem.dto.request.PlotIrrigationConfigRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensor;

public interface IrrigationSensorService {

    GenericResponse<IrrigationSensor> configureSensor(PlotIrrigationConfigRequestDTO request);

    GenericResponse<IrrigationSensor> fetchPlotSensors(QueryRequestDTO request);
}
