'use strict';

App.controller('RCMSDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.rcmsDetalleFacturas=[];
          self.rankingClienteMontoSucursalDetalleFacturas = function(){
        	  DetalleFacturaService.rankingClienteMontoSucursalDetalleFacturas()
                  .then(
					       function(d) {
						        self.rcmsDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.rankingClienteMontoSucursalDetalleFacturas();

      }]);
