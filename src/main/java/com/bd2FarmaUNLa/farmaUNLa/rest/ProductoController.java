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

import com.bd2FarmaUNLa.farmaUNLa.model.Producto;
import com.bd2FarmaUNLa.farmaUNLa.service.ProductoService;


@RestController
public class ProductoController {

	  	@Autowired
	  	ProductoService productoService; 
	 
	
	    //-------------------Retrieve All Productos--------------------------------------------------------
	     
	    @RequestMapping(value = "/producto/", method = RequestMethod.GET)
	    public ResponseEntity<List<Producto>> listAllProductos() {
	        List<Producto> productos = productoService.findAllProductos();
	        if(productos.isEmpty()){
	            return new ResponseEntity<List<Producto>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single Producto--------------------------------------------------------
	     
	    @RequestMapping(value = "/producto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Producto> getProducto(@PathVariable("id") long id) {
	        System.out.println("Fetching Producto with id " + id);
	        Producto producto = productoService.findById(id);
	        if (producto == null) {
	            System.out.println("Producto with id " + id + " not found");
	            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a Producto--------------------------------------------------------
	     
	    @RequestMapping(value = "/producto/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createProducto(@RequestBody Producto producto,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Producto " + producto.getDescripcion());
	 
	        if (productoService.isProductoExist(producto)) {
	            System.out.println("A Producto with name " + producto.getDescripcion() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        productoService.saveProducto(producto);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/producto/{id}").buildAndExpand(producto.getIdProducto()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update a Producto --------------------------------------------------------
	     
	    @RequestMapping(value = "/producto/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Producto> updateProducto(@PathVariable("id") long id, @RequestBody Producto producto) {
	        System.out.println("Updating Producto " + id);
	         
	        Producto currentProducto = productoService.findById(id);
	         
	        if (currentProducto==null) {
	            System.out.println("Producto with id " + id + " not found");
	            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentProducto.setDescripcion(producto.getDescripcion());
	        currentProducto.setCodigo(producto.getCodigo());
	        currentProducto.setPrecio(producto.getPrecio());
	        
	        productoService.updateProducto(currentProducto);
	        return new ResponseEntity<Producto>(currentProducto, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a Producto --------------------------------------------------------
	     
	    @RequestMapping(value = "/producto/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Producto> deleteProducto(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Producto with id " + id);
	 
	        Producto producto = productoService.findById(id);
	        if (producto == null) {
	            System.out.println("Unable to delete. Producto with id " + id + " not found");
	            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
	        }
	 
	        productoService.deleteProductoById(id);
	        return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Productos --------------------------------------------------------
	     
	    @RequestMapping(value = "/producto/", method = RequestMethod.DELETE)
	    public ResponseEntity<Producto> deleteAllProductos() {
	        System.out.println("Deleting All Productos");
	 
	        productoService.deleteAllProductos();
	        return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
	    }
}