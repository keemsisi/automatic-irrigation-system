package com.andela.telent.assessment.automaticirrigationsystem.controller;

import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensorAlert;
import com.andela.telent.assessment.automaticirrigationsystem.service.IrrigationSensorAlertService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/plot/irrigation/sensor/alert")
@Api(tags = "PLOT-IRRIGATION-SENSOR-ALERT-CONTROLLER")
@AllArgsConstructor
@Validated
public class IrrigationSensorAlertController {
    private final IrrigationSensorAlertService irrigationSensorAlertService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/fetch-all")
    public ResponseEntity<GenericResponse<List<IrrigationSensorAlert>>> fetchAllSensorSlot(@Valid QueryRequestDTO request) {
        GenericResponse<List<IrrigationSensorAlert>> response = irrigationSensorAlertService.fetchAllSensorAlerts(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
