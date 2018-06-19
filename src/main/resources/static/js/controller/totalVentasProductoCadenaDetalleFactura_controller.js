'use strict';

App.controller('TVPCDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.tvpcDetalleFacturas=[];
          self.totalVentaProductoCadenaDetalleFacturas = function(){
        	  DetalleFacturaService.totalVentaProductoCadenaDetalleFacturas()
                  .then(
					       function(d) {
						        self.tvpcDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.totalVentaProductoCadenaDetalleFacturas();

      }]);
