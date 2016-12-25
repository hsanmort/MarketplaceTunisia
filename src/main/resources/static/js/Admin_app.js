	var routeApp = angular.module('routeApp', ['ngRoute']);
	routeApp.config(['$routeProvider',function($routeProvider) { 
	                     
	                     // Système de routage
	                     $routeProvider
	                     .when('/NewUsers', {
	                         templateUrl: 'Admin/NewUsers.html',
	                         controller: 'CatController'
	                     })
	                  /*   .when('/', {
	                         templateUrl: 'Admin_index.html',
	                         controller: 'CatController'
	                     })*/
	                     .when('/Category', {
	                         templateUrl: 'Admin/Category.html',
	                         controller: 'ContCategory'
	                     });
	                 }

	             ]);

	
	/*******************************Gérer les inscription**********************************/
	//var routeApp=angular.module("MyCat",[]);
	routeApp.controller("CatController",function($scope,$http){
	$scope.Users=[];
	$scope.motCle=null;
	$scope.pageCourante=0;


	function charger1(){
	$http.get("/NewUser/all?&page="+$scope.pageCourante)
	.success(function(data){
	$scope.Users=data;
	$scope.pages=new Array(data.totalPages)
	});
	};


	charger1();
	$scope.charger=function(){
	$http.get("/user/findByMc?mc="+$scope.motCle+"&page="+$scope.pageCourante)
	.success(function(data){
	$scope.Users=data;
	$scope.pages=new Array(data.totalPages)
	});
	};

	$scope.supprimer=function(U){
		
		$http.get("/user/delete?idUser="+U.idUser)
		.success(function(){
			$scope.gotoPage($scope.pageCourante);
		});
		
		};
		
		
		$scope.Enregi=function(D){
			$http.get("/update?reference="+($scope.produit).reference+"&designation="+$scope.DES+"&prix="+$scope.prix)
			.success(function(){
				$scope.gotoPage($scope.pageCourante);
			});
			
			};
		
		
		$scope.Modifier=function(U){
			$scope.Users=U;
			$scope.idUser=U.idUser;
			$scope.status=9;
		$http.get("/user/update?idUser="+($scope.Users).idUser+"&status="+9)
		.success(function(){
			$scope.gotoPage($scope.pageCourante);
		});
		
		};
/*
	$scope.Modifier=function(P){
		$scope.Users=P;
		$scope.prix=P.idUser;
		$scope.DES=P.name;
		};
	*/	
	$scope.gotoPage=function(p){
	$scope.pageCourante=p;

	if ($scope.motCle == null){ 
	charger1();
	} else { 
		
		$scope.charger();
	}



	};
	});
	
	/*******************************Gérer Category**********************************/
	//var routeApp=angular.module("MyCat",[]);
	routeApp.controller("ContCategory",function($scope,$http){
	$scope.Category=[];
	$scope.motCle=null;
	$scope.pageCourante=0;


	function chargerC(){
	$http.get("/category/all?&page="+$scope.pageCourante)
	.success(function(data){
	$scope.Category=data;
	$scope.pages=new Array(data.totalPages)
	});
	};


	chargerC();

	$scope.supprimerC=function(C){
		
		$http.get("/category/delete?idCategory="+C.idCategory)
		.success(function(){
			$scope.gotoPage($scope.pageCourante);
		});
		
		};
		
		
	$scope.Ajouter = function(){		
					
			var dataObj = {
					nameCategory : $scope.nameCategory
					
			};	
			var res = $http.post('/category/save', dataObj);
			res.success(function(data, status, headers, config) {
				$scope.message = data;
			});
			res.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data: data}));
			});		
			
			$scope.nameCategory='';
			
			chargerC();
		};
		
		
	$scope.gotoPage=function(p){
	$scope.pageCourante=p;

	if ($scope.motCle == null){ 
		chargerC();
	}
	

	};
	});
	