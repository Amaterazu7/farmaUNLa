package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Localidad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idLocalidad")
	private long id;
	private String nombre;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProvincia", referencedColumnName = "idProvincia")
	private Provincia provincia;
	
	public Localidad(){} 
	
	public Localidad(long id, String nombre, Provincia provincia) {
		this.id = id;
		this.provincia = provincia;
		this.nombre = nombre;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
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
		if (!(obj instanceof Localidad))
			return false;
		Localidad other = (Localidad) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", nombre=" + nombre +", provincia=" + provincia.getId() + "]";
	}
	

}
