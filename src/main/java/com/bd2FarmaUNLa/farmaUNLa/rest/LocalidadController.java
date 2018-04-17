package com.bd2FarmaUNLa.farmaUNLa.rest;

import java.util.List;

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

import com.bd2FarmaUNLa.farmaUNLa.model.Localidad;
import com.bd2FarmaUNLa.farmaUNLa.service.LocalidadService;


@RestController
public class LocalidadController {

	  	@Autowired
	  	LocalidadService localidadService; 
	 
	
	    //-------------------Retrieve All Localidades--------------------------------------------------------
	     
	    @RequestMapping(value = "/localidad/", method = RequestMethod.GET)
	    public ResponseEntity<List<Localidad>> listAllLocalidads() {
	        List<Localidad> localidads = localidadService.findAllLocalidades();
	        if(localidads.isEmpty()){
	            return new ResponseEntity<List<Localidad>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Localidad>>(localidads, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single Localidad--------------------------------------------------------
	     
	    @RequestMapping(value = "/localidad/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Localidad> getLocalidad(@PathVariable("id") long id) {
	        System.out.println("Fetching Localidad with id " + id);
	        Localidad localidad = localidadService.findById(id);
	        if (localidad == null) {
	            System.out.println("Localidad with id " + id + " not found");
	            return new ResponseEntity<Localidad>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Localidad>(localidad, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a Localidad--------------------------------------------------------
	     
	    @RequestMapping(value = "/localidad/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createLocalidad(@RequestBody Localidad localidad,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Localidad " + localidad.getNombre());
	 
	        if (localidadService.isLocalidadExist(localidad)) {
	            System.out.println("A Localidad with name " + localidad.getNombre() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        localidadService.saveLocalidad(localidad);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/localidad/{id}").buildAndExpand(localidad.getIdLocalidad()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update a Localidad --------------------------------------------------------
	     
	    @RequestMapping(value = "/localidad/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Localidad> updateLocalidad(@PathVariable("id") long id, @RequestBody Localidad localidad) {
	        System.out.println("Updating Localidad " + id);
	         
	        Localidad currentLocalidad = localidadService.findById(id);
	         
	        if (currentLocalidad==null) {
	            System.out.println("Localidad with id " + id + " not found");
	            return new ResponseEntity<Localidad>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentLocalidad.setNombre(localidad.getNombre());
	        currentLocalidad.setProvincia(localidad.getProvincia());
	        
	        localidadService.updateLocalidad(currentLocalidad);
	        return new ResponseEntity<Localidad>(currentLocalidad, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a Localidad --------------------------------------------------------
	     
	    @RequestMapping(value = "/localidad/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Localidad> deleteLocalidad(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Localidad with id " + id);
	 
	        Localidad localidad = localidadService.findById(id);
	        if (localidad == null) {
	            System.out.println("Unable to delete. Localidad with id " + id + " not found");
	            return new ResponseEntity<Localidad>(HttpStatus.NOT_FOUND);
	        }
	 
	        localidadService.deleteLocalidadById(id);
	        return new ResponseEntity<Localidad>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Localidades --------------------------------------------------------
	     
	    @RequestMapping(value = "/localidad/", method = RequestMethod.DELETE)
	    public ResponseEntity<Localidad> deleteAllLocalidads() {
	        System.out.println("Deleting All Localidads");
	 
	        localidadService.deleteAllLocalidades();
	        return new ResponseEntity<Localidad>(HttpStatus.NO_CONTENT);
	    }
}