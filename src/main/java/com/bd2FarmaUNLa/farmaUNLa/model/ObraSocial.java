package com.bd2FarmaUNLa.farmaUNLa.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="obraSocial")
public class ObraSocial {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idObraSocial")
	private long id;
	private String nombre;
	
	@OneToMany(mappedBy = "obraSocial", fetch=FetchType.EAGER)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idObraSocial")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<Persona> personas;
	
	
	public ObraSocial(){} 
	
	public ObraSocial(long id, String nombre) {
		this.id = id;
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
		if (!(obj instanceof ObraSocial))
			return false;
		ObraSocial other = (ObraSocial) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", nombre=" + nombre +"]";
	}
}
