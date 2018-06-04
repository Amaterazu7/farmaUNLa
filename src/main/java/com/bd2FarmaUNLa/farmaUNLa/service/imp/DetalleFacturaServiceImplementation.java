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
	public List<DetalleFactura> findAllCadenasDetallesFacturas() {
		return (List<DetalleFactura>) detalleFacturaRepository.findAllCadenaDetalleFacturas();
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

}
