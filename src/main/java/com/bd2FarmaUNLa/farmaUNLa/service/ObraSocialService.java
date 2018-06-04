package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.ObraSocial;


public interface ObraSocialService {
	
	ObraSocial findByIdObraSocial(long id);
	
	void saveObraSocial(ObraSocial obraSocial);
	
	void updateObraSocial(ObraSocial obraSocial);
	
	void deleteObraSocial(long id);

	List<ObraSocial> findAllObraSociales(); 
	
	void deleteAllObraSociales();
	
	public boolean isObraSocialExist(ObraSocial obraSocial);
}

