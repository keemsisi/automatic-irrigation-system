package com.andela.telent.assessment.automaticirrigationsystem.controller;

import com.andela.telent.assessment.automaticirrigationsystem.dto.request.PlotRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import com.andela.telent.assessment.automaticirrigationsystem.service.PlotService;
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
@RequestMapping("/api/v1/plot")
@Api(tags = "PLOT-CONTROLLER")
@AllArgsConstructor
@Validated
public class PlotController {
    private final PlotService plotService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GenericResponse<Plot>> addPlot(@Valid @RequestBody PlotRequestDTO request) {
        GenericResponse<Plot> response = plotService.addPlot(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/fetch-all")
    public ResponseEntity<GenericResponse<List<Plot>>> fetchAll(@Valid QueryRequestDTO request) {
        GenericResponse<List<Plot>> response = plotService.fetchAll(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/fetch/{plotId}")
    public ResponseEntity<GenericResponse<Plot>> fetchByPlotId(@PathVariable Long plotId) {
        GenericResponse<Plot> response = plotService.fetchById(plotId);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{plotId}")
    public ResponseEntity<GenericResponse<Plot>> editPlot(@Valid @RequestBody PlotRequestDTO request, @PathVariable Long plotId) {
        GenericResponse<Plot> response = plotService.editPlot(request, plotId);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}