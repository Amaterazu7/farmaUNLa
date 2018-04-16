package com.bd2FarmaUNLa.farmaUNLa.model;

import javax.persistence.*;

@Entity
public class DetalleFactura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idDetalleFactura")
	private long idDetalleFactura;
	private int cantidad;
	private long precioLista;
	private long precioVenta;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
	private Factura factura;
	
	
	public DetalleFactura(){} 
	
	public DetalleFactura(long idDetalleFactura, int cantidad, long precioLista, long precioVenta, Producto producto, Factura factura) {
		this.idDetalleFactura = idDetalleFactura;
		this.cantidad = cantidad;
		this.precioLista = precioLista;	
		this.precioVenta = precioVenta;		
		this.producto = producto;
		this.factura = factura;
	}
	
	
	public long getIdDetalleFactura() {
		return idDetalleFactura;
	}
	public void setId(long idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
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
		result = prime * result + (int) (idDetalleFactura ^ (idDetalleFactura >>> 32));
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
		if (idDetalleFactura != other.idDetalleFactura)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [idDetalleFactura=" + idDetalleFactura  + ", cantidad=" + cantidad  + "precioLista=" + precioLista + "precioVenta=" + precioVenta + ", producto=" + producto.getIdProducto() + ", factura=" + factura.getIdFactura()  + "]";
	}
	

}
