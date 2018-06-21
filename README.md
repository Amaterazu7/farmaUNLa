# FarmaUNLa

Projecto de desarrollo para la cátedra Base de Datos II, de la Licenciatura en Sistemas de la Universidad Nacional de Lan\ús.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

![-DER](http://github.com/Amaterazu7/farmaUNLa/blob/ac043b3eb9b53f88234ef3810f04e6081b142b08/DER.png)

![-z](http://github.com/Amaterazu7/farmaUNLa/blob/ac043b3eb9b53f88234ef3810f04e6081b142b08/DER.png)

### Prerequisitos



### Instalación



## Descripción del problema:

Una cadena de farmacias nos pide informatizar la operatoria de su negocio. Como resultado del relevamiento del mismo, obtenemos la siguiente información:

La farmacia vende medicamentos y productos de perfumería.

* Algunos clientes tienen obra social y otros son privados.

* De todos los clientes se registran apellido, nombre, DNI, domicilio (calle, número, localidad, provincia), obra social si la tiene (nombre de la obra social y número de afiliado)

* De los empleados se requiere conocer el apellido, nombre, DNI, CUIL, domicilio (calle, número, localidad, provincia) y obra social a la que aporta (nombre de la obra social y número de afiliado).

* De cada producto se requiere conocer si es un medicamento o producto de perfumería, una descripción, el laboratorio que lo produce, un código numérico y el precio.

* De cada venta se registra: fecha, número de ticket, total de la venta, forma de pago (efectivo, tarjeta o débito), productos vendidos con sus cantidades, precio unitario y total; empleado que atendió al cliente y el empleado que realizó el cobro en caja.

* De cada sucursal se conoce que empleados pertenecen a la misma, el domicilio (calle, número, localidad, provincia) y cuál de los empleados es encargado de la misma. 

* El número de ticket se emite con un punto de venta distinto para cada sucursal (el punto de venta de identifica con los primeros cuatro números del ticket fiscal, ej: 0001-00001234 es punto de venta.

### El cliente desea que el sistema le provea la siguiente información:

```
1. Detalle y totales de ventas para la cadena completa y por sucursal, entre fechas.

2. Detalle y totales de ventas para la cadena completa y por sucursal, por obra social o privados entre fechas.

3. Detalle y totales de cobranza para la cadena completa y por sucursal, por medio de pago y entre fechas.

4. Detalle y totales de ventas de productos, total de la cadena y por sucursal, entre fechas, diferenciados entre farmacia y perfumería.

5. Ranking de ventas de productos, total de la cadena y por sucursal, entre fechas, por monto.

6. Ranking de ventas de productos, total de la cadena y por sucursal, entre fechas, por cantidad vendida.

7. Ranking de clientes por compras, total de la cadena y por sucursal, entre fechas, por monto.

8. Ranking de clientes por compras, total de la cadena y por sucursal, entre fechas, por cantidad vendida.
```

## Autores

* **Gino Nazzi**

* **Leando Rolle**

* **Diego Cañete**

## Licencia

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
