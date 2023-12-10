package com.github.guilhermevictorlima.hotelapi.repository;

import com.github.guilhermevictorlima.hotelapi.model.entity.ComodidadesQuarto;
import com.github.guilhermevictorlima.hotelapi.model.entity.ComodidadesQuarto.PkComodidadesQuarto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComodidadesQuartoRepository extends CrudRepository<ComodidadesQuarto, PkComodidadesQuarto> {
}
