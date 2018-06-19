'use strict';

App.controller('TVCDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.tvcDetalleFacturas=[];
          self.totalVentaCadenaDetalleFacturas = function(){
        	  DetalleFacturaService.totalVentaCadenaDetalleFacturas()
                  .then(
					       function(d) {
						        self.tvcDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.totalVentaCadenaDetalleFacturas();

      }]);
