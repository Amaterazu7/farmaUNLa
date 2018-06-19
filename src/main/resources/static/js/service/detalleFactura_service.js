'use strict';

App.factory('DetalleFacturaService', ['$http', '$q', function($http, $q){
	
	return {
		
			fetchAllDetalleFacturas: function() {
					return $http.get('http://localhost:8080/detalleFactura/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching detalleFacturas');
										return $q.reject(errResponse);
									}
							);
			},
			totalVentaCadenaDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/totalVentaCadena/')
						.then(
								function(response){
									var consulTVC = response.data;
									var vtc = [];
									for(var i = 0; i < consulTVC.length; i++) {
									    var consul = consulTVC[i];
									    var consulta = new Object();
									    consulta.idproducto = consul[0];
									    consulta.producto = consul[1];
										consulta.cantidadTotal = consul[2];
										
										vtc.push(consulta);
									}
									console.log(vtc);
									return vtc;
								}, 
								function(errResponse){
									console.error('Error while fetching totalVentaCadena');
									return $q.reject(errResponse);
								}
						);
			},
			totalVentaSucursalDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/totalVentaSucursal/')
						.then(
								function(response){
									var consulTVS = response.data;
									var vts = [];
									for(var i = 0; i < consulTVS.length; i++) {
									    var consul = consulTVS[i];
									    var consulta = new Object();
									    consulta.idproducto = consul[0];
									    consulta.producto = consul[1];
										consulta.cantidadTotal = consul[2];
										consulta.fecha = consul[3];
										consulta.localidad = consul[4];
										
										vts.push(consulta);
									}
									console.log(vts);
									return vts;
								}, 
								function(errResponse){
									console.error('Error while fetching totalVentaSucursal');
									return $q.reject(errResponse);
								}
						);
			},
			totalVentaCadenaObraSocialDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/totalVentotalVentaProductoCadenaal/')
						.then(
								function(response){
									var consulTVCOS = response.data;
									var vtcos = [];
									for(var i = 0; i < consulTVCOS.length; i++) {
									    var consul = consulTVCOS[i];
									    var consulta = new Object();
									    consulta.idproducto = consul[0];
									    consulta.producto = consul[1];
										consulta.obraSocial = consul[2];
										consulta.cantidadTotal = consul[3];
										
										vtcos.push(consulta);
									}
									console.log(vtcos);
									return vtcos;
								}, 
								function(errResponse){
									console.error('Error while fetching totalVentaCadena');
									return $q.reject(errResponse);
								}
						);
			},
			totalVentaSucursalObraSocialDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/totalVentaSucursalObrasocial/')
						.then(
								function(response){
									var consulTVSOS = response.data;
									var vtsos = [];
									for(var i = 0; i < consulTVSOS.length; i++) {
									    var consul = consulTVSOS[i];
									    var consulta = new Object();
									    consulta.idproducto = consul[0];
									    consulta.producto = consul[1];
										consulta.obraSocial = consul[2];
										consulta.cantidadTotal = consul[3];
										consulta.calle = consul[4];
										
										vtsos.push(consulta);
									}
									console.log(vtsos);
									return vtsos;
								}, 
								function(errResponse){
									console.error('Error while fetching totalVentaCadena');
									return $q.reject(errResponse);
								}
						);
			},
			totalCobranzaMPCadenaDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/totalCobranzaMPCadena/')
						.then(
								function(response){
									var consulTCMPC = response.data;
									var cmpc = [];
									for(var i = 0; i < consulTCMPC.length; i++) {
									    var consul = consulTCMPC[i];
									    var consulta = new Object();
									    consulta.cantidadTotal = consul[0];
									    consulta.ventaTotal = consul[1];
										consulta.mediopago = consul[2];
										
										cmpc.push(consulta);
									}
									console.log(cmpc);
									return cmpc;
								}, 
								function(errResponse){
									console.error('Error while fetching totalVentaCadena');
									return $q.reject(errResponse);
								}
						);
			},
			totalCobranzaMPSucursalDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/totalCobranzaMPSucursal/')
						.then(
								function(response){
									var consulTCMPS = response.data;
									var cmps = [];
									for(var i = 0; i < consulTCMPS.length; i++) {
									    var consul = consulTCMPS[i];
									    var consulta = new Object();
									    consulta.cantidadTotal = consul[0];
									    consulta.ventaTotal = consul[1];
										consulta.mediopago = consul[2];
										
										cmps.push(consulta);
									}
									console.log(cmps);
									return cmps;
								}, 
								function(errResponse){
									console.error('Error while fetching totalVentaCadena');
									return $q.reject(errResponse);
								}
						);
			},
			totalVentaProductoCadenaDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/totalVentaProductoCadena/')
						.then(
								function(response){
									var consulTVPC = response.data;
									var tvpc = [];
									for(var i = 0; i < consulTVPC.length; i++) {
									    var consul = consulTVPC[i];
									    var consulta = new Object();
									    consulta.cantidadTotal = consul[0];
									    consulta.ventaTotal = consul[1];
										consulta.tipoProducto = consul[2];
										
										tvpc.push(consulta);
									}
									console.log(tvpc);
									return tvpc;
								}, 
								function(errResponse){
									console.error('Error while fetching totalVentaProductoCadena');
									return $q.reject(errResponse);
								}
						);
			},
			totalVentaProductoSucursalDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/totalVentaProductoSucursal/')
						.then(
								function(response){
									var consulTVPS = response.data;
									var tvps = [];
									for(var i = 0; i < consulTVPS.length; i++) {
									    var consul = consulTVPS[i];
									    var consulta = new Object();
									    consulta.cantidadTotal = consul[0];
									    consulta.ventaTotal = consul[1];
										consulta.tipoProducto = consul[2];
										
										tvps.push(consulta);
									}
									console.log(tvps);
									return tvps;
								}, 
								function(errResponse){
									console.error('Error while fetching totalVentaProductoSucursal');
									return $q.reject(errResponse);
								}
						);
			},
			rankingMontoCadenaDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/rankingVentaCadenaMonto/')
						.then(
								function(response){
									var consulTVPC = response.data;
									var tvpc = [];
									for(var i = 0; i < consulTVPC.length; i++) {
									    var consul = consulTVPC[i];
									    var consulta = new Object();
									    consulta.idproducto = consul[0];
										consulta.producto = consul[1];
									    consulta.ventaTotal = consul[2];
										
										tvpc.push(consulta);
									}
									console.log(tvpc);
									return tvpc;
								}, 
								function(errResponse){
									console.error('Error while fetching rankingMontoCadena');
									return $q.reject(errResponse);
								}
						);
			},
			rankingMontoSucursalDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/rankingVentaSucursalMonto/')
						.then(
								function(response){
									var consulTVPS = response.data;
									var tvps = [];
									for(var i = 0; i < consulTVPS.length; i++) {
									    var consul = consulTVPS[i];
									    var consulta = new Object();
									    consulta.idproducto = consul[0];
										consulta.producto = consul[1];
									    consulta.ventaTotal = consul[2];
									    consulta.calle = consul[3];
										
										tvps.push(consulta);
									}
									console.log(tvps);
									return tvps;
								}, 
								function(errResponse){
									console.error('Error while fetching rankingMontoSucursal');
									return $q.reject(errResponse);
								}
						);
			},

			rankingProductoCadenaDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/rankingVentaCadenaCant/')
						.then(
								function(response){
									var consulTVPC = response.data;
									var tvpc = [];
									for(var i = 0; i < consulTVPC.length; i++) {
									    var consul = consulTVPC[i];
									    var consulta = new Object();
									    consulta.idproducto = consul[0];
										consulta.producto = consul[1];
									    consulta.cantidadTotal = consul[2];
										
										tvpc.push(consulta);
									}
									console.log(tvpc);
									return tvpc;
								}, 
								function(errResponse){
									console.error('Error while fetching rankingMontoCadena');
									return $q.reject(errResponse);
								}
						);
			},
			rankingProductoSucursalDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/rankingVentaSucursalCant/')
						.then(
								function(response){
									var consulTVPS = response.data;
									var tvps = [];
									for(var i = 0; i < consulTVPS.length; i++) {
									    var consul = consulTVPS[i];
									    var consulta = new Object();
									    consulta.idproducto = consul[0];
										consulta.producto = consul[1];
									    consulta.cantidadTotal = consul[2];
									    consulta.calle = consul[3];
										
										tvps.push(consulta);
									}
									console.log(tvps);
									return tvps;
								}, 
								function(errResponse){
									console.error('Error while fetching rankingMontoSucursal');
									return $q.reject(errResponse);
								}
						);
			},
			rankingClienteMontoCadenaDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/rankingClienteCadenaMonto/')
						.then(
								function(response){
									var consulTVPC = response.data;
									var tvpc = [];
									for(var i = 0; i < consulTVPC.length; i++) {
									    var consul = consulTVPC[i];
									    var consulta = new Object();
									    consulta.idpersona = consul[0];
										consulta.nombre = consul[1];
									    consulta.ventaTotal = consul[2];
										
										tvpc.push(consulta);
									}
									console.log(tvpc);
									return tvpc;
								}, 
								function(errResponse){
									console.error('Error while fetching rankingClienteCadenaMonto');
									return $q.reject(errResponse);
								}
						);
			},
			rankingClienteMontoSucursalDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/rankingClienteSucursalMonto/')
						.then(
								function(response){
									var consulTVPS = response.data;
									var tvps = [];
									for(var i = 0; i < consulTVPS.length; i++) {
									    var consul = consulTVPS[i];
									    var consulta = new Object();
									    consulta.idpersona = consul[0];
										consulta.nombre = consul[1];
									    consulta.ventaTotal = consul[2];
										
										tvps.push(consulta);
									}
									console.log(tvps);
									return tvps;
								}, 
								function(errResponse){
									console.error('Error while fetching rankingClienteSucursalMonto');
									return $q.reject(errResponse);
								}
						);
			},
			rankingClienteCadenaCantDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/rankingClienteCadenaCant/')
						.then(
								function(response){
									var consulTVPC = response.data;
									var tvpc = [];
									for(var i = 0; i < consulTVPC.length; i++) {
									    var consul = consulTVPC[i];
									    var consulta = new Object();
									    consulta.idpersona = consul[0];
										consulta.nombre = consul[1];
									    consulta.cantidadTotal = consul[2];
										
										tvpc.push(consulta);
									}
									console.log(tvpc);
									return tvpc;
								}, 
								function(errResponse){
									console.error('Error while fetching rankingClienteCadena');
									return $q.reject(errResponse);
								}
						);
			},
			rankingClienteSucursalCantDetalleFacturas: function() {
				return $http.get('http://localhost:8080/detalleFactura/rankingClienteSucursalCant/')
						.then(
								function(response){
									var consulTVPS = response.data;
									var tvps = [];
									for(var i = 0; i < consulTVPS.length; i++) {
									    var consul = consulTVPS[i];
									    var consulta = new Object();
									    consulta.idpersona = consul[0];
										consulta.nombre = consul[1];
									    consulta.cantidadTotal = consul[2];
									    consulta.calle = consul[3];
										
										tvps.push(consulta);
									}
									console.log(tvps);
									return tvps;
								}, 
								function(errResponse){
									console.error('Error while fetching rankingClienteSucursal');
									return $q.reject(errResponse);
								}
						);
			},
			
			
			
			
/*=====================================================================================================================================*/			
		    createDetalleFactura: function(detalleFactura){
					return $http.post('http://localhost:8080/detalleFactura/', detalleFactura)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating detalleFactura');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateDetalleFactura: function(detalleFactura, id){
					return $http.put('http://localhost:8080/detalleFactura/'+id, detalleFactura)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating detalleFactura');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteDetalleFactura: function(id){
					return $http.delete('http://localhost:8080/detalleFactura/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting detalleFactura');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
