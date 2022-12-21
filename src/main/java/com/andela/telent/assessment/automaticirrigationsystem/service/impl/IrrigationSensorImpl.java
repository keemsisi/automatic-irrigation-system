package com.andela.telent.assessment.automaticirrigationsystem.service.impl;

import com.andela.telent.assessment.automaticirrigationsystem.common.utils.ResponseUtil;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.PlotIrrigationConfigRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensor;
import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import com.andela.telent.assessment.automaticirrigationsystem.repository.IrrigationSensorRepository;
import com.andela.telent.assessment.automaticirrigationsystem.repository.PlotRepository;
import com.andela.telent.assessment.automaticirrigationsystem.service.IrrigationSensorService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class IrrigationSensorImpl implements IrrigationSensorService {
    private final ApplicationEventPublisher eventPublisher;
    private final ModelMapper modelMapper;
    private final IrrigationSensorRepository irrigationSensorRepository;
    private final PlotRepository plotRepository;

    @Override
    public GenericResponse<IrrigationSensor> configureSensor(PlotIrrigationConfigRequestDTO request) {
        Optional<Plot> optionalPlot = plotRepository.findById(request.getPlotId());
        if (optionalPlot.isPresent()) {
            Plot plot = optionalPlot.get();
            if (optionalPlot.get().getIrrigationSensorId() != null) {
                return ResponseUtil.generateResponse(null, "Sensor already configured", HttpStatus.BAD_REQUEST);
            } else {
                IrrigationSensor irrigationSensor = IrrigationSensor.builder().build();
                irrigationSensor.setSensorApiUrl(request.getSensorBaseApi());
                irrigationSensor.setPlotId(plot.getId());
                irrigationSensorRepository.save(irrigationSensor);
                return ResponseUtil.generateResponse(irrigationSensor, "Sensor configured successfully", HttpStatus.CREATED);
            }
        }
        return ResponseUtil.generateResponse(null, "Failed to configure sensor", HttpStatus.BAD_REQUEST);
    }

    @Override
    public GenericResponse<IrrigationSensor> fetchPlotSensors(QueryRequestDTO request) {
        return null;
    }
}
