package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long> {

	Factura findByIdFactura(long idFactura);
}