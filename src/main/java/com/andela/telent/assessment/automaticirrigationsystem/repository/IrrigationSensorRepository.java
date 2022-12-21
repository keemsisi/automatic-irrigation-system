package com.andela.telent.assessment.automaticirrigationsystem.repository;

import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrrigationSensorRepository extends CrudRepository<IrrigationSensor, Long> {
    @Query(value = "SELECT irs FROM IrrigationSensor irs WHERE irs.plot.id=:plotId")
    IrrigationSensor findByPlotId(Long plotId);
}
