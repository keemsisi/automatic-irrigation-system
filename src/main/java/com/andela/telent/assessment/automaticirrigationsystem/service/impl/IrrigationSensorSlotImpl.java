package com.andela.telent.assessment.automaticirrigationsystem.service.impl;

import com.andela.telent.assessment.automaticirrigationsystem.common.utils.ResponseUtil;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.IrrigationSensorSlotRequest;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import com.andela.telent.assessment.automaticirrigationsystem.entity.PlotIrrigationSensorSlot;
import com.andela.telent.assessment.automaticirrigationsystem.repository.IrrigationSensorSlotRepository;
import com.andela.telent.assessment.automaticirrigationsystem.repository.PlotRepository;
import com.andela.telent.assessment.automaticirrigationsystem.service.IrrigationSensorSlotService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@AllArgsConstructor
public class IrrigationSensorSlotImpl implements IrrigationSensorSlotService {
    private final ModelMapper modelMapper;
    private final ApplicationEventPublisher appEventPub;
    private final IrrigationSensorSlotRepository irrigationSensorSlotRepository;
    private final PlotRepository plotRepository;

    @Override
    @Transactional
    public GenericResponse<PlotIrrigationSensorSlot> createSensorSlot(IrrigationSensorSlotRequest request) {
        Optional<Plot> optionalPlot = plotRepository.findById(request.getPlotId());
        if (optionalPlot.isPresent()) {
            Plot foundPlot = optionalPlot.get();
            if (ObjectUtils.isEmpty(foundPlot.getIrrigationSensorId()))
                return ResponseUtil.generateResponse(null, "Oops! Plot does not have configured sensor.", HttpStatus.BAD_REQUEST);
            PlotIrrigationSensorSlot plotIrrigationSensorSlot = modelMapper.map(request, PlotIrrigationSensorSlot.class);
            if (request.getAmountOfWater() <= 0)
                plotIrrigationSensorSlot.setAmountOfWater(foundPlot.getAgriculturalCropTypeEnum().getAmountOfWater());
            plotIrrigationSensorSlot.setPlotId(foundPlot.getId());
            irrigationSensorSlotRepository.save(plotIrrigationSensorSlot);
            foundPlot.setIrrigationSensorId(plotIrrigationSensorSlot.getId());
            plotRepository.save(foundPlot);
            appEventPub.publishEvent(plotIrrigationSensorSlot);
        }
        return ResponseUtil.generateResponse(null, "Oops! Plot does not exists!", HttpStatus.BAD_REQUEST);
    }
}
