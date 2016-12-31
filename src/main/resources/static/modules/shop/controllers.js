'use strict';

angular.module('Shop')

.controller('ShopController', [ '$scope', '$http',
//affichage de la liste des shops
function($scope, $http) {
	$scope.shops = [];
	$scope.message = "All Shops Here";
	function ShopList() {
		$http.get("/shop/all").success(function(data) {
			$scope.shops = data;
		});
	};
	ShopList();
//affichage detail shop
	$scope.detailShop = function(shopId) {
		$location.path('/shop-detail/' + shopId);

	};
//suppression du shop
	$scope.supprimer = function(shop) {

		$http.get("/shop/delete?idShop=" + shop.idShop).success(function() {
			$location.path('/shop-list');
		});

	};
} ]);