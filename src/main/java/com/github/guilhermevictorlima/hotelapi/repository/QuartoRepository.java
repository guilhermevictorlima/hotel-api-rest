package com.github.guilhermevictorlima.hotelapi.repository;

import com.github.guilhermevictorlima.hotelapi.model.entity.Quarto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends CrudRepository<Quarto, Long> {
}
