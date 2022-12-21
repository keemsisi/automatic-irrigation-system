package com.andela.telent.assessment.automaticirrigationsystem.repository;

import com.andela.telent.assessment.automaticirrigationsystem.entity.PlotIrrigationSensorSlot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IrrigationSensorSlotRepository extends CrudRepository<PlotIrrigationSensorSlot,Long> {
    @Query(value = "SELECT p.* FROM plot_irrigation_sensor_slot p WHERE p.index < ?1 ORDER BY p.index DESC LIMIT ?2", nativeQuery = true)
    List<PlotIrrigationSensorSlot> findAllSensorSlots(long limit, long index, String name);
}
