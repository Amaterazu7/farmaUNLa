package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.FormaDePago;
import com.bd2FarmaUNLa.farmaUNLa.repository.FormaDePagoRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.FormaDePagoService;


@Service("formaDePagoService")
@Transactional
public class FormaDePagoServiceImplementation implements FormaDePagoService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<FormaDePago> formaDePagos;
	
	@Autowired
	private FormaDePagoRepository formaDePagoRepository;
	
	public List<FormaDePago> findAllFormasDePago() {
		return (List<FormaDePago>) formaDePagoRepository.findAll();
	}
		
	@Override
	public FormaDePago findById(long idFormaDePago) {
		return formaDePagoRepository.findByIdFormaDePago(idFormaDePago);
	}

	@Override
	public void saveFormaDePago(FormaDePago formaDePago) {
		formaDePagoRepository.save(formaDePago);
	}

	@Override
	public void updateFormaDePago(FormaDePago formaDePago) {
		formaDePagoRepository.save(formaDePago);
	}

	@Override
	public void deleteFormaDePagoById(long id) {
		formaDePagoRepository.deleteById(id);
	}

	@Override
	public boolean isFormaDePagoExist(FormaDePago formaDePago) {
		return findById(formaDePago.getIdFormaDePago())!=null;
	}
	
	@Override
	public void deleteAllFormasDePago() {
		formaDePagoRepository.deleteAll();
	}

}
