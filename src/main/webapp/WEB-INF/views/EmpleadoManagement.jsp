<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>  
		<meta charset="utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<title>Empleado</title>
		<meta name="description" content=""/>
		<meta name="viewport" content="width=device-width"/>
		<base href="/empleado"/>
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
    	<div class="generic-container" ng-controller="EmpleadoController as ctrl">
        	<!-- 
        	<div class="panel panel-default">
            	<div class="panel-heading">
            		<h2>Registracion de Empleados</h2>
              	</div>
              	<div class="alert alert-dismissible alert-info">
                  	<form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    	<input type="hidden" ng-model="ctrl.empleado.id" />
                    	<div class="row">
                        	<div class="form-group col-md-12">
                            	<label class="col-md-2 control-lable" for="file">Name</label>
                              	<div class="col-md-7">
                                	<input type="text" ng-model="ctrl.empleado.name" name="name" class="username form-control input-sm" placeholder="Enter your name." required ng-minlength="3"/>
                                  	<div class="has-error" ng-show="myForm.$dirty">
                                    	<span ng-show="myForm.name.$error.required">This is a required field</span>
                                      	<span ng-show="myForm.name.$error.minlength">Minimum length required is 3</span>
                                      	<span ng-show="myForm.name.$invalid">This field is invalid </span>
                                  	</div>
                              	</div>
                          	</div>
                      	</div>
                      
                      	<div class="row">
	                    	<div class="form-group col-md-12">
	                        	<label class="col-md-2 control-lable" for="file">DNI</label>
	                            <div class="col-md-7">
	                            	<input type="number" ng-model="ctrl.empleado.dni" name="dni" class="form-control input-sm" placeholder="Enter your DNI."  required ng-maxlength="8"/>
	                              	<div class="has-error" ng-show="myForm.$dirty">
	                                	<span ng-show="myForm.dni.$error.required">This is a required field</span>
	                                    <span ng-show="myForm.dni.$error.maxlength">Minimum length required is 8</span>
	                                    <span ng-show="myForm.dni.$invalid">This field is invalid </span>
	                                </div>
	                            </div>
	                        </div>
                  		</div>
					  	
					  	<div class="row">
							<div class="form-group col-md-12">
						        <label class="col-md-2 control-lable" for="file">Select the Pack</label>
						        <div class="col-md-7">
						        	<select class="form-control" ng-model="ctrl.packSelected">
						        		<option ng-repeat="p in ctrl.packs" value="{{p}}">{{p.profile}} - $ {{p.price}}</option>
						        	</select>  
						   	    </div>
						   	    <div style="padding-left: 30px;padding-top: 5px;">
						   	    	<div class="col-md-7 custom-control custom-checkbox">
				                    	<input type="checkbox" class="custom-control-input" id="familyCheck" ng-model="ctrl.empleado.benefits">
				                    	<label class="custom-control-label" for="familyCheck">Check this if it includes the promotion Family Rental.</label>
				                	</div>
				                </div>
						    </div>
						</div>	
						
						<div class="row">
							<div class="form-group col-md-12">
						        <label class="col-md-2 control-lable" for="file">Bikes</label>
						        <div class="col-md-7">
						            <input type="number" ng-model="ctrl.empleado.sumBikes" class="form-control input-sm" placeholder="Enter Number of Bikes."/>                              	  
						   	    </div>
						    </div>
						</div>	 
						
						<div class="row">
						    <div class="form-group col-md-12">
						        <label class="col-md-2 control-lable" for="file">Discount</label>
						        <div class="col-md-7">
						            <input type="number" ng-model="ctrl.empleado.discount" class="form-control input-sm" placeholder="Enter Discount."/>                              	  
						        </div>
						    </div>
						</div>
						
						<div class="row">
						    <div class="form-group col-md-12">
						        <label class="col-md-2 control-lable" for="file">Total Price</label>
						        <div class="col-md-7">
						            <input type="number" ng-model="ctrl.empleado.price" class="form-control input-sm" placeholder="Enter Final Price."/>                              	  
						        </div>
						    </div>
						</div>
						 
                      	<div class="row">
                          	<div class="form-group col-md-12">
                              	<label class="col-md-2 control-lable" for="file">Start Date</label>
                              	<div class="col-md-7">
                                  	<input type="date" ng-model="ctrl.empleado.startDate" name="startDate" class="username form-control input-sm" placeholder="Enter start day yyyy-MM-dd" required/>
                                  	<div class="has-error" ng-show="myForm.$dirty">
                                      	<span ng-show="myForm.startDate.$error.required">This is a required field</span>
                                  	</div>
                              	</div>
                          	</div>
                      	</div>
						
						<div class="row">
						    <div class="form-actions floatRight" style="padding: 0.9rem;">
						        <input type="submit"  value="{{!ctrl.empleado.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
						        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
						    </div>
						</div>
                	</form>
              	</div>
          	</div>
			<div class="panel panel-default">
            	<!-- Default panel contents -->
            -->	
              	<div class="panel-heading">
              		<h2>Lista de Empleados</h2>
              	</div>
              	<div class="tablecontainer">
					<table class="table table-striped table-hover table-bordered">
					    <thead class="thead-dark">
					        <tr>
					            <th>ID</th>
					            <th>DNI</th>
					            <th>N°Afiliado</th>
					            <th>Apellido</th>
					            <th>Name</th>
					            <th>Calle</th>
					            <th>Numero</th>
					            <th>Localidad</th>
					            <th>ObraSocial</th>
					            <th>Encargado</th>
					            <th>Sucursal</th>
					            <th width="18%"></th>
					        </tr>
					    </thead>
					    <tbody>
					        <tr ng-repeat="e in ctrl.empleados">
					            <td><span ng-bind="e.idPersona"></span></td>
					            <td><span ng-bind="e.dni"></span></td>
					            <td><span ng-bind="e.numAfiliado"></span></td>
					            <td><span ng-bind="e.apellido"></span></td>
					            <td><span ng-bind="e.nombre"></span></td>
					            <td><span ng-bind="e.calle"></span></td>
					            <td><span ng-bind="e.numero"></span></td>
					            <td><span ng-bind="e.localidad"></span></td>
					            <td><span ng-bind="e.obraSocial"></span></td>
					            <td><span ng-bind="e.cuil"></span></td>
					            <td><span ng-bind="e.encargado"></span></td>
					            <td><span ng-bind="e.sucursal"></span></td>
					            <td>
									<button type="button" ng-click="ctrl.edit(c.id)" class="btn btn-success custom-width">
										<i class="fa fa-pencil-square-o f-2" aria-hidden="true"></i>
									</button>  
									<button type="button" ng-click="ctrl.remove(c.id)" class="btn btn-danger custom-width">
										<i class="fa fa-trash f-2" aria-hidden="true"></i>
									</button>
					            </td>
					        </tr>
					    </tbody>
					</table>
				</div>
			</div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='js/app.js' />"></script>
      <script src="<c:url value='js/service/empleado_service.js' />"></script>
      <script src="<c:url value='js/controller/empleado_controller.js' />"></script>
  </body>
</html>