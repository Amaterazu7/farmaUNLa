package com.bd2FarmaUNLa.farmaUNLa.model;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private int codigo;
	private int nroTicket;
	private Date fecha;
	private Sucursal sucursal;
	private FormaDePago formaDePago;
	private ArrayList<DetalleFactura> detalleList;
	
	public Factura(){} 
	
	public Factura(long id, int codigo, int nroTicket, Date fecha, Sucursal sucursal, FormaDePago formaDePago) {
		this.id = id;
		this.codigo = codigo;
		this.nroTicket = nroTicket;
		this.fecha = fecha;		
		this.sucursal = sucursal;
		this.formaDePago = formaDePago;
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
	
	public int getNroTicket() {
		return nroTicket;
	}
	public void setNroTicket(int nroTicket) {
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
		return "Customer [id=" + id  + ", nroTicket=" + nroTicket  + ", fecha=" + fecha  + ", sucursal=" + sucursal  + ", formaDePago=" + formaDePago + "]";
	}
	

}
