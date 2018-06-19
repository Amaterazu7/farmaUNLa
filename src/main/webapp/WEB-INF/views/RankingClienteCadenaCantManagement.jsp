<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>  
		<meta charset="utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<title>Factura</title>
		<meta name="description" content=""/>
		<meta name="viewport" content="width=device-width"/>
		<base href="/detalleFactura"/>
    	<link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.min.css"> 
		<!--  
		<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
		-->
		<link rel="stylesheet" href="/webjars/font-awesome/css/font-awesome.min.css"></link>
	    <link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='css/style.css' />" rel="stylesheet"></link>
	    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    	<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</head>
  	<body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="RCCDetalleFacturaController as ctrl">
      
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading">
              	<h2>Lista Ranking Cliente Cadena Cantidad</h2>
              </div>
              <div class="tablecontainer">
                  <table class="table table-striped table-hover table-bordered">
                      <thead class="thead-dark">
                          	<tr>
                          		<th>ID</th>
                            	<th>Cliente	</th>
                            	<th>Cantidad Total</th>
                       		</tr>
						</thead>
						<tbody>
                          	<tr ng-repeat="df in ctrl.rccDetalleFacturas">
								<td><span ng-bind="df.idpersona"></span></td>
								<td><span ng-bind="df.nombre"></span></td>
								<td><span ng-bind="df.cantidadTotal"></span></td>
                        	</tr>
                      	</tbody>
                  	</table>
              	</div>
          	</div>
      	</div>
      
      	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
      	<script src="<c:url value='js/app.js' />"></script>
      	<script src="<c:url value='js/service/detalleFactura_service.js' />"></script>
      	<script src="<c:url value='js/controller/rankingClienteCadenaCantDetalleFactura_controller.js' />"></script>
	</body>
</html>