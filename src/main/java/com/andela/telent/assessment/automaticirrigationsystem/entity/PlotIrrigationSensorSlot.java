package com.andela.telent.assessment.automaticirrigationsystem.entity;

import com.andela.telent.assessment.automaticirrigationsystem.config.SlotStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plotIrrigation_sensor_slot")
public class PlotIrrigationSensorSlot {
    @GeneratedValue @Id private Long id;
    @Column(name = "amount_of_water", columnDefinition = "float default 1000")
    private float amountOfWater;

    @Column(columnDefinition = "timestamp not null")
    private LocalDateTime slotStartTime;

    @Column(columnDefinition = "timestamp not null")
    private LocalDateTime slotEndTime;

    @Column(columnDefinition = "timestamp default current_timestamp", nullable = false)
    private LocalDateTime dateCreated;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime dateModified;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(255) default 'PENDING'")
    private SlotStatusEnum slotStatusEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Plot plot;

    @Column(updatable = false)
    private long index;
}
