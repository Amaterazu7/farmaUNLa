package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

	Persona findById(long id);
	
	@Query("SELECT p FROM Persona p")
	Persona findBydni(int dni);
}