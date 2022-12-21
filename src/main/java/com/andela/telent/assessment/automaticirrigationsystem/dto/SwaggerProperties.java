package com.andela.telent.assessment.automaticirrigationsystem.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;


@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {
    private boolean enable;
    private String applicationName;
    private String applicationDescription;
    private String applicationVersion;
}
