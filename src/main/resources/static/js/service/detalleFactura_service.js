'use strict';

App.factory('DetalleFacturaService', ['$http', '$q', function($http, $q){
	
	return {
		
			fetchAllDetalleFacturas: function() {
					return $http.get('http://localhost:8080/detalleFactura/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching detalleFacturas');
										return $q.reject(errResponse);
									}
							);
			},
			totalVentaSucursalDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/totalVentaSucursal/')
						.then(
								function(response){
									var consulTVS = response.data;
									var vts = [];
									for(var i = 0; i < consulTVS.length; i++) {
									    var consul = consulTVS[i];
									    var consulta = new Object();
									    consulta.producto = consul[0];
										consulta.cantidadTotal = consul[1];
										consulta.fecha = consul[2];
										consulta.localidad = consul[3];
										
										vts.push(consulta);
									}
									
									
									console.log(vts);
									return vts;
								}, 
								function(errResponse){
									console.error('Error while fetching totalVentaSucursal');
									return $q.reject(errResponse);
								}
						);
			},
			totalVentaCadenaDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/totalVentaCadena/')
						.then(
								function(response){
									var consulTVC = response.data;
									var vtc = [];
									for(var i = 0; i < consulTVC.length; i++) {
									    var consul = consulTVC[i];
									    var consulta = new Object();
									    consulta.producto = consul[0];
										consulta.cantidadTotal = consul[1];
										
										vtc.push(consulta);
									}
									
									
									console.log(vtc);
									return vtc;
								}, 
								function(errResponse){
									console.error('Error while fetching totalVentaCadena');
									return $q.reject(errResponse);
								}
						);
			},
	    
			
			
			
		    createDetalleFactura: function(detalleFactura){
					return $http.post('http://localhost:8080/detalleFactura/', detalleFactura)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating detalleFactura');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateDetalleFactura: function(detalleFactura, id){
					return $http.put('http://localhost:8080/detalleFactura/'+id, detalleFactura)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating detalleFactura');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteDetalleFactura: function(id){
					return $http.delete('http://localhost:8080/detalleFactura/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting detalleFactura');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
