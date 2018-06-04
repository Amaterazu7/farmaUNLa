package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.DetalleFactura;


public interface DetalleFacturaService {
	
	DetalleFactura findById(long id);
	
	void saveDetalleFactura(DetalleFactura detalleFactura);
	
	void updateDetalleFactura(DetalleFactura detalleFactura);
	
	void deleteDetalleFacturaById(long id);

	List<DetalleFactura> findAllDetallesFacturas(); 
	
	List<DetalleFactura> findAllCadenasDetallesFacturas();
	
	void deleteAllDetallesFacturas();
	
	public boolean isDetalleFacturaExist(DetalleFactura detalleFactura);
}

