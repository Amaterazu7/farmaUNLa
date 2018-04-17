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

import com.bd2FarmaUNLa.farmaUNLa.model.Provincia;
import com.bd2FarmaUNLa.farmaUNLa.service.ProvinciaService;


@RestController
public class ProvinciaController {

	  	@Autowired
	  	ProvinciaService provinciaService; 
	 
	
	    //-------------------Retrieve All Provincias--------------------------------------------------------
	     
	    @RequestMapping(value = "/provincia/", method = RequestMethod.GET)
	    public ResponseEntity<List<Provincia>> listAllProvincias() {
	        List<Provincia> provincias = provinciaService.findAllProvincias();
	        if(provincias.isEmpty()){
	            return new ResponseEntity<List<Provincia>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Provincia>>(provincias, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single Provincia--------------------------------------------------------
	     
	    @RequestMapping(value = "/provincia/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Provincia> getProvincia(@PathVariable("id") long id) {
	        System.out.println("Fetching Provincia with id " + id);
	        Provincia provincia = provinciaService.findById(id);
	        if (provincia == null) {
	            System.out.println("Provincia with id " + id + " not found");
	            return new ResponseEntity<Provincia>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Provincia>(provincia, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a Provincia--------------------------------------------------------
	     
	    @RequestMapping(value = "/provincia/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createProvincia(@RequestBody Provincia provincia,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Provincia " + provincia.getNombre());
	 
	        if (provinciaService.isProvinciaExist(provincia)) {
	            System.out.println("A Provincia with name " + provincia.getNombre() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        provinciaService.saveProvincia(provincia);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/provincia/{id}").buildAndExpand(provincia.getIdProvincia()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update a Provincia --------------------------------------------------------
	     
	    @RequestMapping(value = "/provincia/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Provincia> updateProvincia(@PathVariable("id") long id, @RequestBody Provincia provincia) {
	        System.out.println("Updating Provincia " + id);
	         
	        Provincia currentProvincia = provinciaService.findById(id);
	         
	        if (currentProvincia==null) {
	            System.out.println("Provincia with id " + id + " not found");
	            return new ResponseEntity<Provincia>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentProvincia.setNombre(provincia.getNombre());
	        currentProvincia.setCodigo(provincia.getCodigo());
	        
	        provinciaService.updateProvincia(currentProvincia);
	        return new ResponseEntity<Provincia>(currentProvincia, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a Provincia --------------------------------------------------------
	     
	    @RequestMapping(value = "/provincia/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Provincia> deleteProvincia(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Provincia with id " + id);
	 
	        Provincia provincia = provinciaService.findById(id);
	        if (provincia == null) {
	            System.out.println("Unable to delete. Provincia with id " + id + " not found");
	            return new ResponseEntity<Provincia>(HttpStatus.NOT_FOUND);
	        }
	 
	        provinciaService.deleteProvinciaById(id);
	        return new ResponseEntity<Provincia>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Provincias --------------------------------------------------------
	     
	    @RequestMapping(value = "/provincia/", method = RequestMethod.DELETE)
	    public ResponseEntity<Provincia> deleteAllProvincias() {
	        System.out.println("Deleting All Provincias");
	 
	        provinciaService.deleteAllProvincias();
	        return new ResponseEntity<Provincia>(HttpStatus.NO_CONTENT);
	    }
}