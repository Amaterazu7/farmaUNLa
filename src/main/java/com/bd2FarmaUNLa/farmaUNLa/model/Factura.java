package com.bd2FarmaUNLa.farmaUNLa.model;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="factura")
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idFactura")
	private long idFactura;
	private int codigo;
	private String nroTicket;
	
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date fecha;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idFormaDePago", referencedColumnName = "idFormaDePago", nullable = false, foreignKey = @ForeignKey(name = "FK_formaDePago_factura"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idFormaDePago")
	@JsonIdentityReference(alwaysAsId = true)
	private FormaDePago formaDePago;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal", nullable = false, foreignKey = @ForeignKey(name = "FK_sucursal_factura"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idSucursal")
	@JsonIdentityReference(alwaysAsId = true)
	private Sucursal sucursal;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCajero", referencedColumnName = "idEmpleado", nullable = false, foreignKey = @ForeignKey(name = "FK_empleadoCajero_factura"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPersona")
	@JsonIdentityReference(alwaysAsId = true)
	private Empleado cajero;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idVendedor", referencedColumnName = "idEmpleado", nullable = false, foreignKey = @ForeignKey(name = "FK_empleadoVendedor_factura"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPersona")
	@JsonIdentityReference(alwaysAsId = true)
	private Empleado vendedor;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCliente", referencedColumnName = "idPersona", nullable = false, foreignKey = @ForeignKey(name = "FK_persona_factura"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPersona")
	@JsonIdentityReference(alwaysAsId = true)
	private Persona cliente;
	
	
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
