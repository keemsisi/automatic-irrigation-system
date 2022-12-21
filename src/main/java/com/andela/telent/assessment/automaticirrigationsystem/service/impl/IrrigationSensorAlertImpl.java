package com.andela.telent.assessment.automaticirrigationsystem.service.impl;

import com.andela.telent.assessment.automaticirrigationsystem.common.utils.ResponseUtil;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensorAlert;
import com.andela.telent.assessment.automaticirrigationsystem.repository.IrrigationSensorAlertRepository;
import com.andela.telent.assessment.automaticirrigationsystem.service.IrrigationSensorAlertService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class IrrigationSensorAlertImpl implements IrrigationSensorAlertService {
    private final IrrigationSensorAlertRepository irrigationSensorAlertRepository;

    @Override
    public GenericResponse<List<IrrigationSensorAlert>> fetchAllSensorAlerts(QueryRequestDTO request) {
        List<IrrigationSensorAlert> results = irrigationSensorAlertRepository.findAllAlerts(request.getLimit(), request.getIndex(), request.getOrder().name());
        return ResponseUtil.generateResponse(results, "Request Successful", HttpStatus.OK);
    }
}
