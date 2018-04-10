package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.FormaDePago;

public interface FormaDePagoRepository extends CrudRepository<FormaDePago, Long> {

	FormaDePago findById(long id);
}