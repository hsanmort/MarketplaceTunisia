	var routeApp = angular.module('routeApp', ['ngRoute']);
	routeApp.config(['$routeProvider',function($routeProvider) { 
	                     
	                     // Système de routage
	                     $routeProvider
	                     .when('/NewUsers', {
	                         templateUrl: 'Admin/NewUsers.html',
	                         controller: 'CatController'
	                     })
	                    .when('/Complaint', {
	                         templateUrl: 'Admin/Complaint.html',
	                         controller: 'ContComplaint'
	                     })
	                   .when('/ListComplaint/:id', {
	                         templateUrl: 'Admin/Chat_Complaint.html',
	                       controller: 'appartementCtrl' 
	                       //  controller: 'ReclaAjouter'
	                     })
	                   
	                     .when('/Category', {
	                         templateUrl: 'Admin/Category.html',
	                         controller: 'ContCategory'
	                     })
	                     ;
	                 }

	             ]);

	
	
	/*******************************Gérer les inscription**********************************/
	//var routeApp=angular.module("MyCat",[]);
	routeApp.controller("CatController",function($scope,$http){
	$scope.Users=[];
	$scope.motCle=null;
	$scope.pageCourante=0;


	function chargerU(){
	$http.get("/NewUser/all?&page="+$scope.pageCourante)
	.success(function(data){
	$scope.Users=data;
	$scope.pages=new Array(data.totalPages)
	});
	};


	chargerU();
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
	chargerU();
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
	
	
	
	
	/*******************************Gérer reclamation**********************************/
	//var routeApp=angular.module("MyCat",[]);
	routeApp.controller("ContComplaint",function($scope,$http){
	$scope.Complaint=[];
	$scope.motCle=null;
	$scope.pageCourante=0;


	function chargerCompl(){
	$http.get("/complaint/all?&page="+$scope.pageCourante)
	.success(function(data){
	$scope.Complaint=data;
	$scope.pages=new Array(data.totalPages)
	});
	};
	

	chargerCompl();
	$scope.charger=function(){
		$http.get("/complaint/findByMc?mc="+$scope.motCle+"&page="+$scope.pageCourante)
		.success(function(data){
		$scope.Complaint=data;
		$scope.pages=new Array(data.totalPages)
		});
		};
		
		
		
	$scope.supprimerCompl=function(C){
		
		$http.get("/complaint/delete?idComplaint="+C.idComplaint)
		.success(function(){
			$scope.gotoPage($scope.pageCourante);
		});
		
		};
	
		
		
	
		
		$scope.DetailCompl=function(C){
			$scope.Complaint=C;
			//$scope.prix=P.idUser;
			$scope.DES="dd";
			};
		
		$scope.gotoPage=function(p){
			$scope.pageCourante=p;

			if ($scope.motCle == null){ 
				chargerCompl();
			} else { 
				
				$scope.charger();
			}
	

	};
	});
	
	
	// Le contrôleur appartementCtrl
	/*routeApp.controller('appartementCtrl',function($scope){
        $scope.tel='95 109 199';
        $scope.nom='idriss.hammami@esprit.tn';
    
	/*['$scope', '$routeParams',
	    function($scope, $routeParams){
	        // Pour afficher les informations
	        $scope.immeuble = $routeParams.imble;  
	        $scope.nom = 'sss';// ici 57
	       
	    }
	]*///}
	//);
	
	routeApp.controller('appartementCtrl', ['$scope', '$routeParams',
	                                                    function($scope, $routeParams){
	                                                        // Pour afficher les informations
	                                                        $scope.id = $routeParams.id;       // ici 57
	                                                        $scope.desc = $routeParams.description;   // ici 10
	                                                        $scope.date =$routeParams.date;              // ici "dupont"
	                                                                               
	                                                        
	}
	                                                ]
	                                                
	);
	
	
	
	routeApp.controller("ReclaAjouter",function($scope,$http){
		$scope.AjouterRecla= function(){		
			
			var Obj = {
				
					description :$scope.rec
					
			};	
			var resu = $http.post('/complaint/save', Obj);
			resu.success(function(data, status, headers, config) {
				$scope.message = data;
			});
			resu.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data: data}));
			});		
			//$scope.recla=$scope.description;
			//$scope.description='';
			
		};
	});
	