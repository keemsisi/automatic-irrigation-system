package com.andela.telent.assessment.automaticirrigationsystem.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "irrigation_sensor")
public class IrrigationSensor implements Serializable {
    private final Long serialVersionId = 1L;
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(2500)")
    private String sensorApiUrl;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "irrigationSensor")
    private Plot plot;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "irrigationSensor")
    private List<IrrigationSensorAlert> irrigationSensorAlert;

    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime dateCreated;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime dateModified;

    @Column(updatable = false)
    private long index;
}