# FarmaUNLa

Projecto de desarrollo para la cátedra Base de Datos II, de la Licenciatura en Sistemas de la Universidad Nacional de Lanús.

## Comencemos

Las siguientes instrucciones te permitirán levantar el proyecto desarrollado en Spring Boot + MySQL.

![-DER](http://github.com/Amaterazu7/farmaUNLa/blob/ac043b3eb9b53f88234ef3810f04e6081b142b08/DER.png)

![-Script con Set de Datos](http://github.com/Amaterazu7/farmaUNLa/blob/ac043b3eb9b53f88234ef3810f04e6081b142b08/ExportBase-21-06-2018.sql)

### Prerequisitos

Para poder levantar la API será necesario tener instalado un entorno de desarrollo que cuente con:

* La IDE Eclipse (dentro de lo posible Oxygen o superior)

* Tener como gestor de Base de datosMySQL

* Descargarse el plugin [Spring Tools Suit desde el Eclipse Marketplace](https://marketplace.eclipse.org/content/spring-tools-aka-spring-ide-and-spring-tool-suite) (podes arrastrar el botón "install" desde la página a tu Eclips y se instalará solo).

### Instalación

- 1: Una vez instalado todo, deberías bajarte este proyecto a tu entorno local, ya sea descargandote como un .zip, o más bien por consola con un "git clone git@github.com:Amaterazu7/farmaUNLa.git".

- 2: Importar el proyecto desde tu eclipse desde la carpeta descargada, y configurar el archivo "application.properties" acorde a tus credenciales de base de datos. (username & password)

- 3: Para correr el proyecto, teniendo la herramienta que nos provee Pivotal, Spring Tools Suit deberías correr el proyecto desde el **Boot Dashboard** como se ve [aquí](http://github.com/Amaterazu7/farmaUNLa/blob/ac043b3eb9b53f88234ef3810f04e6081b142b08/ExportBase-21-06-2018.sql), cabe destacar que Spring boot te proporciona un tomcat8 embebido dentro de la aplicación, con lo que no hace falta configurar nada relacionado a esto.

```
En cado de que quieras saber más a certa de las escificaciones de Spring Boot, podes pegarle una mirada a las guías de Spring: https://spring.io/guides. Ellos te proporcinan un muy compresivo set de tutoriales de tipo step-by-step para entender mejor las carácteristicas de Spring.
```

- 4: Una vez levantado el server, (puede ser que la primera vez que levante se tome su tiempo porque Maven va a comparar y/o descargar lo necesario para levantar el proyecto), deberías ir a un explorador y entrar a "http://localhost:8080/" donde verás la interfaz con items en donde mostramos tablas con los puntos para el cliente de la cadena de farmacias.

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

2. Detalle y totales de ventas para la cadena completa y por sucursal, por obra social o 
privados entre fechas.

3. Detalle y totales de cobranza para la cadena completa y por sucursal, por medio de pago 
y entre fechas.

4. Detalle y totales de ventas de productos, total de la cadena y por sucursal, entre fechas, 
diferenciados entre farmacia y perfumería.

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

Este projecto fue desarrollado bajo al licencia MIT License - ver el siguiente archivo [LICENSE.md](LICENSE.md) para más detalles
