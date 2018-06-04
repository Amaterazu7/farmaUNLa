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

import com.bd2FarmaUNLa.farmaUNLa.model.ObraSocial;
import com.bd2FarmaUNLa.farmaUNLa.model.Localidad;
import com.bd2FarmaUNLa.farmaUNLa.model.ObraSocial;
import com.bd2FarmaUNLa.farmaUNLa.model.Sucursal;
import com.bd2FarmaUNLa.farmaUNLa.service.ObraSocialService;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@RestController
public class ObraSocialController {

	  	@Autowired
	  	ObraSocialService obraSocialService; 
	 
	
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/obraSocial/", method = RequestMethod.GET)
	    public ResponseEntity<List<ObraSocial>> listAllObraSocials() {
	        List<ObraSocial> obraSocials = obraSocialService.findAllObraSociales();
	        if(obraSocials.isEmpty()){
	            return new ResponseEntity<List<ObraSocial>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<ObraSocial>>(obraSocials, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single --------------------------------------------------------
	     
	    @RequestMapping(value = "/obraSocial/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ObraSocial> getObraSocial(@PathVariable("id") long id) {
	        System.out.println("Fetching ObraSocial with id " + id);
	        ObraSocial obraSocial = obraSocialService.findByIdObraSocial(id);
	        if (obraSocial == null) {
	            System.out.println("ObraSocial with id " + id + " not found");
	            return new ResponseEntity<ObraSocial>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<ObraSocial>(obraSocial, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create--------------------------------------------------------
	     
	    @RequestMapping(value = "/obraSocial/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createObraSocial(@RequestBody ObraSocial obraSocial,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating ObraSocial " + obraSocial.getNombre());
	 
	        if (obraSocialService.isObraSocialExist(obraSocial)) {
	            System.out.println("A ObraSocial with name " + obraSocial.getNombre() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        obraSocialService.saveObraSocial(obraSocial);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/obraSocial/{id}").buildAndExpand(obraSocial.getIdObraSocial()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update --------------------------------------------------------
	     
	    @RequestMapping(value = "/obraSocial/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ObraSocial> updateObraSocial(@PathVariable("id") long id, @RequestBody ObraSocial obraSocial) {
	        System.out.println("Updating ObraSocial " + id);
	         
	        ObraSocial currentObraSocial = obraSocialService.findByIdObraSocial(id);
	         
	        if (currentObraSocial==null) {
	            System.out.println("ObraSocial with id " + id + " not found");
	            return new ResponseEntity<ObraSocial>(HttpStatus.NOT_FOUND);
	        }
	 

	        currentObraSocial.setNombre(obraSocial.getNombre());

	        
	        obraSocialService.updateObraSocial(currentObraSocial);
	        return new ResponseEntity<ObraSocial>(currentObraSocial, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete  --------------------------------------------------------
	     
	    @RequestMapping(value = "/obraSocial/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<ObraSocial> deleteObraSocial(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting ObraSocial with id " + id);
	 
	        ObraSocial obraSocial = obraSocialService.findByIdObraSocial(id);
	        if (obraSocial == null) {
	            System.out.println("Unable to delete. ObraSocial with id " + id + " not found");
	            return new ResponseEntity<ObraSocial>(HttpStatus.NOT_FOUND);
	        }
	 
	       obraSocialService.deleteObraSocial(id);
	        return new ResponseEntity<ObraSocial>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All--------------------------------------------------------
	     
	    @RequestMapping(value = "/obraSocial/", method = RequestMethod.DELETE)
	    public ResponseEntity<ObraSocial> deleteAllObraSociales() {
	        System.out.println("Deleting All ObraSocials");
	 
	        obraSocialService.deleteAllObraSociales();
	        return new ResponseEntity<ObraSocial>(HttpStatus.NO_CONTENT);
	    }
}