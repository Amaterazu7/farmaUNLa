'use strict';

App.controller('EmpleadoController', ['$scope', 'EmpleadoService', function($scope, EmpleadoService) {
          var self = this;
          
          self.empleado={idPersona:null, dni:'',numAfiliado:'',apellido:'',nombre:'',calle:'',numero:'',localidad:'',obraSocial:'',cuil:'',encargado:'',sucursal:{}};
          self.empleados=[];
          self.sucursales=[];
          self.sucursalSelected="";
          
          self.fetchAllEmpleados = function(){
              EmpleadoService.fetchAllEmpleados()
                  .then(
      					       function(d) {
      						        self.empleados = d.Empleado;
      						        self.sucursales = d.Sucursal;
      						        console.log(d);
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
           
          self.createEmpleado = function(empleado){
              EmpleadoService.createEmpleado(empleado)
		              .then(
                      self.fetchAllEmpleados, 
				              function(errResponse){
					               console.error('Error while creating Empleado.');
				              }	
                  );
          };

         self.updateEmpleado = function(empleado, id){
              EmpleadoService.updateEmpleado(empleado, id)
		              .then(
				              self.fetchAllEmpleados, 
				              function(errResponse){
					               console.error('Error while updating Empleado.');
				              }	
                  );
          };

         self.deleteEmpleado = function(id){
              EmpleadoService.deleteEmpleado(id)
		              .then(
				              self.fetchAllEmpleados, 
				              function(errResponse){
					               console.error('Error while deleting Empleado.');
				              }	
                  );
          };

          self.fetchAllEmpleados();

          self.submit = function() {
              
              self.empleado.sucursal=JSON.parse(self.sucursalSelected);
              console.log(self.empleado.encargado);
              console.log(self.empleado);
              if(self.empleado.id==null){
                  console.log('Saving New Empleado', self.empleado);    
                  self.createEmpleado(self.empleado);
              }else{
                  self.updateEmpleado(self.empleado, self.empleado.id);
                  console.log('Empleado updated with id ', self.empleado.id);
              }
              self.reset();
          };
              
          self.edit = function(id){              
              console.log('id to be edited', id);
              for(var i = 0; i < self.empleados.length; i++){
                  if(self.empleados[i].id == id) {
                     self.empleado = angular.copy(self.empleados[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.empleado.id === id) {//clean form if the empleado to be deleted is shown there.
                 self.reset();
              }
              self.deleteEmpleado(id);
          };

          
          self.reset = function(){
              self.empleado={idPersona:null, dni:'',numAfiliado:'',apellido:'',nombre:'',calle:'',numero:'',localidad:'',obraSocial:'',cuil:'',encargado:'',sucursal:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
