'use strict';
 
angular.module('Product')
 
.controller('ProductController',
    ['$scope','$http','$location','$routeParams',
       function ($scope, $http, $location,$routeParams) {
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
    $scope.idShop =$routeParams.id;
    $scope.idShop = parseInt($scope.idShop);
    $scope.AjouterProduct = function() {

		var dataProduct = {

			nameProduct : $scope.nameProduct,
			description : $scope.description,
			price : $scope.price,
			dateAdd : $scope.dateAdd,
			Qte : $scope.Qte,


		};
		var res = $http.post("/product/sav", dataProduct);
		res.success(function(data, status, headers, config) {
			$scope.message = data;
			$location.path('/product-list/' );
			
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	}; 
	//Ajouter sans id shop
    

	/*$scope.AjouterProduct = function() {
		


		var product = {

			nameProduct : $scope.nameProduct,
			description : $scope.description,
			price : $scope.price,
			dateAdd : $scope.dateAdd,
			Qte : $scope.Qte

		};
		var res = $http.post("/product/save",product,$scope.idShop);
		res.success(function(data, status, headers, config) {
			$scope.message = data;
			$location.path('/product-list');
		});
		res.error(function(data, status, headers, config) {
			alert("failure message: " + JSON.stringify({
				data : data
			}));
		});
	}; */
	
	
    }])

.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
 }])

 .service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(file, uploadUrl){
       var fd = new FormData();
       fd.append('file', file);
    
       $http.post(uploadUrl, fd, {
          transformRequest: angular.identity,
          headers: {'Content-Type': undefined}
       })
    
       .success(function(){
       })
    
       .error(function(){
       });
    }
 }])

 .controller('myCtrl', ['$scope', 'fileUpload', function($scope, fileUpload){
    $scope.uploadFile = function(){
       var file = $scope.myFile;
       
       console.log('file is ' );
       console.dir(file);
       
       var uploadUrl = "/upload";
       fileUpload.uploadFileToUrl(file, uploadUrl);
    };
 }]);
    
