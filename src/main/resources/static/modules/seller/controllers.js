'use strict';
 
angular.module('Seller')
 
.controller('SellerController',
    ['$scope', '$http','$location',
    function ($scope, $http,$location) {
    	
    	$scope.sellers = [];
    	$scope.message = "All Sellers Here";

    	
    	function SellerList() {
    		$http.get("/seller/alls")
    		.success(function(data) {
    			$scope.sellers = data;
    			
    		});
    	};
    	SellerList();
    	//affichage detail seller
    	$scope.detailSeller = function(sellerId) {
    		$location.path('/profile-public/' + sellerId);

    	};

      
    }]);