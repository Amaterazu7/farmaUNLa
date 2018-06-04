package com.bd2FarmaUNLa.farmaUNLa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.DetalleFactura;
import com.bd2FarmaUNLa.farmaUNLa.model.Persona;

public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, Long> {

	@Query("select df from DetalleFactura df where df.idDetalleFactura = '1'")
	List<DetalleFactura> findAllCadenaDetalleFacturas();
	
	DetalleFactura findById(long id);
}