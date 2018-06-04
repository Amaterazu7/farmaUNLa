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

import com.bd2FarmaUNLa.farmaUNLa.model.Empleado;
import com.bd2FarmaUNLa.farmaUNLa.model.Localidad;
import com.bd2FarmaUNLa.farmaUNLa.model.ObraSocial;
import com.bd2FarmaUNLa.farmaUNLa.model.Sucursal;
import com.bd2FarmaUNLa.farmaUNLa.service.EmpleadoService;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@RestController
public class EmpleadoController {

	  	@Autowired
	  	EmpleadoService empleadoService; 
	 
	
	    //-------------------Retrieve All--------------------------------------------------------
	     
	    @RequestMapping(value = "/empleado/", method = RequestMethod.GET)
	    public ResponseEntity<List<Empleado>> listAllEmpleados() {
	        List<Empleado> empleados = empleadoService.findAllEmpleados();
	        if(empleados.isEmpty()){
	            return new ResponseEntity<List<Empleado>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single --------------------------------------------------------
	     
	    @RequestMapping(value = "/empleado/{cuil}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Empleado> getEmpleado(@PathVariable("cuil") long cuil) {
	        System.out.println("Fetching Empleado with id " + cuil);
	        Empleado empleado = empleadoService.findByCuil(cuil);
	        if (empleado == null) {
	            System.out.println("Empleado with id " + cuil + " not found");
	            return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create--------------------------------------------------------
	     
	    @RequestMapping(value = "/empleado/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createEmpleado(@RequestBody Empleado empleado,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating Empleado " + empleado.getNombre());
	 
	        if (empleadoService.isEmpleadoExist(empleado)) {
	            System.out.println("A Empleado with name " + empleado.getNombre() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        empleadoService.saveEmpleado(empleado);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/empleado/{cuil}").buildAndExpand(empleado.getCuil()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update --------------------------------------------------------
	     
	    @RequestMapping(value = "/empleado/{cuil}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Empleado> updateEmpleado(@PathVariable("cuil") long cuil, @RequestBody Empleado empleado) {
	        System.out.println("Updating Empleado " + cuil);
	         
	        Empleado currentEmpleado = empleadoService.findByCuil(cuil);
	         
	        if (currentEmpleado==null) {
	            System.out.println("Empleado with cuil " + cuil + " not found");
	            return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentEmpleado.setDni(empleado.getDni());
	        currentEmpleado.setNumAfiliado(empleado.getNumAfiliado());
	        currentEmpleado.setApellido(empleado.getApellido());
	        currentEmpleado.setNombre(empleado.getNombre());
	        currentEmpleado.setCalle(empleado.getCalle());
	        currentEmpleado.setNumero(empleado.getNumero());
	        currentEmpleado.setLocalidad(empleado.getLocalidad());
	        currentEmpleado.setObraSocial(empleado.getObraSocial());	        
	        currentEmpleado.setCuil(empleado.getCuil());
	        currentEmpleado.setEncargado(empleado.isEncargado());
	        currentEmpleado.setSucursal(empleado.getSucursal());

	        
	        empleadoService.updateEmpleado(currentEmpleado);
	        return new ResponseEntity<Empleado>(currentEmpleado, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete  --------------------------------------------------------
	     
	    @RequestMapping(value = "/empleado/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Empleado> deleteEmpleado(@PathVariable("id") long id) {
	        System.out.println("Fetching & Deleting Empleado with id " + id);
	 
	        Empleado empleado = empleadoService.findByCuil(id);
	        if (empleado == null) {
	            System.out.println("Unable to delete. Empleado with id " + id + " not found");
	            return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
	        }
	 
	       empleadoService.deleteEmpleadoById(id);
	        return new ResponseEntity<Empleado>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All--------------------------------------------------------
	     
	    @RequestMapping(value = "/empleado/", method = RequestMethod.DELETE)
	    public ResponseEntity<Empleado> deleteAllEmpleados() {
	        System.out.println("Deleting All Empleados");
	 
	        empleadoService.deleteAllEmpleados();
	        return new ResponseEntity<Empleado>(HttpStatus.NO_CONTENT);
	    }
}