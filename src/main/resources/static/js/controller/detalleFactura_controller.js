'use strict';

App.controller('DetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          //self.detalleFactura={id:null,price:'',number:'',profile:''};
          self.detalleFacturas=[];
              
          self.fetchAllDetalleFacturas = function(){
              DetalleFacturaService.fetchAllDetalleFacturas()
                  .then(
      					       function(d) {
      						        self.detalleFacturas = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
                 
          self.createDetalleFactura = function(detalleFactura){
              DetalleFacturaService.createDetalleFactura(detalleFactura)
		              .then(
                      self.fetchAllDetalleFacturas, 
				              function(errResponse){
					               console.error('Error while creating DetalleFactura.');
				              }	
                  );
          };

         self.updateDetalleFactura = function(detalleFactura, id){
              DetalleFacturaService.updateDetalleFactura(detalleFactura, id)
		              .then(
				              self.fetchAllDetalleFacturas, 
				              function(errResponse){
					               console.error('Error while updating DetalleFactura.');
				              }	
                  );
          };

         self.deleteDetalleFactura = function(id){
              DetalleFacturaService.deleteDetalleFactura(id)
		              .then(
				              self.fetchAllDetalleFacturas, 
				              function(errResponse){
					               console.error('Error while deleting DetalleFactura.');
				              }	
                  );
          };

          self.fetchAllDetalleFacturas();

          self.submit = function() {
              if(self.detalleFactura.id==null){
                  console.log('Saving New DetalleFactura', self.detalleFactura);    
                  self.createDetalleFactura(self.detalleFactura);
              }else{
                  self.updateDetalleFactura(self.detalleFactura, self.detalleFactura.id);
                  console.log('DetalleFactura updated with id ', self.detalleFactura.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.detalleFacturas.length; i++){
                  if(self.detalleFacturas[i].id == id) {
                     self.detalleFactura = angular.copy(self.detalleFacturas[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.detalleFactura.id === id) {//clean form if the detalleFactura to be deleted is shown there.
                 self.reset();
              }
              self.deleteDetalleFactura(id);
          };

          
          self.reset = function(){             
              self.detalleFactura={id:null,price:'',number:'',profile:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
