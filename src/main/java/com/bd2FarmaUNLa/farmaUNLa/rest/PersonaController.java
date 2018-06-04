package com.bd2FarmaUNLa.farmaUNLa.rest;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bd2FarmaUNLa.farmaUNLa.model.Persona;
import com.bd2FarmaUNLa.farmaUNLa.model.Localidad;
import com.bd2FarmaUNLa.farmaUNLa.model.Persona;
import com.bd2FarmaUNLa.farmaUNLa.model.Sucursal;
import com.bd2FarmaUNLa.farmaUNLa.service.PersonaService;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@RestController
public class PersonaController {

	  	@Autowired
	  	PersonaService personaService; 
	 
	
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/persona/", method = RequestMethod.GET)
	    public ResponseEntity<List<Persona>> listAllPersonas() {
	        List<Persona> personas = personaService.findAllPersonas();
	        if(personas.isEmpty()){
	            return new ResponseEntity<List<Persona>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single --------------------------------------------------------
	     
	    @RequestMapping(value = "/persona/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Persona> getPersona(@PathVariable("id") long id) {
	        System.out.println("Fetching Persona with id " + id);
	        Persona persona = personaService.findById(id);
	        if (persona == null) {
	            System.out.println("Persona with id " + id + " not found");
	            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create--------------------------------------------------------
	     
	    @RequestMapping(value = "/persona/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createPersona(@RequestBody Persona persona,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Persona " + persona.getNombre());
	 
	        if (personaService.isPersonaExist(persona)) {
	            System.out.println("A Persona with name " + persona.getNombre() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        personaService.savePersona(persona);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/persona/{id}").buildAndExpand(persona.getIdPersona()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update --------------------------------------------------------
	     
	    @RequestMapping(value = "/persona/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Persona> updatePersona(@PathVariable("id") long id, @RequestBody Persona persona) {
	        System.out.println("Updating Persona " + id);
	         
	        Persona currentPersona = personaService.findById(id);
	         
	        if (currentPersona==null) {
	            System.out.println("Persona with id " + id + " not found");
	            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
	        }
	 

	        
	        currentPersona.setDni(persona.getDni());
	        currentPersona.setNumAfiliado(persona.getNumAfiliado());
	        currentPersona.setApellido(persona.getApellido());
	        currentPersona.setNombre(persona.getNombre());
	        currentPersona.setCalle(persona.getCalle());
	        currentPersona.setNumero(persona.getNumero());
	        currentPersona.setLocalidad(persona.getLocalidad());
	        currentPersona.setObraSocial(persona.getObraSocial());
	        
	        
	        personaService.updatePersona(currentPersona);
	        return new ResponseEntity<Persona>(currentPersona, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete  --------------------------------------------------------
	     
	    @RequestMapping(value = "/persona/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Persona> deletePersona(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Persona with id " + id);
	 
	        Persona persona = personaService.findById(id);
	        if (persona == null) {
	            System.out.println("Unable to delete. Persona with id " + id + " not found");
	            return new ResponseEntity<Persona>(HttpStatus.NOT_FOUND);
	        }
	 
	       personaService.deletePersonaById(id);;
	        return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All--------------------------------------------------------
	     
	    @RequestMapping(value = "/persona/", method = RequestMethod.DELETE)
	    public ResponseEntity<Persona> deleteAllPersonaes() {
	        System.out.println("Deleting All Personas");
	 
	        personaService.deleteAllPersonas();
	        return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
	    }
}