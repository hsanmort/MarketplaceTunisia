'use strict';
 
angular.module('Product')
 
.controller('ProductController',
    ['$scope','$http','$location',
       function ($scope, $http, $location) {
     $scope.products=[];
     $scope.productbyid=[];
   	 $scope.message = "All Products Here";
   	 $scope.message1= "New Product";
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
    
  //Ajouter
  	$scope.AjouterProduct = function(){		
  		$scope.idShop=1;
  		
  		var dataProduct = {
  				
  				nameProduct : $scope.nameProduct,
  				description : $scope.description,
  				price : $scope.price,
  				dateAdd : $scope.dateAdd,
  				Qte : $scope.Qte,
  				Shop:{idShop:$scope.idShop}
  	
  		};	
  		var res = $http.post("/product/save", dataProduct);
  		res.success(function(data, status, headers, config) {
  			$scope.message = data;
  			$location.path('/product-list');
  		});
  		res.error(function(data, status, headers, config) {
  			alert( "failure message: " + JSON.stringify({data: data}));
  		});		
  		ProductsList();
  	};
      
    }]);
    
