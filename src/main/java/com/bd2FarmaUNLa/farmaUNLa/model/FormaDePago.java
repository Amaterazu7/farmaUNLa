package com.bd2FarmaUNLa.farmaUNLa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class FormaDePago {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idFormaDePago")
	private long idFormaDePago;
	private String descripcion;
	
	@OneToMany(mappedBy = "formaDePago", cascade = CascadeType.ALL)
	private List<Factura> facturas = new ArrayList<>();
	
	
	public FormaDePago(){} 
	
	public FormaDePago(long idFormaDePago, String descripcion) {
		this.idFormaDePago = idFormaDePago;
		this.descripcion = descripcion;
	}
	
	
	public long getIdFormaDePago() {
		return idFormaDePago;
	}
	public void setIdFormaDePago(long idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idFormaDePago ^ (idFormaDePago >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FormaDePago))
			return false;
		FormaDePago other = (FormaDePago) obj;
		if (idFormaDePago != other.idFormaDePago)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FormaDePago [idFormaDePago=" + idFormaDePago + ", descripcion=" + descripcion + ", facturas=" + facturas
				+ "]";
	}
	
	

}
