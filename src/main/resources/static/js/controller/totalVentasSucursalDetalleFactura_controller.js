'use strict';

App.controller('TVSDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.tvsDetalleFacturas=[];
          console.log(self.tvsDetalleFacturas);
          self.totalVentaSucursalDetalleFacturas = function(){
        	  DetalleFacturaService.totalVentaSucursalDetalleFacturas()
                  .then(
					       function(d) {
						        self.tvsDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          console.log(self.tvsDetalleFacturas);
          self.totalVentaSucursalDetalleFacturas();

      }]);
