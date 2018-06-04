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

import com.bd2FarmaUNLa.farmaUNLa.model.Sucursal;
import com.bd2FarmaUNLa.farmaUNLa.service.SucursalService;


@RestController
public class SucursalController {

	  	@Autowired
	  	SucursalService sucursalService; 
	 
	
	    //-------------------Retrieve All Sucursals--------------------------------------------------------
	     
	    @RequestMapping(value = "/sucursal/", method = RequestMethod.GET)
	    public ResponseEntity<List<Sucursal>> listAllSucursales() {
	        List<Sucursal> sucursals = sucursalService.findAllSucursales();
	        if(sucursals.isEmpty()){
	            return new ResponseEntity<List<Sucursal>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Sucursal>>(sucursals, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single Sucursal--------------------------------------------------------
	     
	    @RequestMapping(value = "/sucursal/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Sucursal> getSucursal(@PathVariable("id") long id) {
	        System.out.println("Fetching Sucursal with id " + id);
	        Sucursal sucursal = sucursalService.findById(id);
	        if (sucursal == null) {
	            System.out.println("Sucursal with id " + id + " not found");
	            return new ResponseEntity<Sucursal>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a Sucursal--------------------------------------------------------
	     
	    @RequestMapping(value = "/sucursal/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createSucursal(@RequestBody Sucursal sucursal,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Sucursal " + sucursal.getNumSucursal());
	 
	        if (sucursalService.isSucursalExist(sucursal)) {
	            System.out.println("A Sucursal with name " + sucursal.getNumSucursal() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        sucursalService.saveSucursal(sucursal);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/sucursal/{id}").buildAndExpand(sucursal.getIdSucursal()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update a Sucursal --------------------------------------------------------
	     
	    @RequestMapping(value = "/sucursal/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Sucursal> updateSucursal(@PathVariable("id") long id, @RequestBody Sucursal sucursal) {
	        System.out.println("Updating Sucursal " + id);
	         
	        Sucursal currentSucursal = sucursalService.findById(id);
	         
	        if (currentSucursal==null) {
	            System.out.println("Sucursal with id " + id + " not found");
	            return new ResponseEntity<Sucursal>(HttpStatus.NOT_FOUND);
	        }
	 
	        
	        currentSucursal.setNumSucursal(sucursal.getNumSucursal());
	        currentSucursal.setCalle(sucursal.getCalle());
	        currentSucursal.setNumero(sucursal.getNumero());
	        currentSucursal.setLocalidad(sucursal.getLocalidad());
	        
	        sucursalService.updateSucursal(currentSucursal);
	        return new ResponseEntity<Sucursal>(currentSucursal, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a Sucursal --------------------------------------------------------
	     
	    @RequestMapping(value = "/sucursal/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Sucursal> deleteSucursal(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Sucursal with id " + id);
	 
	        Sucursal sucursal = sucursalService.findById(id);
	        if (sucursal == null) {
	            System.out.println("Unable to delete. Sucursal with id " + id + " not found");
	            return new ResponseEntity<Sucursal>(HttpStatus.NOT_FOUND);
	        }
	 
	        sucursalService.deleteSucursalById(id);
	        return new ResponseEntity<Sucursal>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Sucursals --------------------------------------------------------
	     
	    @RequestMapping(value = "/sucursal/", method = RequestMethod.DELETE)
	    public ResponseEntity<Sucursal> deleteAllSucursales() {
	        System.out.println("Deleting All Sucursals");
	 
	        sucursalService.deleteAllSucursales();
	        return new ResponseEntity<Sucursal>(HttpStatus.NO_CONTENT);
	    }
}