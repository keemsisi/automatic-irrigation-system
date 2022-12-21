package com.andela.telent.assessment.automaticirrigationsystem.config;

import com.andela.telent.assessment.automaticirrigationsystem.dto.SwaggerProperties;
import lombok.AllArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BeanConfig {
    @Bean
    @ConfigurationProperties(prefix = "swagger")
    public SwaggerProperties swaggerProperties() {
        return new SwaggerProperties();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setPropertyCondition(Conditions.isNotNull())
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}

