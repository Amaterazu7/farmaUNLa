package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.FormaDePago;


public interface FormaDePagoService {
	
	FormaDePago findById(long id);
	
	void saveFormaDePago(FormaDePago formaDePago);
	
	void updateFormaDePago(FormaDePago formaDePago);
	
	void deleteFormaDePagoById(long id);

	List<FormaDePago> findAllFormasDePago(); 
	
	void deleteAllFormasDePago();
	
	public boolean isFormaDePagoExist(FormaDePago formaDePago);
}

