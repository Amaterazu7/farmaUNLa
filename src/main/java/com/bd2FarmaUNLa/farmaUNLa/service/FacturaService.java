package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.Factura;


public interface FacturaService {
	
	Factura findById(long id);
	
	void saveFactura(Factura factura);
	
	void updateFactura(Factura factura);
	
	void deleteFacturaById(long id);

	List<Factura> findAllFacturas(); 
	
	void deleteAllFacturas();
	
	public boolean isFacturaExist(Factura factura);
}

