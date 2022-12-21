package com.andela.telent.assessment.automaticirrigationsystem.repository;

import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrrigationSensorRepository extends CrudRepository<IrrigationSensor, Long> {
    @Query(value = "SELECT irs.* FROM irrigation_sensor irs INNER JOIN plot p on p.id=:plotId", nativeQuery = true)
    IrrigationSensor findByPlotId(Long plotId);
}
