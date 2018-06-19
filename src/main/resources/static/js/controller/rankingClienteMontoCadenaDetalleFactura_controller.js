'use strict';

App.controller('RCMCDetalleFacturaController', ['$scope', 'DetalleFacturaService', function($scope, DetalleFacturaService) {
          var self = this;
          
          self.rcmcDetalleFacturas=[];
          self.rankingClienteMontoCadenaDetalleFacturas = function(){
        	  DetalleFacturaService.rankingClienteMontoCadenaDetalleFacturas()
                  .then(
					       function(d) {
						        self.rcmcDetalleFacturas = d;
					       },
	    					function(errResponse){
	    						console.error('Error while fetching Currencies');
	    					}
      			       );
          };
          self.rankingClienteMontoCadenaDetalleFacturas();

      }]);
