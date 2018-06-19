'use strict';

App.factory('EmpleadoService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllEmpleados: function() {
					return $http.get('http://localhost:8080/empleado/')
							.then(
									function(response){
									    console.log(response.data);
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching empleados');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createEmpleado: function(empleado){
					return $http.post('http://localhost:8080/empleado/', empleado)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating empleado');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateEmpleado: function(empleado, id){
					return $http.put('http://localhost:8080/empleado/'+id, empleado)
							.then(
									function(response){
									    console.log(empleado)
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating empleado');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteEmpleado: function(id){
					return $http.delete('http://localhost:8080/empleado/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting empleado');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
