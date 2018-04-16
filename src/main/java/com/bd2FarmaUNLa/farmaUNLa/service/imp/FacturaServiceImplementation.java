package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.Factura;
import com.bd2FarmaUNLa.farmaUNLa.repository.FacturaRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.FacturaService;


@Service("facturaService")
@Transactional
public class FacturaServiceImplementation implements FacturaService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Factura> facturas;
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	public List<Factura> findAllFacturas() {
		return (List<Factura>) facturaRepository.findAll();
	}
		
	@Override
	public Factura findById(long idFactura) {
		return facturaRepository.findByIdFactura(idFactura);
	}

	@Override
	public void saveFactura(Factura factura) {
		facturaRepository.save(factura);
	}

	@Override
	public void updateFactura(Factura factura) {
		facturaRepository.save(factura);
	}

	@Override
	public void deleteFacturaById(long id) {
		facturaRepository.deleteById(id);
	}

	@Override
	public boolean isFacturaExist(Factura factura) {
		return findById(factura.getIdFactura())!=null;
	}
	
	@Override
	public void deleteAllFacturas() {
		facturaRepository.deleteAll();
	}

}
