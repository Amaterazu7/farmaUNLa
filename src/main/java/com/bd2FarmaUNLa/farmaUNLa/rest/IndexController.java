package com.bd2FarmaUNLa.farmaUNLa.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndexPage(){
		return "IndexManagement";
	}
	
	@RequestMapping("/detalleFactura")
	public String getDetalleFacturaPage(){
		return "DetalleFacturaManagement";
	}
	
	@RequestMapping("/empleado")
	public String getEmpleadoPage(){
		return "EmpleadoManagement";
	}	
	
	@RequestMapping("/factura")
	public String getFacturaPage(){
		return "FacturaManagement";
	}	
	
	@RequestMapping("/formaDePago")
	public String getFormaDePagoPage(){
		return "FormaDePagoManagement";
	}	
	
	@RequestMapping("/localidad")
	public String getLocalidadPage(){
		return "LocalidadManagement";
	}	
	
	@RequestMapping("/obraSocial")
	public String getObraSocialPage(){
		return "ObraSocialManagement";
	}	
	
	@RequestMapping("/persona")
	public String getPersonaPage(){
		return "PersonaManagement";
	}	
	
	@RequestMapping("/producto")
	public String getProductoPage(){
		return "ProductoManagement";
	}
	
	@RequestMapping("/provincia")
	public String getProvinciaPage(){
		return "ProvinciaManagement";
	}	
	@RequestMapping("/sucursal")
	public String getSucursalPage(){
		return "SucursalManagement";
	}	
	@RequestMapping("/tipoProducto")
	public String getTipoProductoPage(){
		return "TipoProductoManagement";
	}
}
