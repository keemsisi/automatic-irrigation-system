package com.andela.telent.assessment.automaticirrigationsystem.common.utils;

import com.andela.telent.assessment.automaticirrigationsystem.dto.response.PlotResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ResponseUtilModelMapper {
    private final ModelMapper modelMapper;

    public PlotResponse mapPlotToPlotResponse(Plot plot) {
        PlotResponse plotResponse = modelMapper.map(plot, PlotResponse.class);
        plotResponse.setIrrigationSensorId(plotResponse.getIrrigationSensorId());
        return plotResponse;
    }
}
