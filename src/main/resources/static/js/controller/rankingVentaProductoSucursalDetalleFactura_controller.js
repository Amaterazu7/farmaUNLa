'use strict';

App.controller('RPSDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.rpsDetalleFacturas=[];
          self.rankingProductoSucursalDetalleFacturas = function(){
        	  DetalleFacturaService.rankingProductoSucursalDetalleFacturas()
                  .then(
					       function(d) {
						        self.rpsDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.rankingProductoSucursalDetalleFacturas();

      }]);
