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

import com.bd2FarmaUNLa.farmaUNLa.model.DetalleFactura;
import com.bd2FarmaUNLa.farmaUNLa.model.Factura;
import com.bd2FarmaUNLa.farmaUNLa.model.Producto;
import com.bd2FarmaUNLa.farmaUNLa.service.DetalleFacturaService;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@RestController
public class DetalleFacturaController {

	  	@Autowired
	  	DetalleFacturaService detalleFacturaService; 
	 
	
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> listAllDetallesFacturas() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.findAllDetallesFacturas();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<DetalleFactura> getDetalleFactura(@PathVariable("id") long id) {
	        System.out.println("Fetching DetalleFactura with id " + id);
	        DetalleFactura detalleFactura = detalleFacturaService.findById(id);
	        if (detalleFactura == null) {
	            System.out.println("DetalleFactura with id " + id + " not found");
	            return new ResponseEntity<DetalleFactura>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<DetalleFactura>(detalleFactura, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createDetalleFactura(@RequestBody DetalleFactura detalleFactura,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating DetalleFactura " + detalleFactura.toString());
	 
	        if (detalleFacturaService.isDetalleFacturaExist(detalleFactura)) {
	            System.out.println("A DetalleFactura with name " + detalleFactura.toString() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        detalleFacturaService.saveDetalleFactura(detalleFactura);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/detalleFactura/{id}").buildAndExpand(detalleFactura.getIdDetalleFactura()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update --------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<DetalleFactura> updateDetalleFactura(@PathVariable("id") long id, @RequestBody DetalleFactura detalleFactura) {
	        System.out.println("Updating DetalleFactura " + id);
	         
	        DetalleFactura currentDetalleFactura = detalleFacturaService.findById(id);
	         
	        if (currentDetalleFactura==null) {
	            System.out.println("DetalleFactura with id " + id + " not found");
	            return new ResponseEntity<DetalleFactura>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentDetalleFactura.setCantidad(detalleFactura.getCantidad());
	        currentDetalleFactura.setPrecioLista(detalleFactura.getPrecioLista());
	        currentDetalleFactura.setPrecioVenta(detalleFactura.getPrecioVenta());
	        currentDetalleFactura.setProducto(detalleFactura.getProducto());
	        currentDetalleFactura.setFactura(detalleFactura.getFactura());
	       
	        
	        detalleFacturaService.updateDetalleFactura(currentDetalleFactura);
	        return new ResponseEntity<DetalleFactura>(currentDetalleFactura, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<DetalleFactura> deleteDetalleFactura(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting DetalleFactura with id " + id);
	 
	        DetalleFactura detalleFactura = detalleFacturaService.findById(id);
	        if (detalleFactura == null) {
	            System.out.println("Unable to delete. DetalleFactura with id " + id + " not found");
	            return new ResponseEntity<DetalleFactura>(HttpStatus.NOT_FOUND);
	        }
	 
	        detalleFacturaService.deleteDetalleFacturaById(id);
	        return new ResponseEntity<DetalleFactura>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All --------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/", method = RequestMethod.DELETE)
	    public ResponseEntity<DetalleFactura> deleteAllDetallesFacturas() {
	        System.out.println("Deleting All DetallesFacturas");
	 
	        detalleFacturaService.deleteAllDetallesFacturas();
	        return new ResponseEntity<DetalleFactura>(HttpStatus.NO_CONTENT);
	    }
}