'use strict';

App.controller('RCSDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.rcsDetalleFacturas=[];
          self.rankingClienteSucursalCantDetalleFacturas = function(){
        	  DetalleFacturaService.rankingClienteSucursalCantDetalleFacturas()
                  .then(
					       function(d) {
						        self.rcsDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.rankingClienteSucursalCantDetalleFacturas();

      }]);
