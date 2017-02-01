'use strict';
 
angular.module('Product')
.controller('ProductDetailController',
		    ['$scope','$http','$location','$routeParams',
		        function ($scope, $http, $location,$routeParams) {
		    	$scope.idProduct=null;
		    	$scope.idProduct  = $routeParams.id;
		    	$scope.seller = {
		    			idUser : 1,
		    			name : 'Hsan',
		    			lastName : 'Akrout',
		    			mail : 'Hsan.akrout@gmail.com',
		    			tel : 23154789,
		    			
		    			
		    	};
		    	
		      
		      $scope.productbyid={};
		      $scope.message = $scope.idProduct +" Product Here";
		    	 
		    	 function detailProduct(){
		    		
		    		 
		    		 $http.get("/product/findByIdProduct?idProduct="+$scope.idProduct)
			  	      .success(function(data) {
			  	         $scope.productbyid=data;   
			  	      });
		    		 
		    		 
		    	   };
		    	   detailProduct();
  
		     }]);