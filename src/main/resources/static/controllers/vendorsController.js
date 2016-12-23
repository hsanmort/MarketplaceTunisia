//var routeAppControllers = angular.module('routeAppControllers', []);


//Contrôleur de la page vendors

angular.module('routeApp').controller('vendorsController', ['$scope','$http',
function($scope,$http){
		$scope.users=[];
		$scope.visible=true;
   $scope.message = "Bienvenue sur la page du vendeur";
   
   function chargerAll(){
   	$http.get("/user/all")
   	.success(function(data) {
   		$scope.users=data;	
   	});
   };
   chargerAll();
}
]);
//(function () {
//    'use strict';
// 
//    var routeApp= angular.module('routeApp');
//    routeApp.controller('vendorsController', ['$scope','$http', 
//    		function ($scope,$http) {
//    	$scope.users=[];
//      $scope.message = "Bienvenue sur la page du vendeur";
//    	function chargerAll(){
//       	$http.get("/user/all")
//       	.success(function(data) {
//       		$scope.users=data;	
//       	});
//       };
//       chargerAll();
//    }]);
// 
//}());