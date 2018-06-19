'use strict';

App.controller('TCMPCDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.tcmpcDetalleFacturas=[];
          self.totalCobranzaMPCadenaDetalleFacturas = function(){
        	  DetalleFacturaService.totalCobranzaMPCadenaDetalleFacturas()
                  .then(
					       function(d) {
						        self.tcmpcDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.totalCobranzaMPCadenaDetalleFacturas();

      }]);
