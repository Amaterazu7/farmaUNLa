package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona {

	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idEmpleado")
	private long idEmpleado;
	private long cuil;
	private boolean encargado;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal")
	private Sucursal sucursal;
	
	public Empleado(){} 
	
	public Empleado(long idEmpleado, long cuil, boolean encargado, Sucursal sucursal) {
		super();
		this.idEmpleado = idEmpleado;
		this.cuil = cuil;
		this.encargado = encargado;
		this.sucursal = sucursal;
	}
	
	
	public long getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public long getCuil() {
		return cuil;
	}
	public void setCuil(long cuil) {
		this.cuil = cuil;
	}

	public boolean isEncargado() {
		return encargado;
	}
	public void setEncargado(boolean encargado) {
		this.encargado = encargado;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idEmpleado ^ (idEmpleado >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		if (idEmpleado != other.idEmpleado)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [idEmpleado=" + idEmpleado + ", cuil=" + cuil + ", encargado=" + encargado + ", sucursal=" + sucursal.getId() + ", persona=" + this.getId() +"]";
	}
	

}
