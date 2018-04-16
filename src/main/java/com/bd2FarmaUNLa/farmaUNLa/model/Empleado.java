package com.bd2FarmaUNLa.farmaUNLa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="empleado")
@PrimaryKeyJoinColumn(name="idEmpleado")
public class Empleado extends Persona {
	//private long idEmpleado;
	private long cuil;
	private boolean encargado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal")
	private Sucursal sucursal;
	
	@OneToMany(mappedBy = "cajero", cascade = CascadeType.ALL)
	private List<Factura> cajeroFacturas = new ArrayList<>();
	
	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
	private List<Factura> vendedorFacturas = new ArrayList<>();
	
	
	public Empleado(){} 
	
	public Empleado( long cuil, boolean encargado, Sucursal sucursal) {
		super();
		//this.idEmpleado = idEmpleado;
		this.cuil = cuil;
		this.encargado = encargado;
		this.sucursal = sucursal;
	}
	
	
	/*public long getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}*/

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

	
	/*@Override
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
	}*/
	@Override
	public String toString() {
		return "Customer [cuil=" + cuil + "idPersona=" + this.getIdPersona() +  ", encargado=" + encargado + ", sucursal=" + sucursal.getIdSucursal() +"]";
	}
	

}
