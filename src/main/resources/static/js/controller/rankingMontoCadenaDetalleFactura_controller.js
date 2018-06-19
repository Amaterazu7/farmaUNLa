'use strict';

App.controller('RMCDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.rmcDetalleFacturas=[];
          self.rankingMontoCadenaDetalleFacturas = function(){
        	  DetalleFacturaService.rankingMontoCadenaDetalleFacturas()
                  .then(
					       function(d) {
						        self.rmcDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.rankingMontoCadenaDetalleFacturas();

      }]);
