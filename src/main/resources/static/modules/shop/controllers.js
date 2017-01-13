'use strict';

angular.module('Shop')



.controller('ShopController', [ '$scope', '$http','$location',
//affichage de la liste des shops
function($scope, $http,$location) {
	$scope.shops = [];
	$scope.message = "All Shops Here";
	$scope.message1 = "Add new Shop";
	function ShopList() {
		$http.get("/shop/all")
		.success(function(data) {
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
	
//Ajouter
	$scope.AjouterShop = function(){		
		$scope.idUser=29;
		
		var dataShop = {
				
				nameShop : $scope.nameShop,
				description : $scope.description,
				dateCreation : $scope.dateCreation,
				seller:{idUser:$scope.idUser}
	
		};	
		var res = $http.post("/shop/save", dataShop);
		res.success(function(data, status, headers, config) {
			$scope.message = data;
			$location.path('/shop-list');
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});		
		
	};	
} ]);