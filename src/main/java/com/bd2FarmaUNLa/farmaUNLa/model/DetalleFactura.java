package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.*;

@Entity
public class DetalleFactura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idDetalleFactura")
	private long id;
	private int cantidad;
	private long precioLista;
	private long precioVenta;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
	private Producto producto;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
	private Factura factura;
	
	public DetalleFactura(){} 
	
	public DetalleFactura(long id, int cantidad, long precioLista, long precioVenta, Producto producto, Factura factura) {
		this.id = id;
		this.cantidad = cantidad;
		this.precioLista = precioLista;	
		this.precioVenta = precioVenta;		
		this.producto = producto;
		this.factura = factura;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
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
		return "Customer [id=" + id  + ", cantidad=" + cantidad  + "precioLista=" + precioLista + "precioVenta=" + precioVenta + ", producto=" + producto.getId()  + ", factura=" + factura.getId()  + "]";
	}
	

}
