package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.DetalleFactura;


public interface DetalleFacturaService {
	
	DetalleFactura findById(long id);
	
	void saveDetalleFactura(DetalleFactura detalleFactura);
	
	void updateDetalleFactura(DetalleFactura detalleFactura);
	
	void deleteDetalleFacturaById(long id);

	List<DetalleFactura> findAllDetallesFacturas(); 
	
	void deleteAllDetallesFacturas();
	
	public boolean isDetalleFacturaExist(DetalleFactura detalleFactura);
	
	/*
	List<DetalleFactura> findAllCadenasDetallesFacturas();
	*/
	
	List<DetalleFactura> totalVentaCadena();

	List<DetalleFactura> totalVentaSucursal();
	
	List<DetalleFactura> totalVentaCadenaObrasocial();
	
	List<DetalleFactura> totalVentaSucursalObrasocial();
	
	List<DetalleFactura> totalCobranzaMPCadena();
	
	List<DetalleFactura> totalCobranzaMPSucursal();
	
	List<DetalleFactura> totalVentaProductoCadena();
	
	List<DetalleFactura> totalVentaProductoSucursal();
	
	List<DetalleFactura> rankingVentaCadenaMonto();
	
	List<DetalleFactura> rankingVentaSucursalMonto();
	
	List<DetalleFactura> rankingVentaCadenaCant();
	
	List<DetalleFactura> rankingVentaSucursalCant();
	
	List<DetalleFactura> rankingClienteCadenaMonto();
	
	List<DetalleFactura> rankingClienteSucursalMonto();
	
	List<DetalleFactura> rankingClienteCadenaCant();
	
	List<DetalleFactura> rankingClienteSucursalCant();
}

