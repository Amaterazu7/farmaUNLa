package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.Localidad;

public interface LocalidadRepository extends CrudRepository<Localidad, Long> {

	Localidad findByIdLocalidad(long idLocalidad);
}