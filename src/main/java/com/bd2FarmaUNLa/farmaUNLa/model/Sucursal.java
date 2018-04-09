package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sucursal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Integer numSucursal;
	private String calle;
	private String numero;
	private Provincia provincia;
	private Localidad localidad;
	
	public Sucursal(){} 
	
	public Sucursal(int id, Integer numSucursal, String calle, String numero, Provincia provincia, Localidad localidad) {
		this.id = id;
		this.numSucursal = numSucursal;
		this.calle = calle;
		this.numero = numero;
		this.provincia = provincia;
		this.localidad = localidad;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Integer getNumSucursal() {
		return numSucursal;
	}
	public void setNumSucursal(Integer numSucursal) {
		this.numSucursal = numSucursal;
	}

	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
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
		if (!(obj instanceof Sucursal))
			return false;
		Sucursal other = (Sucursal) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id  + ", numSucursal=" + numSucursal  + ", calle=" + calle  + ", numero=" + numero  + ", provincia=" + provincia + ", localidad=" + localidad +"]";
	}
	

}
