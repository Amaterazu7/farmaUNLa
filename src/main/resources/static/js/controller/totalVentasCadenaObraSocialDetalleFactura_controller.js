'use strict';

App.controller('TVCOSDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.tvcosDetalleFacturas=[];
          self.totalVentaCadenaObraSocialDetalleFacturas = function(){
        	  DetalleFacturaService.totalVentaCadenaObraSocialDetalleFacturas()
                  .then(
					       function(d) {
						        self.tvcosDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.totalVentaCadenaObraSocialDetalleFacturas();

      }]);
