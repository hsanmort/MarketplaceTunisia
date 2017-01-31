'use strict';
angular.module('ShoppingCart')

.controller('ShoppingCartController',
	['$scope','$http','ui.bootstrap','ui.bootstrap.modal','angularPayments', 'mm.foundation', 'ngAnimate', 'angularSpinner',
		function ($scope, $http) {
			$scope.cart = [];
		
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
					$scope.open({
						templateUrl: 'modules/shoppingcart/views/checkout.html',
						controller: 'CheckoutController',
						resolve: {
							totalAmount: $scope.getCartPrice
						}
					});
				};
	}]);

