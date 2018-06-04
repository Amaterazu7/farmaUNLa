package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.ObraSocial;

public interface ObraSocialRepository extends CrudRepository<ObraSocial, Long> {

	ObraSocial findByIdObraSocial(long idObraSocial);
}