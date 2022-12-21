package com.andela.telent.assessment.automaticirrigationsystem.repository;

import com.andela.telent.assessment.automaticirrigationsystem.entity.Plot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlotRepository extends CrudRepository<Plot, Long> {
    @Query(value = "SELECT p.* FROM plot p WHERE p.index < ?1 ORDER BY p.index DESC LIMIT ?2", nativeQuery = true)
    List<Plot> findAllPlots(long index, long limit);

    @Query(value = "SELECT p FROM Plot p WHERE p.id=:id")
    Optional<Plot> findById(long id);
}
