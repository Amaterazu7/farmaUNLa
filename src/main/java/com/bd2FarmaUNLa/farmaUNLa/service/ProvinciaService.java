package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.Provincia;


public interface ProvinciaService {
	
	Provincia findById(long id);
	
	void saveProvincia(Provincia provincia);
	
	void updateProvincia(Provincia provincia);
	
	void deleteProvinciaById(long id);

	List<Provincia> findAllProvincias(); 
	
	void deleteAllProvincias();
	
	public boolean isProvinciaExist(Provincia provincia);
}

