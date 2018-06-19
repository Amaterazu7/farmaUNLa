'use strict';

App.controller('TVSOSDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.tvsosDetalleFacturas=[];
          self.totalVentaSucursalObraSocialDetalleFacturas = function(){
        	  DetalleFacturaService.totalVentaSucursalObraSocialDetalleFacturas()
                  .then(
					       function(d) {
						        self.tvsosDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.totalVentaSucursalObraSocialDetalleFacturas();

      }]);
