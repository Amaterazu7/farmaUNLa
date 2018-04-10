package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.Sucursal;

public interface SucursalRepository extends CrudRepository<Sucursal, Long> {

	Sucursal findById(long id);
}