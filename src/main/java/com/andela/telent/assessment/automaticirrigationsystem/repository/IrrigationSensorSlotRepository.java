package com.andela.telent.assessment.automaticirrigationsystem.repository;

import com.andela.telent.assessment.automaticirrigationsystem.entity.PlotIrrigationSensorSlot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrrigationSensorSlotRepository extends CrudRepository<PlotIrrigationSensorSlot,Long> {
}
