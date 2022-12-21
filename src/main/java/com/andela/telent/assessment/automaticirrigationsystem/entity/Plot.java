package com.andela.telent.assessment.automaticirrigationsystem.entity;

import com.andela.telent.assessment.automaticirrigationsystem.common.enums.AgriculturalCropTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plot")
public class Plot {
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "plot")
    private IrrigationSensor irrigationSensor;

    @Column(columnDefinition = "timestamp default current_timestamp not null")
    private LocalDateTime dateCreated;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime dateModified;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "plot")
    private Set<PlotIrrigationSensorSlot> plotIrrigationSensorSlot;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private AgriculturalCropTypeEnum agriculturalCropTypeEnum;

    @Column(updatable = false)
    private long index;
}