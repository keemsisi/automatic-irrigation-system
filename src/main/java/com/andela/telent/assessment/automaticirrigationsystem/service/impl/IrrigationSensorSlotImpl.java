package com.andela.telent.assessment.automaticirrigationsystem.service.impl;

import com.andela.telent.assessment.automaticirrigationsystem.common.utils.ResponseUtil;
import com.andela.telent.assessment.automaticirrigationsystem.config.SlotStatusEnum;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.IrrigationSensorSlotRequest;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensorAlert;
import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import com.andela.telent.assessment.automaticirrigationsystem.entity.PlotIrrigationSensorSlot;
import com.andela.telent.assessment.automaticirrigationsystem.repository.IrrigationSensorAlertRepository;
import com.andela.telent.assessment.automaticirrigationsystem.repository.IrrigationSensorSlotRepository;
import com.andela.telent.assessment.automaticirrigationsystem.repository.PlotRepository;
import com.andela.telent.assessment.automaticirrigationsystem.service.IrrigationSensorSlotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
@AllArgsConstructor
public class IrrigationSensorSlotImpl implements IrrigationSensorSlotService {
    private final ModelMapper modelMapper;
    private final ApplicationEventPublisher appEventPub;
    private final IrrigationSensorSlotRepository irrigationSensorSlotRepository;
    private final PlotRepository plotRepository;
    private final IrrigationSensorAlertRepository irrigationSensorAlertRepository;

    @Override
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
            CompletableFuture.runAsync(() -> {
                try {
                    appEventPub.publishEvent(plotIrrigationSensorSlot);
                } catch (Exception e) {
                    log.error("----||||ERROR SENDING SLOT TO SENSOR||||----", e);
                    IrrigationSensorAlert alert = IrrigationSensorAlert.builder()
                            .irrigationSensorId(foundPlot.getIrrigationSensorId())
                            .description(String.format("Failed to send slot with id %s to sensor at %s", plotIrrigationSensorSlot.getId(), LocalDateTime.now()))
                            .build();
                    plotIrrigationSensorSlot.setSlotStatusEnum(SlotStatusEnum.FAILED);
                    plotIrrigationSensorSlot.setDateModified(LocalDateTime.now());
                    irrigationSensorSlotRepository.save(plotIrrigationSensorSlot);
                    irrigationSensorAlertRepository.save(alert);
                }
            });
            return ResponseUtil.generateResponse(plotIrrigationSensorSlot, "Successfully created irrigation slot", HttpStatus.CREATED);
        }
        return ResponseUtil.generateResponse(null, "Oops! Plot does not exists!", HttpStatus.BAD_REQUEST);
    }

    @Override
    public GenericResponse<List<PlotIrrigationSensorSlot>> fetchAllSensorSlot(QueryRequestDTO request) {
        List<PlotIrrigationSensorSlot> results = irrigationSensorSlotRepository.findAllSensorSlots(request.getLimit(), request.getIndex(), request.getOrder().name());
        return ResponseUtil.generateResponse(results, "Request Successful", HttpStatus.OK);
    }

    @Override
    public GenericResponse<PlotIrrigationSensorSlot> fetchSensorSlotById(Long slotId) {
        return getPlotById(slotId)
                .map(sensorSlot -> ResponseUtil.generateResponse(sensorSlot, "Record fetched successfully", HttpStatus.OK))
                .orElseGet(() -> ResponseUtil.generateResponse(null, "No matching record found", HttpStatus.NOT_FOUND));
    }

    private Optional<PlotIrrigationSensorSlot> getPlotById(Long plotId) {
        return irrigationSensorSlotRepository.findById(plotId);
    }
}
