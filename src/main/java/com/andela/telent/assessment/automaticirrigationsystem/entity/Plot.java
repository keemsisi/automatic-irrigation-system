package com.andela.telent.assessment.automaticirrigationsystem.entity;

import com.andela.telent.assessment.automaticirrigationsystem.common.enums.AgriculturalCropTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Column(unique = true)
    private Long irrigationSensorId;

    @Column(columnDefinition = "timestamp default current_timestamp not null")
    private LocalDateTime dateCreated;

    @Column(columnDefinition = "timestamp")
    private LocalDateTime dateModified;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255)")
    private AgriculturalCropTypeEnum agriculturalCropTypeEnum;

    @Transient
    private long index;

    @PrePersist
    void onCreate() {
        if (ObjectUtils.isEmpty(dateCreated))
            dateCreated = LocalDateTime.now();
    }
}