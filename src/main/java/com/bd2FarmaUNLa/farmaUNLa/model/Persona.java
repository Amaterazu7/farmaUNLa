package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private int dni;
	private String numAfiliado;
	private String apellido;
	private String nombre;
	private String calle;
	private String numero;
	private Provincia provincia;
	private Localidad localidad;
	private ObraSocial obraSocial;
	
	public Persona(){} 
	
	public Persona(long id, int dni, String numAfiliado, String apellido, String nombre, String calle, String numero, Provincia provincia, Localidad localidad, ObraSocial obraSocial) {
		this.id = id;
		this.dni = dni;
		this.numAfiliado = numAfiliado;
		this.apellido = apellido;
		this.nombre = nombre;		
		this.calle = calle;
		this.numero = numero;
		this.provincia = provincia;
		this.localidad = localidad;
		this.obraSocial = obraSocial;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNumAfiliado() {
		return numAfiliado;
	}
	public void setNumAfiliado(String numAfiliado) {
		this.numAfiliado = numAfiliado;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public ObraSocial getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
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
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id  + ", dni=" + dni  + ", numAfiliado=" + numAfiliado  + ", apellido=" + apellido  + ", nombre=" + nombre  + ", calle=" + calle  + ", numero=" + numero  + ", provincia=" + provincia + ", localidad=" + localidad +", obraSocial=" + obraSocial  + "]";
	}
	

}
