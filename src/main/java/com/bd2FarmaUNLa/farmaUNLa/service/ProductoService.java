package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.Producto;


public interface ProductoService {
	
	Producto findById(long id);
	
	void saveProducto(Producto producto);
	
	void updateProducto(Producto producto);
	
	void deleteProductoById(long id);

	List<Producto> findAllProductos(); 
	
	void deleteAllProductos();
	
	public boolean isProductoExist(Producto producto);
}

