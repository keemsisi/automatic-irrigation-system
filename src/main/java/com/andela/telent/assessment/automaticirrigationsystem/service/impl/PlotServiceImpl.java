package com.andela.telent.assessment.automaticirrigationsystem.service.impl;

import com.andela.telent.assessment.automaticirrigationsystem.common.utils.ResponseUtil;
import com.andela.telent.assessment.automaticirrigationsystem.common.utils.ResponseUtilModelMapper;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.PlotRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.PlotResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import com.andela.telent.assessment.automaticirrigationsystem.repository.PlotRepository;
import com.andela.telent.assessment.automaticirrigationsystem.service.PlotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class PlotServiceImpl implements PlotService {
    private final PlotRepository plotRepository;
    private final ModelMapper modelMapper;
    private final ResponseUtilModelMapper responseUtilModelMapper;

    @Override
    public GenericResponse<Plot> addPlot(PlotRequestDTO request) {
        Plot plot = modelMapper.map(request, Plot.class);
        plot.setAgriculturalCropTypeEnum(request.getCropType());
        plotRepository.save(plot);
        return ResponseUtil.generateResponse(plot, "Plot successfully created", HttpStatus.CREATED);
    }

    @Override
    public GenericResponse<List<Plot>> fetchAll(QueryRequestDTO request) {
        List<Plot> results = plotRepository.findAllPlots(request.getIndex(), request.getLimit());
        return ResponseUtil.generateResponse(results, "Fetch completed", HttpStatus.OK);
    }

    @Override
    public GenericResponse<PlotResponse> editPlot(PlotRequestDTO request, Long plotId) {
        Optional<Plot> optionalPlot = getPlotById(plotId);
        if (optionalPlot.isPresent()) {
            Plot plot = optionalPlot.get();
            modelMapper.map(request, plot);
            plot.setDateModified(LocalDateTime.now());
            plotRepository.save(plot);
            return ResponseUtil.generateResponse(responseUtilModelMapper.mapPlotToPlotResponse(plot), "Record fetched successfully", HttpStatus.OK);
        } else {
            return ResponseUtil.generateResponse(null, "Fetch completed", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public GenericResponse<PlotResponse> fetchById(Long plotId) {
        return getPlotById(plotId)
                .map(plot -> ResponseUtil.generateResponse(responseUtilModelMapper.mapPlotToPlotResponse(plot), "Record fetched successfully", HttpStatus.OK))
                .orElseGet(() -> ResponseUtil.generateResponse(null, "No matching record found", HttpStatus.NOT_FOUND));
    }

    private Optional<Plot> getPlotById(Long plotId) {
        return plotRepository.findById(plotId);
    }
}
