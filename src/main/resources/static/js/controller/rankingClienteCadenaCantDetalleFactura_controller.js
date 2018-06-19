'use strict';

App.controller('RCCDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.rccDetalleFacturas=[];
          self.rankingClienteCadenaCantDetalleFacturas = function(){
        	  DetalleFacturaService.rankingClienteCadenaCantDetalleFacturas()
                  .then(
					       function(d) {
						        self.rccDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.rankingClienteCadenaCantDetalleFacturas();

      }]);
