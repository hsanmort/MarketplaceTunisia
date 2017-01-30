'use strict';

angular.module('Shop').controller(
		'ShopDetailController',
		[
				'$scope',
				'$http',
				'$location',
				'$routeParams',
				function($scope, $http, $location, $routeParams) {
					
					$scope.idShop = null;
					$scope.idShop = $routeParams.id;
					$scope.shopbyid = {};
					$scope.message = $scope.idShop + " Shop Here";

					function detailShop() {

						$http.get("/shop/findByIdShop?idShop=" + $scope.idShop)
								.success(function(data) {
									$scope.shopbyid = data;

								});
					}
					;
					detailShop();

					//		    	   var Shop = $resource("/shop/findByIdShop?idShop="+$scope.idShop,
					//		    			    {
					//		    			    charge: {method:'GET', params:{charge:true}}
					//		    			   });
					//		    	   console.log( Shop);

					$scope.productbyshop = {};
					function ProductByShop() {

						$http
								.get(
										"/product/findByShop?shop="
												+ $scope.shopbyid).success(
										function(data) {
											$scope.productbyshop = data;
											console.log($scope.productbyshop);
										});
					}
					;
					ProductByShop();

					
				} ]);