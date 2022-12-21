package com.andela.telent.assessment.automaticirrigationsystem.controller;

import com.andela.telent.assessment.automaticirrigationsystem.dto.request.PlotRequestDTO;
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
public class PlotControllerTest {
    @Autowired
    private PlotController plotController;

    @Test
    void testCreatePlot() throws Exception {
        PlotRequestDTO plotRequestDTO = new PlotRequestDTO();
        plotRequestDTO.setBredth(100);
        plotRequestDTO.setLength(100);
        plotRequestDTO.setName("Testing Plot Name");
        plotRequestDTO.setDescription("Just describing the plot of land");
        String content = (new ObjectMapper()).writeValueAsString(plotRequestDTO);
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.post("/api/v1/plot");
        MockHttpServletRequestBuilder requestBuilder = putResult.param("jwt", String.valueOf((Object) null))
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.plotController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(201));
    }

    @Test
    void testFetchPlotByIdNotFound() throws Exception {
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.get("/api/v1/plot/fetch/{plotId}", "1");
        MockHttpServletRequestBuilder requestBuilder = putResult.param("jwt", String.valueOf((Object) null))
                .contentType(MediaType.APPLICATION_JSON);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.plotController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(404));
    }

    @Test
    void testFetchPlotByIdFound() throws Exception {
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.get("/api/v1/plot/fetch/{plotId}", "24");
        MockHttpServletRequestBuilder requestBuilder = putResult.param("jwt", String.valueOf((Object) null))
                .contentType(MediaType.APPLICATION_JSON);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.plotController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
    }
}
