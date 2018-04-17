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

import com.bd2FarmaUNLa.farmaUNLa.model.TipoProducto;
import com.bd2FarmaUNLa.farmaUNLa.service.TipoProductoService;


@RestController
public class TipoProductoController {

	  	@Autowired
	  	TipoProductoService tipoProductoService; 
	 
	
	    //-------------------Retrieve All TipoProductos--------------------------------------------------------
	     
	    @RequestMapping(value = "/tipoProducto/", method = RequestMethod.GET)
	    public ResponseEntity<List<TipoProducto>> listAllTipoProductos() {
	        List<TipoProducto> tipoProductos = tipoProductoService.findAllTiposProductos();
	        if(tipoProductos.isEmpty()){
	            return new ResponseEntity<List<TipoProducto>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<TipoProducto>>(tipoProductos, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single TipoProducto--------------------------------------------------------
	     
	    @RequestMapping(value = "/tipoProducto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TipoProducto> getTipoProducto(@PathVariable("id") long id) {
	        System.out.println("Fetching TipoProducto with id " + id);
	        TipoProducto tipoProducto = tipoProductoService.findById(id);
	        if (tipoProducto == null) {
	            System.out.println("TipoProducto with id " + id + " not found");
	            return new ResponseEntity<TipoProducto>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<TipoProducto>(tipoProducto, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a TipoProducto--------------------------------------------------------
	     
	    @RequestMapping(value = "/tipoProducto/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createTipoProducto(@RequestBody TipoProducto tipoProducto,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating TipoProducto " + tipoProducto.getNombre());
	 
	        if (tipoProductoService.isTipoProductoExist(tipoProducto)) {
	            System.out.println("A TipoProducto with name " + tipoProducto.getNombre() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        tipoProductoService.saveTipoProducto(tipoProducto);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/tipoProducto/{id}").buildAndExpand(tipoProducto.getIdTipoProducto()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update a TipoProducto --------------------------------------------------------
	     
	    @RequestMapping(value = "/tipoProducto/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TipoProducto> updateTipoProducto(@PathVariable("id") long id, @RequestBody TipoProducto tipoProducto) {
	        System.out.println("Updating TipoProducto " + id);
	         
	        TipoProducto currentTipoProducto = tipoProductoService.findById(id);
	         
	        if (currentTipoProducto==null) {
	            System.out.println("TipoProducto with id " + id + " not found");
	            return new ResponseEntity<TipoProducto>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentTipoProducto.setNombre(tipoProducto.getNombre());
	        //currentTipoProducto.setId(tipoProducto.getIdTipoProducto());
	        
	        tipoProductoService.updateTipoProducto(currentTipoProducto);
	        return new ResponseEntity<TipoProducto>(currentTipoProducto, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a TipoProducto --------------------------------------------------------
	     
	    @RequestMapping(value = "/tipoProducto/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<TipoProducto> deleteTipoProducto(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting TipoProducto with id " + id);
	 
	        TipoProducto tipoProducto = tipoProductoService.findById(id);
	        if (tipoProducto == null) {
	            System.out.println("Unable to delete. TipoProducto with id " + id + " not found");
	            return new ResponseEntity<TipoProducto>(HttpStatus.NOT_FOUND);
	        }
	 
	        tipoProductoService.deleteTipoProductoById(id);
	        return new ResponseEntity<TipoProducto>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All TiposProductos --------------------------------------------------------
	     
	    @RequestMapping(value = "/tipoProducto/", method = RequestMethod.DELETE)
	    public ResponseEntity<TipoProducto> deleteAllTipoProductos() {
	        System.out.println("Deleting All TipoProductos");
	 
	        tipoProductoService.deleteAllTiposProductos();
	        return new ResponseEntity<TipoProducto>(HttpStatus.NO_CONTENT);
	    }
}