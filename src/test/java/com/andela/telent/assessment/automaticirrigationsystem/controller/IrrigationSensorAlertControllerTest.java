package com.andela.telent.assessment.automaticirrigationsystem.controller;

import com.andela.telent.assessment.automaticirrigationsystem.dto.request.IrrigationSensorSlotRequest;
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
public class IrrigationSensorAlertControllerTest {
    @Autowired
    private IrrigationSensorAlertController alertController;

    @Test
    void testFetchAllIrrigationSensorAlerts() throws Exception {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.get("/api/v1/plot/irrigation/sensor/alert/fetch-all");
        MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON)
                .param("limit","100")
                .param("index","10");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.alertController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
    }
}
