'use strict';
 
angular.module('Shop')
.controller('ShopDetailController',
		    ['$scope','$http','$location','$routeParams',
		        function ($scope, $http, $location,$routeParams) {
		    	var idShop = $routeParams.id;
		      $scope.shopbyid=[];
		    	 $scope.message = idShop+" Shop Here";
		    	 
		    	 function detailShop(shop){
		    		 
		    		 $http.get("/shop/findByIdShop?idShop="+idShop)
			  	      .success(function(data) {
			  	         $scope.shopbyid=data;   
			  	      });
		    	   };
		    	   detailShop();
  
		     }]);