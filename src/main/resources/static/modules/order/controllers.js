'use strict';

angular.module('Order')
.controller('OrderController', [ '$scope', '$http','$location', '$routeParams',
//affichage de la liste des orders
function($scope, $http,$location,$routeParams) {
	
	$scope.message = "All My Order";
	function OrderList() {
		$http.get('modules/order/orders.json')
		.success(function(response) {
			$scope.orders = response.orders;
			console.log($scope.orders.id);
		});
	};

  	 OrderList();

//suppression du orders
	$scope.supprimer = function(orders) {

		delete $scope.orders.id_order; 
		
	};
	

	
} ]);