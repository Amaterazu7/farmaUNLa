package com.bd2FarmaUNLa.farmaUNLa.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idFactura")
	private long idFactura;
	private int codigo;
	private String nroTicket;
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFormaDePago", referencedColumnName = "idFormaDePago")
	private FormaDePago formaDePago;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal")
	private Sucursal sucursal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCajero", referencedColumnName = "idEmpleado")
	private Empleado cajero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idVendedor", referencedColumnName = "idEmpleado")
	private Empleado vendedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", referencedColumnName = "idPersona")
	private Persona cliente;
	
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
	private List<DetalleFactura> detalles = new ArrayList<>();
	
	
	public Factura(){} 
	
	public Factura(long idFactura, int codigo, String nroTicket, Date fecha, Sucursal sucursal, FormaDePago formaDePago, Empleado vendedor, Empleado cajero, Persona cliente) {
		this.idFactura = idFactura;
		this.codigo = codigo;
		this.nroTicket = nroTicket;
		this.fecha = fecha;		
		this.sucursal = sucursal;
		this.formaDePago = formaDePago;
		this.vendedor = vendedor;
		this.cajero = cajero;
		this.cliente = cliente;
	}
	
	
	public long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}	
	
	public String getNroTicket() {
		return nroTicket;
	}
	public void setNroTicket(String nroTicket) {
		this.nroTicket = nroTicket;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	public FormaDePago getNumero() {
		return formaDePago;
	}
	public void setNumero(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	public FormaDePago getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

	public Empleado getCajero() {
		return cajero;
	}
	public void setCajero(Empleado cajero) {
		this.cajero = cajero;
	}

	public Empleado getVendedor() {
		return vendedor;
	}
	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}

	public Persona getCliente() {
		return cliente;
	}
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idFactura ^ (idFactura >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Factura))
			return false;
		Factura other = (Factura) obj;
		if (idFactura != other.idFactura)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [idFactura=" + idFactura  + ", nroTicket=" + nroTicket  + ", fecha=" + fecha  + ", sucursal=" + sucursal.getIdSucursal()  + ", formaDePago=" + formaDePago.getIdFormaDePago() + ", vendedor=" + vendedor.getCuil() + ", cajero=" + cajero.getCuil() + ", cliente=" + cliente.getIdPersona() + "]";
	}
	

}
