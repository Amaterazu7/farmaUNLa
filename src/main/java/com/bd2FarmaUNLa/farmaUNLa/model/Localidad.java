package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="localidad")
public class Localidad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idLocalidad")
	private long idLocalidad;
	private String nombre;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idProvincia", referencedColumnName = "idProvincia", nullable = false, foreignKey = @ForeignKey(name = "FK_provincia_localidad"))
	@JsonManagedReference
	private Provincia provincia;


	public Localidad(){} 
	
	public Localidad(long idLocalidad, String nombre, Provincia provincia) {
		this.idLocalidad = idLocalidad;
		this.provincia = provincia;
		this.nombre = nombre;
	}
	
	
	public long getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(long idLocalidad) {
		this.idLocalidad = idLocalidad;
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
		result = prime * result + (int) (idLocalidad ^ (idLocalidad >>> 32));
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
		if (idLocalidad != other.idLocalidad)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [idLocalidad=" + idLocalidad + ", nombre=" + nombre +", provincia=" + provincia.getIdProvincia() + "]";
	}
	

}
