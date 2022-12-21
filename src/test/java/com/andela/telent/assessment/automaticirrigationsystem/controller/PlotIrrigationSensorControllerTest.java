package com.andela.telent.assessment.automaticirrigationsystem.controller;


import com.andela.telent.assessment.automaticirrigationsystem.dto.request.PlotIrrigationConfigRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class PlotIrrigationSensorControllerTest {
    @Autowired
    private PlotIrrigationSensorController plotIrrigationSensorController;

    @Test
    void testCreateSensorForNonExistingPlot() throws Exception {
        PlotIrrigationConfigRequestDTO plotRequestDTO = new PlotIrrigationConfigRequestDTO();
        plotRequestDTO.setPlotId(2400L);
        plotRequestDTO.setSensorBaseApi("https://googlecloud.tester.config.net");
        String content = (new ObjectMapper()).writeValueAsString(plotRequestDTO);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/v1/plot/irrigation/sensor/configure");
        MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.plotIrrigationSensorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}