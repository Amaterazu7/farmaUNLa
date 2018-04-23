package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idProducto")
	private long idProducto;
	private int codigo;
	private String descripcion;
	private long precio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTipoProducto", referencedColumnName = "idTipoProducto", nullable = false, foreignKey = @ForeignKey(name = "FK_tipoProducto_producto"))
	@JsonManagedReference
	private TipoProducto tipoProducto;
	
	
	public Producto(){} 
	
	public Producto(long idProducto, int codigo, String descripcion, long precio, TipoProducto tipoProducto) {
		this.idProducto = idProducto;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
	}
	
	
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
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
		result = prime * result + (int) (idProducto ^ (idProducto >>> 32));
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
		if (idProducto != other.idProducto)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [idProducto=" + idProducto  + ", codigo=" + codigo  + ", descripcion=" + descripcion  + ", precio=" + precio  + ", tipoProducto=" + tipoProducto.getIdTipoProducto()  + "]";
	}
	

}
