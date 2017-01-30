'use strict';

angular.module('Shop')



.controller('ShopController', [ '$scope', '$http','$location', '$routeParams',
//affichage de la liste des shops
function($scope, $http,$location,$routeParams) {
    $scope.products=[];
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
  	 function ProductsList(){
  		 var idShop=$routeParams.id;
  	      $http.get("/productsByShop/all?idShop="+idShop)
  	      .success(function(data) {
  	         $scope.products=data;   
  	      });
  	   };
  	   ProductsList();
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
		var idUser=20;
		
		var dataShop = {
				
				nameShop : $scope.nameShop,
				description : $scope.description,
				dateCreation : $scope.dateCreation,
				//seller:{idUser:$scope.idUser}
	
		};	
		var res = $http.post("/shop/save",dataShop,idUser);
		res.success(function(data, status, headers, config) {
			$scope.message = data;
			$location.path('/shop-list');
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});		
		
	};	
	
} ]);