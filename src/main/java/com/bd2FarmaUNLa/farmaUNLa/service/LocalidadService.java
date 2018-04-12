package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.Localidad;


public interface LocalidadService {
	
	Localidad findById(long id);
	
	void saveLocalidad(Localidad localidad);
	
	void updateLocalidad(Localidad localidad);
	
	void deleteLocalidadById(long id);

	List<Localidad> findAllLocalidades(); 
	
	void deleteAllLocalidades();
	
	public boolean isLocalidadExist(Localidad localidad);
}

