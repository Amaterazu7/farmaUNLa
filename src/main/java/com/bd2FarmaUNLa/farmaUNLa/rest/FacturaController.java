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

import com.bd2FarmaUNLa.farmaUNLa.model.Factura;
import com.bd2FarmaUNLa.farmaUNLa.model.Localidad;
import com.bd2FarmaUNLa.farmaUNLa.model.ObraSocial;
import com.bd2FarmaUNLa.farmaUNLa.model.Sucursal;
import com.bd2FarmaUNLa.farmaUNLa.service.FacturaService;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@RestController
public class FacturaController {

	  	@Autowired
	  	FacturaService facturaService; 
	 
	
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/factura/", method = RequestMethod.GET)
	    public ResponseEntity<List<Factura>> listAllFacturas() {
	        List<Factura> facturas = facturaService.findAllFacturas();
	        if(facturas.isEmpty()){
	            return new ResponseEntity<List<Factura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Factura>>(facturas, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single --------------------------------------------------------
	     
	    @RequestMapping(value = "/factura/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Factura> getFactura(@PathVariable("id") long id) {
	        System.out.println("Fetching Factura with id " + id);
	        Factura factura = facturaService.findById(id);
	        if (factura == null) {
	            System.out.println("Factura with id " + id + " not found");
	            return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Factura>(factura, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create--------------------------------------------------------
	     
	    @RequestMapping(value = "/factura/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createFactura(@RequestBody Factura factura,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Factura " + factura.getCodigo());
	 
	        if (facturaService.isFacturaExist(factura)) {
	            System.out.println("A Factura with name " + factura.getCodigo() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        facturaService.saveFactura(factura);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/factura/{id}").buildAndExpand(factura.getIdFactura()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update --------------------------------------------------------
	     
	    @RequestMapping(value = "/factura/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Factura> updateFactura(@PathVariable("id") long id, @RequestBody Factura factura) {
	        System.out.println("Updating Factura " + id);
	         
	        Factura currentFactura = facturaService.findById(id);
	         
	        if (currentFactura==null) {
	            System.out.println("Factura with id " + id + " not found");
	            return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
	        }
	 

	        currentFactura.setCodigo(factura.getCodigo());
	        currentFactura.setNroTicket(factura.getNroTicket());
	        currentFactura.setFecha(factura.getFecha());
	        currentFactura.setSucursal(factura.getSucursal());
	        currentFactura.setFormaDePago(factura.getFormaDePago());
	        currentFactura.setVendedor(factura.getVendedor());
	        currentFactura.setCajero(factura.getCajero());
	        currentFactura.setCliente(factura.getCliente());
	        
	        facturaService.updateFactura(currentFactura);
	        return new ResponseEntity<Factura>(currentFactura, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete  --------------------------------------------------------
	     
	    @RequestMapping(value = "/factura/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Factura> deleteFactura(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Factura with id " + id);
	 
	        Factura factura = facturaService.findById(id);
	        if (factura == null) {
	            System.out.println("Unable to delete. Factura with id " + id + " not found");
	            return new ResponseEntity<Factura>(HttpStatus.NOT_FOUND);
	        }
	 
	       facturaService.deleteFacturaById(id);
	        return new ResponseEntity<Factura>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All--------------------------------------------------------
	     
	    @RequestMapping(value = "/factura/", method = RequestMethod.DELETE)
	    public ResponseEntity<Factura> deleteAllFacturas() {
	        System.out.println("Deleting All Facturas");
	 
	        facturaService.deleteAllFacturas();
	        return new ResponseEntity<Factura>(HttpStatus.NO_CONTENT);
	    }
}