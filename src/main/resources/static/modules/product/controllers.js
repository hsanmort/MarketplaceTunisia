'use strict';
 
angular.module('Product')
 
.controller('ProductController',
    ['$scope','$http',
       function ($scope, $http) {
     $scope.products=[];
   	 $scope.message = "All Products Here";
   	 function ProductsList(){
   	      $http.get("/product/all")
   	      .success(function(data) {
   	         $scope.products=data;   
   	      });
   	   };
   	ProductsList();
      
    }]);