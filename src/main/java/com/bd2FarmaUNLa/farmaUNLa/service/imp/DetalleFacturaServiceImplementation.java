package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.DetalleFactura;
import com.bd2FarmaUNLa.farmaUNLa.repository.DetalleFacturaRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.DetalleFacturaService;


@Service("detalleFacturaService")
@Transactional
public class DetalleFacturaServiceImplementation implements DetalleFacturaService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<DetalleFactura> detalleFacturas;
	
	@Autowired
	private DetalleFacturaRepository detalleFacturaRepository;
	
	public List<DetalleFactura> findAllDetallesFacturas() {
		return (List<DetalleFactura>) detalleFacturaRepository.findAll();
	}
		
	@Override
	public DetalleFactura findById(long id) {
		return detalleFacturaRepository.findById(id);
	}

	@Override
	public void saveDetalleFactura(DetalleFactura detalleFactura) {
		detalleFacturaRepository.save(detalleFactura);
	}

	@Override
	public void updateDetalleFactura(DetalleFactura detalleFactura) {
		detalleFacturaRepository.save(detalleFactura);
	}

	@Override
	public void deleteDetalleFacturaById(long id) {
		detalleFacturaRepository.deleteById(id);
	}

	@Override
	public boolean isDetalleFacturaExist(DetalleFactura detalleFactura) {
		return findById(detalleFactura.getIdDetalleFactura())!=null;
	}
	
	@Override
	public void deleteAllDetallesFacturas() {
		detalleFacturaRepository.deleteAll();
	}
	/*
	@Override
	public List<DetalleFactura> findAllCadenasDetallesFacturas() {
		return (List<DetalleFactura>) detalleFacturaRepository.findAllCadenaDetalleFacturas();
	}
	*/
	
	@Override
	public List<DetalleFactura> totalVentaCadena() {
		return (List<DetalleFactura>) detalleFacturaRepository.totalVentaCadena();
	}
	
	@Override
	public List<DetalleFactura> totalVentaSucursal() {
		return (List<DetalleFactura>) detalleFacturaRepository.totalVentaSucursal();
	}
	
	@Override
	public List<DetalleFactura> totalVentaCadenaObrasocial() {
		return (List<DetalleFactura>) detalleFacturaRepository.totalVentaCadenaObrasocial();
	}
	
	@Override
	public List<DetalleFactura> totalVentaSucursalObrasocial() {
		return (List<DetalleFactura>) detalleFacturaRepository.totalVentaSucursalObrasocial();
	}
	
	@Override
	public List<DetalleFactura> totalCobranzaMPCadena() {
		return (List<DetalleFactura>) detalleFacturaRepository.totalCobranzaMPCadena();
	}
	
	@Override
	public List<DetalleFactura> totalVentaProductoCadena() {
		return (List<DetalleFactura>) detalleFacturaRepository.totalVentaProductoCadena();
	}
	
	@Override
	public List<DetalleFactura> totalVentaProductoSucursal() {
		return (List<DetalleFactura>) detalleFacturaRepository.totalVentaProductoSucursal();
	}
	
	@Override
	public List<DetalleFactura> rankingVentaCadenaMonto() {
		return (List<DetalleFactura>) detalleFacturaRepository.rankingVentaCadenaMonto();
	}
	
	@Override
	public List<DetalleFactura> rankingVentaSucursalMonto() {
		return (List<DetalleFactura>) detalleFacturaRepository.rankingVentaSucursalMonto();
	}
	
	@Override
	public List<DetalleFactura> rankingVentaCadenaCant() {
		return (List<DetalleFactura>) detalleFacturaRepository.rankingVentaCadenaCant();
	}
	
	@Override
	public List<DetalleFactura> rankingVentaSucursalCant() {
		return (List<DetalleFactura>) detalleFacturaRepository.rankingVentaSucursalCant();
	}
	
	@Override
	public List<DetalleFactura> rankingClienteCadenaMonto() {
		return (List<DetalleFactura>) detalleFacturaRepository.rankingClienteCadenaMonto();
	}
	
	@Override
	public List<DetalleFactura> rankingClienteSucursalMonto() {
		return (List<DetalleFactura>) detalleFacturaRepository.rankingClienteSucursalMonto();
	}
	
	@Override
	public List<DetalleFactura> rankingClienteCadenaCant() {
		return (List<DetalleFactura>) detalleFacturaRepository.rankingClienteCadenaCant();
	}

	@Override
	public List<DetalleFactura> rankingClienteSucursalCant() {
		return (List<DetalleFactura>) detalleFacturaRepository.rankingClienteSucursalCant();
	}
	

}
