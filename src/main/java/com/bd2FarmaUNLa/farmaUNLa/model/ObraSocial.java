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
	private long idObraSocial;
	private String nombre;
	
	@OneToMany(mappedBy = "obraSocial", fetch=FetchType.EAGER)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idObraSocial")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<Persona> personas;

	public ObraSocial(){} 
	
	public ObraSocial(long idObraSocial, String nombre) {
		this.idObraSocial = idObraSocial;
		this.nombre = nombre;
	}
	
	public long getIdObraSocial() {
		return idObraSocial;
	}
	public void setIdObraSocial(long idObraSocial) {
		this.idObraSocial = idObraSocial;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idObraSocial ^ (idObraSocial >>> 32));
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
		if (idObraSocial != other.idObraSocial)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + idObraSocial + ", nombre=" + nombre +"]";
	}
}
