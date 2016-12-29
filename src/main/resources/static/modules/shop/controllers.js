'use strict';
 
angular.module('Shop')
 
.controller('ShopController',
    ['$scope','$http',
    function ($scope , $http) {
    	 $scope.shops=[];
    	 $scope.message = "All Shops Here";
    	 function ShopList(){
    	      $http.get("/shop/all")
    	      .success(function(data) {
    	         $scope.shops=data;   
    	      });
    	   };
    	   ShopList();
    }]);