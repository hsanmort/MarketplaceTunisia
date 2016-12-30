'use strict';
 
angular.module('Product')
 
.controller('ProductController',
    ['$scope','$http','$location',
       function ($scope, $http, $location) {
     $scope.products=[];
     $scope.productbyid=[];
   	 $scope.message = "All Products Here";
   	 function ProductsList(){
   	      $http.get("/product/all")
   	      .success(function(data) {
   	         $scope.products=data;   
   	      });
   	   };
   	ProductsList();
   	$scope.detailProduct = function (productId) {
        $location.path('/product-detail/' + productId);
        
    };
      
    }]);
    
