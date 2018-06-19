'use strict';

App.controller('TCMPSDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.tcmpsDetalleFacturas=[];
          self.totalCobranzaMPSucursalDetalleFacturas = function(){
        	  DetalleFacturaService.totalCobranzaMPSucursalDetalleFacturas()
                  .then(
					       function(d) {
						        self.tcmpsDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.totalCobranzaMPSucursalDetalleFacturas();

      }]);
