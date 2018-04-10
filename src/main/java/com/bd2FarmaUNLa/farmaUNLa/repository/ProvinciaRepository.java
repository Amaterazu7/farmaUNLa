package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.Provincia;

public interface ProvinciaRepository extends CrudRepository<Provincia, Long> {

	Provincia findById(long id);
}