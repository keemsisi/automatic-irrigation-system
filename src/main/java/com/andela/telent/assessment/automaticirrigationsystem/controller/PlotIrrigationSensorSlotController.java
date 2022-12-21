package com.andela.telent.assessment.automaticirrigationsystem.controller;

import com.andela.telent.assessment.automaticirrigationsystem.dto.request.IrrigationSensorSlotRequest;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.PlotIrrigationSensorSlot;
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
@RequestMapping("/api/v1/plot/irrigation/sensor/slot")
@Api(tags = "PLOT-IRRIGATION-CONFIG-CONTROLLER")
@AllArgsConstructor
@Validated
public class PlotIrrigationSensorSlotController {
    private final IrrigationSensorSlotService sensorSlotService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<PlotIrrigationSensorSlot>> createSlot(@Valid @RequestBody IrrigationSensorSlotRequest request) {
        GenericResponse<PlotIrrigationSensorSlot> response = sensorSlotService.createSensorSlot(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/fetch-all")
    public ResponseEntity<GenericResponse<List<PlotIrrigationSensorSlot>>> fetchAllSensorSlot(@Valid QueryRequestDTO request) {
        GenericResponse<List<PlotIrrigationSensorSlot>> response = sensorSlotService.fetchAllSensorSlot(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/fetch/{slotId}")
    public ResponseEntity<GenericResponse<PlotIrrigationSensorSlot>> fetchSensorSlotById(@PathVariable Long slotId) {
        GenericResponse<PlotIrrigationSensorSlot> response = sensorSlotService.fetchSensorSlotById(slotId);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}
