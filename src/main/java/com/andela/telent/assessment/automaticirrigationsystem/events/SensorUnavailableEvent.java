package com.andela.telent.assessment.automaticirrigationsystem.events;

import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensor;
import com.andela.telent.assessment.automaticirrigationsystem.entity.PlotIrrigationSensorSlot;
import com.andela.telent.assessment.automaticirrigationsystem.repository.IrrigationSensorRepository;
import com.andela.telent.assessment.automaticirrigationsystem.repository.IrrigationSensorSlotRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
@AllArgsConstructor
public class SensorUnavailableEvent {
    private final IrrigationSensorSlotRepository irrigationSensorSlotRepository;
    private final IrrigationSensorRepository irrigationSensorRepository;

    @Async
    @EventListener(classes = {PlotIrrigationSensorSlot.class})
    @Retryable(value = Exception.class, backoff = @Backoff(delayExpression = "1000"), maxAttempts = 6)
    void handlePlotIrrigationSensorSlotEvent(PlotIrrigationSensorSlot event) {
        IrrigationSensor irrigationSensor = event.getPlot().getIrrigationSensor();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(irrigationSensor.getSensorApiUrl(), event, String.class);
        log.info("----||||Response from Sensor {}||||----", responseEntity);
    }
}
