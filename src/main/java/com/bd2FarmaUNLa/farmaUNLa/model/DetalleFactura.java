package com.bd2FarmaUNLa.farmaUNLa.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DetalleFactura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int codigoFactura;
	private int cantidad;
	private long precioLista;
	private long precioVenta;
	private Producto producto;
	
	public DetalleFactura(){} 
	
	public DetalleFactura(int id, int cantidad, long precioLista, long precioVenta, Producto producto) {
		this.id = id;
		this.cantidad = cantidad;
		this.precioLista = precioLista;	
		this.precioVenta = precioVenta;		
		this.producto = producto;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
		
	public long getPrecioLista() {
		return precioLista;
	}
	public void setPrecioLista(long precioLista) {
		this.precioLista = precioLista;
	}

	public long getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(long precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
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
		if (!(obj instanceof DetalleFactura))
			return false;
		DetalleFactura other = (DetalleFactura) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id  + ", codigoFactura=" + codigoFactura  + ", cantidad=" + cantidad  + "precioLista=" + precioLista + "precioVenta=" + precioVenta + ", producto=" + producto  + "]";
	}
	

}
