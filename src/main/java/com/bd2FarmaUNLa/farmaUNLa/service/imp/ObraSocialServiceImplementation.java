package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.ObraSocial;
import com.bd2FarmaUNLa.farmaUNLa.repository.ObraSocialRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.ObraSocialService;


@Service("obraSocialService")
@Transactional
public class ObraSocialServiceImplementation implements ObraSocialService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<ObraSocial> obraSociales;
	
	@Autowired
	private ObraSocialRepository obraSocialRepository;
	
	public List<ObraSocial> findAllObraSociales() {
		return (List<ObraSocial>) obraSocialRepository.findAll();
	}
		
	@Override
	public ObraSocial findById(long id) {
		return obraSocialRepository.findById(id);
	}

	@Override
	public void saveObraSocial(ObraSocial obraSocial) {
		obraSocialRepository.save(obraSocial);
	}

	@Override
	public void updateObraSocial(ObraSocial obraSocial) {
		obraSocialRepository.save(obraSocial);
	}

	@Override
	public void deleteObraSocial(long id) {
		obraSocialRepository.deleteById(id);
	}

	@Override
	public boolean isObraSocialExist(ObraSocial obraSocial) {
		return findById(obraSocial.getId())!=null;
	}
	
	@Override
	public void deleteAllObraSociales() {
		obraSocialRepository.deleteAll();
	}

}
