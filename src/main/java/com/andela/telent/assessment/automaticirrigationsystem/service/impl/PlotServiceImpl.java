package com.andela.telent.assessment.automaticirrigationsystem.service.impl;

import com.andela.telent.assessment.automaticirrigationsystem.common.enums.ResponseUtil;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.PlotRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import com.andela.telent.assessment.automaticirrigationsystem.repository.PlotRepository;
import com.andela.telent.assessment.automaticirrigationsystem.service.PlotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class PlotServiceImpl implements PlotService {
    private final PlotRepository plotRepository;
    private final ModelMapper modelMapper;

    @Override
    public GenericResponse<Plot> addPlot(PlotRequestDTO request) {
        Plot plot = modelMapper.map(request, Plot.class);
        plotRepository.save(plot);
        return ResponseUtil.generateResponse(plot, "Plot successfully created", HttpStatus.CREATED);
    }

    @Override
    public GenericResponse<List<Plot>> fetchAll(QueryRequestDTO request) {
        List<Plot> results = plotRepository.findAllPlots(request.getIndex(), request.getLimit(), request.getOrder().name());
        return ResponseUtil.generateResponse(results, "Fetch completed", HttpStatus.CREATED);
    }

    @Override
    public GenericResponse<Plot> editPlot(PlotRequestDTO request, Long plotId) {
        Optional<Plot> optionalPlot = getPlotById(plotId);
        if (optionalPlot.isPresent()) {
            Plot plot = optionalPlot.get();
            modelMapper.map(request, plot);
            plotRepository.save(plot);
            return ResponseUtil.generateResponse(plot, "Plot Updated successfully", HttpStatus.OK);
        } else {
            return ResponseUtil.generateResponse(null, "Fetch completed", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public GenericResponse<Plot> fetchById(Long plotId) {
        return getPlotById(plotId).map(plot -> ResponseUtil.generateResponse(plot, "Plot fetched successfully", HttpStatus.OK))
                .orElseGet(() -> ResponseUtil.generateResponse(null, "No matching record found", HttpStatus.NOT_FOUND));
    }

    private Optional<Plot> getPlotById(Long plotId) {
        return plotRepository.findById(plotId);
    }
}
