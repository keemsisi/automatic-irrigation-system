package com.andela.telent.assessment.automaticirrigationsystem.controller;


import com.andela.telent.assessment.automaticirrigationsystem.dto.request.IrrigationSensorSlotRequest;
import com.andela.telent.assessment.automaticirrigationsystem.dto.request.QueryRequestDTO;
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

import java.time.LocalDateTime;

@SpringBootTest
public class PlotIrrigationSensorSlotControllerTest {
    @Autowired
    private PlotIrrigationSensorSlotController plotIrrigationSensorSlotController;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateSensorSlotForNonExistingPlot() throws Exception {
        IrrigationSensorSlotRequest irrigationSensorSlotRequest = new IrrigationSensorSlotRequest();
        irrigationSensorSlotRequest.setPlotId(2400L);
        irrigationSensorSlotRequest.setAmountOfWater(1000D);
        irrigationSensorSlotRequest.setSlotEndTime(LocalDateTime.now());
        irrigationSensorSlotRequest.setSlotStartTime(LocalDateTime.now());
        String content = (objectMapper).writeValueAsString(irrigationSensorSlotRequest);
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/v1/plot/irrigation/sensor/slot");
        MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.plotIrrigationSensorSlotController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}
