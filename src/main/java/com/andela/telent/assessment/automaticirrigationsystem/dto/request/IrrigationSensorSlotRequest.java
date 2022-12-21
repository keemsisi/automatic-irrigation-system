package com.andela.telent.assessment.automaticirrigationsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IrrigationSensorSlotRequest {
    @NotNull(message = "plotId can not be null")
    private Long plotId;
    @NotNull(message = "Kindly provide amountOfWater(in Ltrs) to irrigate your plot of land")
    private Double amountOfWater;
    @NotNull(message = "startSlotDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime slotStartTime;
    @NotNull(message = "endSlotDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime slotEndTime;
}
