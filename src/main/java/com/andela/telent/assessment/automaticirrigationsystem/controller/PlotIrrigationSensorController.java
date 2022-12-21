package com.andela.telent.assessment.automaticirrigationsystem.controller;


import com.andela.telent.assessment.automaticirrigationsystem.dto.request.IrrigationSensorSlotRequest;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.PlotIrrigationConfigRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensor;
import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensorAlert;
import com.andela.telent.assessment.automaticirrigationsystem.entity.PlotIrrigationSensorSlot;
import com.andela.telent.assessment.automaticirrigationsystem.service.IrrigationSensorAlertService;
import com.andela.telent.assessment.automaticirrigationsystem.service.IrrigationSensorService;
import com.andela.telent.assessment.automaticirrigationsystem.service.IrrigationSensorSlotService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/plot/irrigation/sensor")
@Api(tags = "PLOT-IRRIGATION-CONFIG-CONTROLLER")
@AllArgsConstructor
@Validated
public class PlotIrrigationSensorController {
    private final IrrigationSensorService irrigationSensorService;
    private final IrrigationSensorAlertService irrigationSensorAlertService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/configure")
    public ResponseEntity<GenericResponse<IrrigationSensor>> configurePlot(@Valid @RequestBody PlotIrrigationConfigRequestDTO request) {
        GenericResponse<IrrigationSensor> response = irrigationSensorService.configureSensor(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/fetch")
    public ResponseEntity<GenericResponse<IrrigationSensor>> fetchPlotSensors(@Valid QueryRequestDTO request) {
        GenericResponse<IrrigationSensor> response = irrigationSensorService.fetchPlotSensors(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/fetch/alerts")
    public ResponseEntity<GenericResponse<List<IrrigationSensorAlert>>> fetchAllSensorAlerts(@Valid QueryRequestDTO request) {
        GenericResponse<List<IrrigationSensorAlert>> response = irrigationSensorAlertService.fetchAllSensorAlerts(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
