'use strict';

App.controller('RPCDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.rpcDetalleFacturas=[];
          self.rankingProductoCadenaDetalleFacturas = function(){
        	  DetalleFacturaService.rankingProductoCadenaDetalleFacturas()
                  .then(
					       function(d) {
						        self.rpcDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.rankingProductoCadenaDetalleFacturas();

      }]);
