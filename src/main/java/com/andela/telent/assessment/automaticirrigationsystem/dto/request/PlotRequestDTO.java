package com.andela.telent.assessment.automaticirrigationsystem.dto.request;


import com.andela.telent.assessment.automaticirrigationsystem.common.enums.AgriculturalCropTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlotRequestDTO {
    @NotNull(message = "plot name can not be empty")
    private String name;
    @NotNull(message = "Add a little description about the land")
    private String description;
    private AgriculturalCropTypeEnum cropType;
    private float length;
    private float bredth;
}
