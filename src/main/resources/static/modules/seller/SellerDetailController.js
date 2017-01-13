'use strict';
 
angular.module('Seller')
.controller('SellerDetailController',
		    ['$scope','$http','$location','$routeParams',
		        function ($scope, $http, $location,$routeParams) {
		    	$scope.idSeller=null;
		    	$scope.idSeller  = $routeParams.id;
		      $scope.sellerbyid={};
		    	 $scope.message = $scope.idSeller +" Seller Here";
		    	 
		    	 function detailSeller(){
		    		 
		    		 $http.get("/seller/findByIdSeller?idSeller="+$scope.idSeller)
			  	      .success(function(data) {
			  	         $scope.sellerbyid=data;   
			  	         
			  	      });
		    	   };
		    	   detailSeller();

		    	   
		    	   $scope.seller={
		    			   sellerbyid: $scope.sellerbyid

		    			   
		    	   };
		    	   function ShopBySeller(){
			    		 
			    		 $http.get("/shop/findBySellers?seller="+$scope.seller)
				  	      .success(function(data) {
				  	    	$scope.seller=data;

				  	      });
			    	   };

  
		     }]);