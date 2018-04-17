package com.bd2FarmaUNLa.farmaUNLa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Provincia {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idProvincia")
	private long idProvincia;
	private int codigo;
	private String nombre;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "provincia")
	private List<Localidad> localidades = new ArrayList<>();
	
	
	public Provincia(){} 
	
	public Provincia(long idProvincia, String nombre) {
		this.idProvincia = idProvincia;
		this.nombre = nombre;
	}
	
	
	public long getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Localidad> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idProvincia ^ (idProvincia >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Provincia))
			return false;
		Provincia other = (Provincia) obj;
		if (idProvincia != other.idProvincia)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [idProvincia=" + idProvincia + ", codigo=" + codigo +", nombre=" + nombre +"]";
	}
	

}
