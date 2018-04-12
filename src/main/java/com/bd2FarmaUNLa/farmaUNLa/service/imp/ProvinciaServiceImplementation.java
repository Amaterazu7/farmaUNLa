package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.Provincia;
import com.bd2FarmaUNLa.farmaUNLa.repository.ProvinciaRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.ProvinciaService;


@Service("provinciaService")
@Transactional
public class ProvinciaServiceImplementation implements ProvinciaService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Provincia> provincias;
	
	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	public List<Provincia> findAllProvincias() {
		return (List<Provincia>) provinciaRepository.findAll();
	}
		
	@Override
	public Provincia findById(long id) {
		return provinciaRepository.findById(id);
	}

	@Override
	public void saveProvincia(Provincia provincia) {
		provinciaRepository.save(provincia);
	}

	@Override
	public void updateProvincia(Provincia provincia) {
		provinciaRepository.save(provincia);
	}

	@Override
	public void deleteProvinciaById(long id) {
		provinciaRepository.deleteById(id);
	}

	@Override
	public boolean isProvinciaExist(Provincia provincia) {
		return findById(provincia.getId())!=null;
	}
	
	@Override
	public void deleteAllProvincias() {
		provinciaRepository.deleteAll();
	}

}
