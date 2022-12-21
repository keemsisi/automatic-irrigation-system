package com.andela.telent.assessment.automaticirrigationsystem.service;

import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensorAlert;

import java.util.List;

public interface IrrigationSensorAlertService {
    GenericResponse<List<IrrigationSensorAlert>> fetchAllSensorAlerts(QueryRequestDTO request);
}
