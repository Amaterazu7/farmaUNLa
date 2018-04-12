package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.DetalleFactura;

public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, Long> {

	DetalleFactura findById(long id);
}