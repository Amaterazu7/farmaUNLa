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

import com.bd2FarmaUNLa.farmaUNLa.model.FormaDePago;
import com.bd2FarmaUNLa.farmaUNLa.model.Localidad;
import com.bd2FarmaUNLa.farmaUNLa.model.ObraSocial;
import com.bd2FarmaUNLa.farmaUNLa.model.Sucursal;
import com.bd2FarmaUNLa.farmaUNLa.service.FormaDePagoService;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@RestController
public class FormaDePagoController {

	  	@Autowired
	  	FormaDePagoService formaDePagoService; 
	 
	
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/formaDePago/", method = RequestMethod.GET)
	    public ResponseEntity<List<FormaDePago>> listAllFormaDePagos() {
	        List<FormaDePago> formaDePagos = formaDePagoService.findAllFormasDePago();
	        if(formaDePagos.isEmpty()){
	            return new ResponseEntity<List<FormaDePago>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<FormaDePago>>(formaDePagos, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single --------------------------------------------------------
	     
	    @RequestMapping(value = "/formaDePago/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<FormaDePago> getFormaDePago(@PathVariable("id") long id) {
	        System.out.println("Fetching FormaDePago with id " + id);
	        FormaDePago formaDePago = formaDePagoService.findById(id);
	        if (formaDePago == null) {
	            System.out.println("FormaDePago with id " + id + " not found");
	            return new ResponseEntity<FormaDePago>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<FormaDePago>(formaDePago, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create--------------------------------------------------------
	     
	    @RequestMapping(value = "/formaDePago/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createFormaDePago(@RequestBody FormaDePago formaDePago,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating FormaDePago " + formaDePago.getDescripcion());
	 
	        if (formaDePagoService.isFormaDePagoExist(formaDePago)) {
	            System.out.println("A FormaDePago with name " + formaDePago.getDescripcion() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        formaDePagoService.saveFormaDePago(formaDePago);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/formaDePago/{id}").buildAndExpand(formaDePago.getIdFormaDePago()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update --------------------------------------------------------
	     
	    @RequestMapping(value = "/formaDePago/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<FormaDePago> updateFormaDePago(@PathVariable("id") long id, @RequestBody FormaDePago formaDePago) {
	        System.out.println("Updating FormaDePago " + id);
	         
	        FormaDePago currentFormaDePago = formaDePagoService.findById(id);
	         
	        if (currentFormaDePago==null) {
	            System.out.println("FormaDePago with id " + id + " not found");
	            return new ResponseEntity<FormaDePago>(HttpStatus.NOT_FOUND);
	        }
	 

	        currentFormaDePago.setDescripcion(formaDePago.getDescripcion());

	        
	        formaDePagoService.updateFormaDePago(currentFormaDePago);
	        return new ResponseEntity<FormaDePago>(currentFormaDePago, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete  --------------------------------------------------------
	     
	    @RequestMapping(value = "/formaDePago/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<FormaDePago> deleteFormaDePago(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting FormaDePago with id " + id);
	 
	        FormaDePago formaDePago = formaDePagoService.findById(id);
	        if (formaDePago == null) {
	            System.out.println("Unable to delete. FormaDePago with id " + id + " not found");
	            return new ResponseEntity<FormaDePago>(HttpStatus.NOT_FOUND);
	        }
	 
	       formaDePagoService.deleteFormaDePagoById(id);
	        return new ResponseEntity<FormaDePago>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All--------------------------------------------------------
	     
	    @RequestMapping(value = "/formaDePago/", method = RequestMethod.DELETE)
	    public ResponseEntity<FormaDePago> deleteAllFormaDePagos() {
	        System.out.println("Deleting All FormaDePagos");
	 
	        formaDePagoService.deleteAllFormasDePago();
	        return new ResponseEntity<FormaDePago>(HttpStatus.NO_CONTENT);
	    }
}