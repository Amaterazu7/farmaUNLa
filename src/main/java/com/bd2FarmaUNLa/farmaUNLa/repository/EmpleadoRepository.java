package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

	Empleado findById(long id);
}