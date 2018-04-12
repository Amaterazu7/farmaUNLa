package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.TipoProducto;

public interface TipoProductoRepository extends CrudRepository<TipoProducto, Long> {

	TipoProducto findById(long id);
}