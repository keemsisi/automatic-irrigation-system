package com.andela.telent.assessment.automaticirrigationsystem.entity;

import com.andela.telent.assessment.automaticirrigationsystem.config.SlotStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plot_irrigation_sensor_slot")
public class PlotIrrigationSensorSlot {
    @GeneratedValue(strategy = GenerationType.AUTO) @Id
    private long id;
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

    @Column
    private Long plotId;

    @Transient
    @JsonIgnore
    private long index;

    @PrePersist
    void onCreate() {
        if (ObjectUtils.isEmpty(dateCreated))
            dateCreated = LocalDateTime.now();
        if (ObjectUtils.isEmpty(slotStatusEnum))
            slotStatusEnum = SlotStatusEnum.PENDING;
    }
}
