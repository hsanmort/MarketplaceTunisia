'use strict';
 
angular.module('Product')
.controller('ProductDetailController',
		    ['$scope','$http','$location',
		        function ($scope, $http, $location) {
		     
		      $scope.productbyid=[];
		    	 $scope.message = "x Product Here";
		    	 
		    	 function detailProduct($routeParams){
		    		 console.log($routeParams.id)
		    		 $http.get("/product/"+$routeParams.id)
			  	      .success(function(data) {
			  	         $scope.productbyid=data;   
			  	      });
		    	   };
		    	   detailProduct();
  
		     }]);