<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>  
		<meta charset="utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<title>Home</title>
		<meta name="description" content=""/>
		<meta name="viewport" content="width=device-width"/>
		<base href="/"/>
    	<link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.min.css"> 
    	<link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.css"> 
    	<link rel="stylesheet" href="https://bootswatch.com/4/lux/_variables.scss"> 
    	<link rel="stylesheet" href="https://bootswatch.com/4/lux/_bootswatch.scss"> 
		<!--
		<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
		<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
		-->
	    <link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='css/style.css' />" rel="stylesheet"></link>
	    <script type="text/javascript" src="/bootstrap/js/jquery.min.js"></script>
    	<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
  	</head>
  	<body ng-app="myApp" class="ng-cloak">
    	<!-- <div class="" ng-controller="UserController as ctrl">  -->
          <div class="" >
			<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
				<a class="navbar-brand" href="#">FarmaUNLa</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
		  			<span class="navbar-toggler-icon"></span>
				</button>
				
				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active">
							<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/factura/">Facturacion</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/empleado/">Empleados</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/sucursal/">Sucursales</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/persona/">Personas</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/producto/">Productos</a>
						</li>
					</ul>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="text" placeholder="Search">
						<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
					</form>
				</div>
			</nav>          

      	</div>
		<div class="jumbotron">
			<h1 class="display-3">Bienvenido!</h1>
		  		<p class="lead"></p>
		  		<hr class="my-4">
         	<div class="list-group">
		  		<a href="/detalleFactura" class="list-group-item list-group-item-action active">
		    		Detalles de Facturas
		  		</a>
		  		
		  		<a href="/detalleFactura/totalVentaCadena" class="list-group-item list-group-item-action disabled">Total Venta Cadena</a>
		  		<a href="/detalleFactura/totalVentaSucursal" class="list-group-item list-group-item-action">Total Venta Sucursal</a>
		  		<a href="/detalleFactura/totalVentaCadenaObrasocial" class="list-group-item list-group-item-action">Total Venta Cadena Obra Social</a>
		  		<a href="/detalleFactura/totalVentaSucursalObrasocial" class="list-group-item list-group-item-action disabled">Total Venta Sucursal Obra Social</a>
		  		<a href="/detalleFactura/totalCobranzaMPCadena" class="list-group-item list-group-item-action">Total Cobranza Medio de Pago Cadena</a>
		  		<a href="/detalleFactura/totalCobranzaMPSucursal" class="list-group-item list-group-item-action disabled">Total Cobranza Medio de Pago Sucursal</a>
		  		<a href="/detalleFactura/totalVentaProductoCadena" class="list-group-item list-group-item-action">Total Venta Producto Cadena</a>
		  		<a href="/detalleFactura/totalVentaProductoSucursal" class="list-group-item list-group-item-action disabled">Total Venta Producto Sucursal</a>
		  		<a href="/detalleFactura/rankingVentaCadenaMonto" class="list-group-item list-group-item-action">Ranking Venta Cadena Monto</a>
		  		<a href="/detalleFactura/rankingVentaSucursalMonto" class="list-group-item list-group-item-action disabled">Ranking Venta Cadena Monto</a>
		  		<a href="/detalleFactura/rankingVentaCadenaCant" class="list-group-item list-group-item-action">Ranking Venta Producto Cadena Cant</a>
		  		<a href="/detalleFactura/rankingVentaSucursalCant" class="list-group-item list-group-item-action disabled">Ranking Venta Producto Sucursal Cant</a>
		  		<a href="/detalleFactura/rankingClienteCadenaMonto" class="list-group-item list-group-item-action">Ranking Cliente Cadena Monto</a>
		  		<a href="/detalleFactura/rankingClienteSucursalMonto" class="list-group-item list-group-item-action disabled">Ranking Cliente Sucursal Monto</a>
		  		<a href="/detalleFactura/rankingClienteCadenaCant" class="list-group-item list-group-item-action">Ranking Cliente Cadena Cant</a>
		  		<a href="/detalleFactura/rankingClienteSucursalCant" class="list-group-item list-group-item-action disabled">Ranking Cliente Sucursal Cant</a>
			</div>
        	<p></p>
		</div>
		
		
		
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
		<script src="<c:url value='js/app.js' />"></script>
		<!-- 
		<script src="<c:url value='js/service/user_service.js' />"></script>
		<script src="<c:url value='js/controller/user_controller.js' />"></script>
		  -->
	</body>
</html>