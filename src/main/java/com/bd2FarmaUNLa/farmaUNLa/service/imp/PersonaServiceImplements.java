package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.Persona;
import com.bd2FarmaUNLa.farmaUNLa.repository.PersonaRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.PersonaService;


@Service("personaService")
@Transactional
public class PersonaServiceImplements implements PersonaService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Persona> personas;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	public List<Persona> findAllPersonas() {
		return (List<Persona>) personaRepository.findAll();
	}
		
	@Override
	public Persona findById(long id) {
		return personaRepository.findById(id);
	}

	@Override
	public Persona findByDni(int dni) {
		return personaRepository.findBydni(dni);
	}

	@Override
	public void savePersona(Persona persona) {
		personaRepository.save(persona);
	}

	@Override
	public void updatePersona(Persona persona) {
		personaRepository.save(persona);
	}

	@Override
	public void deletePersonaById(long id) {
		personaRepository.deleteById(id);
	}

	@Override
	public boolean isPersonaExist(Persona persona) {
		return findByDni(persona.getDni())!=null;
	}
	
	@Override
	public void deleteAllPersonas() {
		personaRepository.deleteAll();
	}

}
