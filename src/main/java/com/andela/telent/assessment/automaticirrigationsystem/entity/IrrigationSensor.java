package com.andela.telent.assessment.automaticirrigationsystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "irrigation_sensor")
public class IrrigationSensor implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO) @Id
    private long id;

    @Column(nullable = false, columnDefinition = "varchar(2500)")
    private String sensorApiUrl;

    @Column(nullable = false, unique = true)
    private Long plotId;

    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime dateCreated;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime dateModified;

    @Transient
    @JsonIgnore
    private long index;

    @PrePersist
    void onCreate() {
        if (ObjectUtils.isEmpty(dateCreated))
            dateCreated = LocalDateTime.now();
    }
}
