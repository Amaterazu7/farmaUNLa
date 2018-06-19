package com.bd2FarmaUNLa.farmaUNLa.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndexPage(){
		return "IndexManagement";
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
	

	@RequestMapping("/detalleFactura")
	public String getDetalleFacturaPage(){
		return "DetalleFacturaManagement";
	}
	@RequestMapping("/detalleFactura/totalVentaSucursal")
	public String getTotalVentaSucursalPage(){
		return "TotalVentaSucursalManagement";
	}
	@RequestMapping("/detalleFactura/totalVentaCadena")
	public String getTotalVentaCadenaPage(){
		return "TotalVentaCadenaManagement";
	}
	@RequestMapping("/detalleFactura/totalVentaCadenaObrasocial")
	public String getTotalVentaCadenaObrasocialPage(){
		return "TotalVentaCadenaObrasocialManagement";
	}
	@RequestMapping("/detalleFactura/totalVentaSucursalObrasocial")
	public String getTotalVentaSucursalObrasocialPage(){
		return "TotalVentaSucursalObrasocialManagement";
	}
	@RequestMapping("/detalleFactura/totalCobranzaMPCadena")
	public String getTotalCobranzaMPCadenaPage(){
		return "TotalCobranzaMPCadenaManagement";
	}
	@RequestMapping("/detalleFactura/totalCobranzaMPSucursal")
	public String getTotalCobranzaMPSucursalPage(){
		return "TotalCobranzaMPSucursalManagement";
	}
	@RequestMapping("/detalleFactura/totalVentaProductoCadena")
	public String getTotalVentaProductoCadenaPage(){
		return "TotalVentaProductoCadenaManagement";
	}
	@RequestMapping("/detalleFactura/totalVentaProductoSucursal")
	public String getTotalVentaProductoSucursalPage(){
		return "TotalVentaProductoSucursalManagement";
	}
	@RequestMapping("/detalleFactura/rankingVentaCadenaMonto")
	public String getRankingVentaCadenaMontoPage(){
		return "RankingVentaCadenaMontoManagement";
	}
	@RequestMapping("/detalleFactura/rankingVentaSucursalMonto")
	public String getRankingVentaSucursalMontoPage(){
		return "RankingVentaSucursalMontoManagement";
	}
	@RequestMapping("/detalleFactura/rankingVentaCadenaCant")
	public String getRankingVentaCadenaCantPage(){
		return "RankingVentaProductoCadenaManagement";
	}
	@RequestMapping("/detalleFactura/rankingVentaSucursalCant")
	public String getRankingVentaSucursalCantPage(){
		return "RankingVentaProductoSucursalManagement";
	}
	@RequestMapping("/detalleFactura/rankingClienteCadenaMonto")
	public String getRankingClienteMontoCadenaPage(){
		return "RankingClienteMontoCadenaManagement";
	}
	@RequestMapping("/detalleFactura/rankingClienteSucursalMonto")
	public String getRankingClienteMontoSucursalPage(){
		return "RankingClienteMontoSucursalManagement";
	}
}
