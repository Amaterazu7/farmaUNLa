package com.bd2FarmaUNLa.farmaUNLa.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="empleado")
@PrimaryKeyJoinColumn(name="idEmpleado")
public class Empleado extends Persona {
	
	private long cuil;
	private boolean encargado;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idSucursal", referencedColumnName = "idSucursal", nullable = false, foreignKey = @ForeignKey(name = "FK_sucursal_empleado"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idSucursal")
	@JsonIdentityReference(alwaysAsId = true)
	private Sucursal sucursal;
	
	@OneToMany(mappedBy = "cajero", fetch=FetchType.EAGER)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEmpleado")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<Factura> cFacturas;
	
	@OneToMany(mappedBy = "vendedor", fetch=FetchType.EAGER)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEmpleado")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<Factura> vFacturas;
	
	
	public Empleado(){} 
	
	public Empleado(long cuil, boolean encargado, Sucursal sucursal) {
		super();
		this.cuil = cuil;
		this.encargado = encargado;
		this.sucursal = sucursal;
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
		result = prime * result + (int) (this.getIdPersona() ^ (this.getIdPersona() >>> 32));
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
		if (this.getIdPersona() != other.getIdPersona())
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [cuil=" + cuil + "idPersona=" + this.getIdPersona() +  ", encargado=" + encargado + ", sucursal=" + sucursal.getIdSucursal() +"]";
	}
	

}
