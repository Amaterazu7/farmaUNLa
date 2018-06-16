'use strict';

App.factory('TotalVentaSucursalDetalleFacturaService', ['$http', '$q', function($http, $q){

	return {
		
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
			}
		
	};

}]);
