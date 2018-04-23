package com.bd2FarmaUNLa.farmaUNLa.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


@Entity
@Table(name="provincia")
public class Provincia {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idProvincia")
	private long idProvincia;
	private int codigo;
	private String nombre;
	
	@OneToMany(mappedBy = "provincia", fetch=FetchType.EAGER)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProvincia")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<Localidad> localidades;
	
	
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
