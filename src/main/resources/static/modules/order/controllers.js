'use strict';

angular.module('Order')
.controller('OrderController', [ '$scope', '$http','$location', '$routeParams',
//affichage de la liste des orders
function($scope, $http,$location,$routeParams) {
	$scope.orders = [];
	$scope.message = "All My Order";
	function OrderList() {
		$http.get("/order/all")
		.success(function(data) {
			$scope.orders = data;
		});
	};

  	 OrderList();

//suppression du orders
	$scope.supprimer = function(order) {

		$http.get("/shop/delete?idOrder=" + order.idOrder).success(function() {
			$location.path('/order-list');
		});

	};
	

	
} ]);