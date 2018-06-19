'use strict';

App.controller('TVPSDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.tvpsDetalleFacturas=[];
          self.totalVentaProductoSucursalDetalleFacturas = function(){
        	  DetalleFacturaService.totalVentaProductoSucursalDetalleFacturas()
                  .then(
					       function(d) {
						        self.tvpsDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.totalVentaProductoSucursalDetalleFacturas();

      }]);
