package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.Persona;


public interface PersonaService {
	
	Persona findById(long id);
	
	Persona findByDni(int dni);
	
	void savePersona(Persona persona);
	
	void updatePersona(Persona persona);
	
	void deletePersonaById(long id);

	List<Persona> findAllPersonas(); 
	
	void deleteAllPersonas();
	
	public boolean isPersonaExist(Persona persona);
}

