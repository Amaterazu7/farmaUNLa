package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.*;

@Entity
@Table(name="formaDePago")
public class FormaDePago {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idFormaDePago")
	private long idFormaDePago;
	private String descripcion;
	
	
	public FormaDePago(){} 
	
	public FormaDePago(long idFormaDePago, String descripcion) {
		this.idFormaDePago = idFormaDePago;
		this.descripcion = descripcion;
	}
	
	
	public long getIdFormaDePago() {
		return idFormaDePago;
	}
	public void setIdFormaDePago(long idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idFormaDePago ^ (idFormaDePago >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FormaDePago))
			return false;
		FormaDePago other = (FormaDePago) obj;
		if (idFormaDePago != other.idFormaDePago)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FormaDePago [idFormaDePago=" + idFormaDePago + ", descripcion=" + descripcion + "]";
	}
	
	

}
