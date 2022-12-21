package com.andela.telent.assessment.automaticirrigationsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Irrigation_sensor_alert")
public class IrrigationSensorAlert {
    @GeneratedValue
    @Id
    private Long id;

    @Column()
    private Long irrigationSensorId;

    @Column(columnDefinition = "varchar(2500)")
    private String description;

    @Column(columnDefinition = "timestamp default current_timestamp not null")
    private LocalDateTime dateCreated;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime dateModified;

    @Transient
    private long index;

    @PrePersist
    void onCreate() {
        if (ObjectUtils.isEmpty(dateCreated))
            dateCreated = LocalDateTime.now();
    }
}
