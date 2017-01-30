'use strict';


angular.module('ShoppingCart')

	.controller('ShoppingCartController',['$scope','$http','$modal','angularPayments', 'mm.foundation', 'ngAnimate', 'angularSpinner',
			function ($scope, $http, $modal) {
		$scope.cart = [];

		// Load products from server
		
		$http.get("/product/all").success(function (response) {
			$scope.products = response.products;
		});

		$scope.addToCart = function (product) {
			var found = false;
			$scope.cart.forEach(function (item) {
				if (item.id === product.idProduct) {
					item.Qte++;
					found = true;
				}
			});
			if (!found) {
				$scope.cart.push(angular.extend({Qte: 1}, product));
			}
		};

		$scope.getCartPrice = function () {
			var total = 0;
			$scope.cart.forEach(function (product) {
				total += product.price * product.Qte;
			});
			return total;
		};

		$scope.checkout = function () {
			$modal.open({
				templateUrl: 'checkout.html',
				controller: 'CheckoutCtrl',
				resolve: {
					totalAmount: $scope.getCartPrice
				}
			});
		};
	}]);

