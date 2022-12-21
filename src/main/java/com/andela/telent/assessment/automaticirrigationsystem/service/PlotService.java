package com.andela.telent.assessment.automaticirrigationsystem.service;

import com.andela.telent.assessment.automaticirrigationsystem.dto.request.PlotRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
import com.andela.telent.assessment.automaticirrigationsystem.dto.response.GenericResponse;
import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;

import java.util.List;

public interface PlotService {
    GenericResponse<Plot> addPlot(PlotRequestDTO request);

    GenericResponse<List<Plot>> fetchAll(QueryRequestDTO request);

    GenericResponse<Plot> editPlot(PlotRequestDTO request, Long plotId);

    GenericResponse<Plot> fetchById(Long plotId);
}
