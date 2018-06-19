'use strict';

App.controller('RMSDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.rmsDetalleFacturas=[];
          self.rankingMontoSucursalDetalleFacturas = function(){
        	  DetalleFacturaService.rankingMontoSucursalDetalleFacturas()
                  .then(
					       function(d) {
						        self.rmsDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.rankingMontoSucursalDetalleFacturas();

      }]);
