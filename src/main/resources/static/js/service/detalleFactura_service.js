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
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while fetching detalleFacturas');
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
