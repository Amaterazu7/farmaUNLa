package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.Sucursal;


public interface SucursalService {
	
	Sucursal findById(long id);
	
	void saveSucursal(Sucursal sucursal);
	
	void updateSucursal(Sucursal sucursal);
	
	void deleteSucursalById(long id);

	List<Sucursal> findAllSucursales(); 
	
	void deleteAllSucursales();
	
	public boolean isSucursalExist(Sucursal sucursal);
}

