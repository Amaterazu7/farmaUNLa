package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.TipoProducto;


public interface TipoProductoService {
	
	TipoProducto findById(long id);
	
	void saveTipoProducto(TipoProducto tipoProducto);
	
	void updateTipoProducto(TipoProducto tipoProducto);
	
	void deleteTipoProductoById(long id);

	List<TipoProducto> findAllTiposProductos(); 
	
	void deleteAllTiposProductos();
	
	public boolean isTipoProductoExist(TipoProducto tipoProducto);
}

