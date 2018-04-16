package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.Localidad;
import com.bd2FarmaUNLa.farmaUNLa.repository.LocalidadRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.LocalidadService;


@Service("localidadService")
@Transactional
public class LocalidadServiceImplementation implements LocalidadService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Localidad> localidades;
	
	@Autowired
	private LocalidadRepository localidadRepository;
	
	public List<Localidad> findAllLocalidades() {
		return (List<Localidad>) localidadRepository.findAll();
	}
		
	@Override
	public Localidad findById(long idLocalidad) {
		return localidadRepository.findByIdLocalidad(idLocalidad);
	}

	@Override
	public void saveLocalidad(Localidad localidad) {
		localidadRepository.save(localidad);
	}

	@Override
	public void updateLocalidad(Localidad localidad) {
		localidadRepository.save(localidad);
	}

	@Override
	public void deleteLocalidadById(long id) {
		localidadRepository.deleteById(id);
	}

	@Override
	public boolean isLocalidadExist(Localidad localidad) {
		return findById(localidad.getIdLocalidad())!=null;
	}
	
	@Override
	public void deleteAllLocalidades() {
		localidadRepository.deleteAll();
	}

}
