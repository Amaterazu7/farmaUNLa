package com.bd2FarmaUNLa.farmaUNLa.repository;

import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

	Producto findByIdProducto(long idProducto);
}