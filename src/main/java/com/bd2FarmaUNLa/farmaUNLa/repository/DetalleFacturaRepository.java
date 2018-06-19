package com.bd2FarmaUNLa.farmaUNLa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.bd2FarmaUNLa.farmaUNLa.model.DetalleFactura;
import com.bd2FarmaUNLa.farmaUNLa.model.Persona;

public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, Long> {
	
	DetalleFactura findById(long id);
	/*
	@Query("select df from DetalleFactura df")
	List<DetalleFactura> findAllCadenaDetalleFacturas();
	*/
	
/*1 total x cantidad cadena */
	@Query("select prod.idProducto, prod.descripcion, sum(df.cantidad) as cantidadTotal from DetalleFactura as df "
			+ "inner join df.producto as prod inner join df.factura as fact where fact.fecha between '2018-05-03' and '2018-06-20' group by prod.idProducto")
	List<DetalleFactura> totalVentaCadena();
/*1 total x cantidad sucursal */
	@Query("select prod.idProducto, prod.descripcion as producto, sum(df.cantidad) as cantidadTotal, fact.fecha as fecha, suc.calle as localidad from DetalleFactura as df "
			+ "inner join df.producto as prod inner join df.factura as fact inner join fact.sucursal as suc "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' group by prod.idProducto, suc.idSucursal")
	List<DetalleFactura> totalVentaSucursal();

	
/*2 total cantidad cadena x obra social */
	@Query("select prod.idProducto, prod.descripcion, os.nombre, sum(df.cantidad) as cantidadTotal from DetalleFactura as df "
			+ "inner join df.producto as prod inner join df.factura as fact inner join fact.cliente as cli "
			+ "inner join cli.obraSocial os "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' group by prod.idProducto, os.idObraSocial")
	List<DetalleFactura> totalVentaCadenaObrasocial();
/*2 total cantidad sucursal x obra social */
	@Query("select prod.idProducto, prod.descripcion, os.nombre, sum(df.cantidad) as cantidadTotal, suc.calle from DetalleFactura as df "
			+ "inner join df.producto as prod inner join df.factura as fact inner join fact.cliente as cli "
			+ "inner join cli.obraSocial os inner join fact.sucursal as suc "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' group by prod.idProducto, os.idObraSocial, suc.idSucursal")
	List<DetalleFactura> totalVentaSucursalObrasocial();

	
/*3 total cadena por medio de pago */
	@Query("select sum(df.cantidad) as cantidadTotal, sum(df.cantidad*df.precioVenta) as totalVenta, fp.descripcion from DetalleFactura df inner join df.factura as fact "
			+ "inner join fact.formaDePago as fp where fact.fecha between '2018-05-03' and '2018-06-20' group by fp.idFormaDePago ")
	List<DetalleFactura> totalCobranzaMPCadena();
/*3 total sucursales por medio de pago */
	@Query("select sum(df.cantidad) as cantidadTotal, sum(df.cantidad*df.precioVenta) as totalVenta, fp.descripcion, suc.calle as calle from DetalleFactura df inner join df.factura as fact "
			+ "inner join fact.formaDePago as fp inner join fact.sucursal as suc "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' group by fp.idFormaDePago, suc.idSucursal ")
	List<DetalleFactura> totalCobranzaMPSucursal();

	
/*4 total ventas productos cadena farmacia y perfumeria  */
	@Query("select sum(df.cantidad) as cantidadTotal, sum(df.cantidad*df.precioVenta) as totalVenta, tp.nombre from DetalleFactura df "
			+ "inner join df.factura as fact inner join df.producto as prod inner join prod.tipoProducto as tp "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' group by tp.idTipoProducto ")
	List<DetalleFactura> totalVentaProductoCadena();
/*4 total ventas productos sucursal farmacia y perfumeria  */
	@Query("select sum(df.cantidad) as cantidadTotal, sum(df.cantidad*df.precioVenta) as totalVenta, tp.nombre from DetalleFactura df "
			+ "inner join df.factura as fact inner join df.producto as prod inner join prod.tipoProducto as tp "
			+ "inner join fact.sucursal as suc "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' group by tp.idTipoProducto, suc.idSucursal ")
	List<DetalleFactura> totalVentaProductoSucursal();

	
/*5 ranking ventas productos x monto cadena  */
	@Query("select prod.idProducto, prod.descripcion, sum(df.precioVenta*df.cantidad) as totalVenta from DetalleFactura as df "
			+ "inner join df.producto as prod inner join df.factura as fact "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' group by prod.idProducto "
			+ "order by totalVenta desc")
	List<DetalleFactura> rankingVentaCadenaMonto();
/*5 ranking ventas productos x monto sucursal  */
	@Query("select prod.idProducto, prod.descripcion, sum(df.precioVenta*df.cantidad) as totalVenta, suc.calle from DetalleFactura as df "
			+ "inner join df.producto as prod inner join df.factura as fact "
			+ "inner join fact.sucursal as suc "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' group by prod.idProducto, suc.idSucursal "
			+ "order by totalVenta desc")
	List<DetalleFactura> rankingVentaSucursalMonto();
	
	
/*6 ranking venta de productos x cantidad vendida cadena */
	@Query("select prod.idProducto, prod.descripcion, sum(df.cantidad) as cantidadTotal from DetalleFactura as df "
			+ "inner join df.factura as fact inner join df.producto as prod "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' "
			+ "group by prod.idProducto "
			+ "order by cantidadTotal desc")
	List<DetalleFactura> rankingVentaCadenaCant();
/*6 ranking venta de productos x cantidad vendida sucursal */
	@Query("select prod.idProducto, prod.descripcion, sum(df.cantidad) as cantidadTotal, suc.calle from DetalleFactura as df "
			+ "inner join df.factura as fact inner join df.producto as prod inner join fact.sucursal as suc "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' "
			+ "group by prod.idProducto, suc.idSucursal "
			+ "order by cantidadTotal desc")
	List<DetalleFactura> rankingVentaSucursalCant();

	
/*7 ranking clientes x monto total cadena*/
	@Query("select cli.idPersona, cli.nombre, sum(df.cantidad*df.precioVenta) as ventaTotal from DetalleFactura as df "
			+ "inner join df.factura as fact inner join fact.cliente as cli  "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' "
			+ "group by cli.idPersona "
			+ "order by ventaTotal desc")
	List<DetalleFactura> rankingClienteCadenaMonto();
/*7 ranking clientes x monto total sucursal*/
	@Query("select cli.idPersona, cli.nombre, sum(df.cantidad*df.precioVenta) as ventaTotal, suc.calle from DetalleFactura as df "
			+ "inner join df.factura as fact inner join fact.cliente as cli inner join fact.sucursal as suc "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' "
			+ "group by cli.idPersona, suc.idSucursal "
			+ "order by ventaTotal desc")
	List<DetalleFactura> rankingClienteSucursalMonto();

/*8 ranking clientes x compra cantidad cadena  */
	@Query("select cli.idPersona, cli.nombre, sum(df.cantidad) as cantidadTotal from DetalleFactura as df "
			+ "inner join df.factura as fact inner join fact.cliente as cli  "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' "
			+ "group by cli.idPersona "
			+ "order by cantidadTotal desc")
	List<DetalleFactura> rankingClienteCadenaCant();
/*8 ranking clientes x compra cantidad sucursal  */
	@Query("select cli.idPersona, cli.nombre, sum(df.cantidad) as cantidadTotal, suc.calle from DetalleFactura as df "
			+ "inner join df.factura as fact inner join fact.cliente as cli inner join fact.sucursal as suc "
			+ "where fact.fecha between '2018-05-03' and '2018-06-20' "
			+ "group by cli.idPersona, suc.idSucursal "
			+ "order by cantidadTotal desc")
	List<DetalleFactura> rankingClienteSucursalCant();
	
}