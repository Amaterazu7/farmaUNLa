package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="sucursal")
public class Sucursal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idSucursal")
	private long idSucursal;
	private Integer numSucursal;
	private String calle;
	private String numero;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idLocalidad", referencedColumnName = "idLocalidad", nullable = false, foreignKey = @ForeignKey(name = "FK_localidad_sucursal"))
	@JsonManagedReference
	private Localidad localidad;

	
	public Sucursal(){} 
	
	public Sucursal(long idSucursal, Integer numSucursal, String calle, String numero, Localidad localidad) {
		this.idSucursal = idSucursal;
		this.numSucursal = numSucursal;
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
	}
	
	
	public long getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(long idSucursal) {
		this.idSucursal = idSucursal;
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
		result = prime * result + (int) (idSucursal ^ (idSucursal >>> 32));
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
		if (idSucursal != other.idSucursal)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [idSucursal=" + idSucursal  + ", numSucursal=" + numSucursal  + ", calle=" + calle  + ", numero=" + numero  + ", localidad=" + localidad.getIdLocalidad() +"]";
	}
	

}
