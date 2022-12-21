package com.andela.telent.assessment.automaticirrigationsystem.repository;

import com.andela.telent.assessment.automaticirrigationsystem.entity.IrrigationSensorAlert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IrrigationSensorAlertRepository extends CrudRepository<IrrigationSensorAlert, Long> {
    @Query(value = "SELECT p FROM IrrigationSensorAlert ira WHERE ira.index < :index ORDER BY index :order LIMIT :limit",nativeQuery = true)
    List<IrrigationSensorAlert> findAllAlerts(long limit, long index, String order);
}
