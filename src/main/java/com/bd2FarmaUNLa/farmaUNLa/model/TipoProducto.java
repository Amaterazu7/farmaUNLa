package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="tipoProducto")
public class TipoProducto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idTipoProducto")
	private long idTipoProducto;
	private String nombre;
	
	@OneToOne(mappedBy = "tipoProducto", fetch = FetchType.LAZY)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTipoProducto")
	@JsonIdentityReference(alwaysAsId = true)
	private Producto producto;
	
	
	public TipoProducto(){} 
	
	public TipoProducto(long idTipoProducto, String nombre) {
		this.idTipoProducto = idTipoProducto;
		this.nombre = nombre;
	}
	
	
	public long getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setId(long idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
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
		result = prime * result + (int) (idTipoProducto ^ (idTipoProducto >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TipoProducto))
			return false;
		TipoProducto other = (TipoProducto) obj;
		if (idTipoProducto != other.idTipoProducto)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [idTipoProducto=" + idTipoProducto + ", nombre=" + nombre +"]";
	}
	

}
