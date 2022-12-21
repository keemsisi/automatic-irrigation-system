package com.andela.telent.assessment.automaticirrigationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Irrigation_sensor_alert")
public class IrrigationSensorAlert {
    private final Long serialVersionId = 1L;
    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private IrrigationSensor irrigationSensor;

    @Column(columnDefinition = "varchar(2500)")
    private String description;

    @Column(columnDefinition = "timestamp default current_timestamp not null")
    private LocalDateTime dateCreated;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime dateModified;

    @Column(updatable = false)
    private long index;
}
