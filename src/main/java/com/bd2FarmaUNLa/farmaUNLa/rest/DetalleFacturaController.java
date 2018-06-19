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
	    public ResponseEntity<List<DetalleFactura>> listAllDetalleFacturas() {
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
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	    /*
	    @RequestMapping(value = "/detallesFactura/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> listAllDetallesFacturas() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.findAllDetallesFacturas();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    */
	    //-1------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/totalVentaCadena/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> totalVentaCadena() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.totalVentaCadena();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-1------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/totalVentaSucursal/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> totalVentaSucursal() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.totalVentaSucursal();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-2------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/totalVentaCadenaObrasocial/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> totalVentaCadenaObrasocial() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.totalVentaCadenaObrasocial();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-2------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/totalVentaSucursalObrasocial/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> totalVentaSucursalObrasocial() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.totalVentaSucursalObrasocial();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/totalCobranzaMPCadena/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> totalCobranzaMPCadena() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.totalCobranzaMPCadena();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/totalCobranzaMPSucursal/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> totalCobranzaMPSucursal() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.totalCobranzaMPCadena();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/totalVentaProductoCadena/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> totalVentaProductoCadena() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.totalVentaProductoCadena();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/totalVentaProductoSucursal/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> totalVentaProductoSucursal() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.totalVentaProductoSucursal();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/rankingVentaCadenaMonto/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> rankingVentaCadenaMonto() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.rankingVentaCadenaMonto();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/rankingVentaSucursalMonto/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> rankingVentaSucursalMonto() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.rankingVentaSucursalMonto();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/rankingVentaCadenaCant/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> rankingVentaCadenaCant() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.rankingVentaCadenaCant();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/rankingVentaSucursalCant/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> rankingVentaSucursalCant() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.rankingVentaSucursalCant();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/rankingClienteCadenaMonto/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> rankingClienteCadenaMonto() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.rankingClienteCadenaMonto();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/rankingClienteSucursalMonto/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> rankingClienteSucursalMonto() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.rankingClienteSucursalMonto();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/detalleFactura/rankingClienteCadenaCant/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> rankingClienteCadenaCant() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.rankingClienteCadenaCant();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
	    //-------------------Retrieve All--------------------------------------------------------
 
	    @RequestMapping(value = "/detalleFactura/rankingClienteSucursalCant/", method = RequestMethod.GET)
	    public ResponseEntity<List<DetalleFactura>> rankingClienteSucursalCant() {
	        List<DetalleFactura> detallesFacturas = detalleFacturaService.rankingClienteSucursalCant();
	        if(detallesFacturas.isEmpty()){
	            return new ResponseEntity<List<DetalleFactura>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<DetalleFactura>>(detallesFacturas, HttpStatus.OK);
	    }
	    
	    
}