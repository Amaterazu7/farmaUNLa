package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.*;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idProducto")
	private long id;
	private int codigo;
	private String descripcion;
	private long precio;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTipoProducto", referencedColumnName = "idTipoProducto")
	private TipoProducto tipoProducto;
	
	public Producto(){} 
	
	public Producto(long id, int codigo, String descripcion, long precio, TipoProducto tipoProducto) {
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public long getPrecio() {
		return precio;
	}
	public void setPrecio(long precio) {
		this.precio = precio;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
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
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id  + ", codigo=" + codigo  + ", descripcion=" + descripcion  + ", precio=" + precio  + ", tipoProducto=" + tipoProducto.getId()  + "]";
	}
	

}
