package com.bd2FarmaUNLa.farmaUNLa.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idFactura")
	private long id;
	private int codigo;
	private String nroTicket;
	private Date fecha;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal")
	private Sucursal sucursal;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idFormaDePago", referencedColumnName = "idFormaDePago")
	private FormaDePago formaDePago;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCajero", referencedColumnName = "idEmpleado")
	private Empleado cajero;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idVendedor", referencedColumnName = "idEmpleado")
	private Empleado vendedor;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
	private Persona cliente;
	
	public Factura(){} 
	
	public Factura(long id, int codigo, String nroTicket, Date fecha, Sucursal sucursal, FormaDePago formaDePago, Empleado vendedor, Empleado cajero, Persona cliente) {
		this.id = id;
		this.codigo = codigo;
		this.nroTicket = nroTicket;
		this.fecha = fecha;		
		this.sucursal = sucursal;
		this.formaDePago = formaDePago;
		this.vendedor = vendedor;
		this.cajero = cajero;
		this.cliente = cliente;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id  + ", nroTicket=" + nroTicket  + ", fecha=" + fecha  + ", sucursal=" + sucursal.getId()  + ", formaDePago=" + formaDePago.getId() + ", vendedor=" + vendedor.getIdEmpleado() + ", cajero=" + cajero.getIdEmpleado() + ", cliente=" + cliente.getId() + "]";
	}
	

}
