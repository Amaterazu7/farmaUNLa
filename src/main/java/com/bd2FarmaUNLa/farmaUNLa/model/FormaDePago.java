package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FormaDePago {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String descripcion;
	
	public FormaDePago(){} 
	
	public FormaDePago(long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		if (!(obj instanceof FormaDePago))
			return false;
		FormaDePago other = (FormaDePago) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", descripcion=" + descripcion +"]";
	}
	

}
