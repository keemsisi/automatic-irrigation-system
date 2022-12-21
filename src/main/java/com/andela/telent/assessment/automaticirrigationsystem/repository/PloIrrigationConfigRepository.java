package com.andela.telent.assessment.automaticirrigationsystem.repository;

import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PloIrrigationConfigRepository extends CrudRepository<Plot,Long> {
}
