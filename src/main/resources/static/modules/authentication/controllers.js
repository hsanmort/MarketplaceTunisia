'use strict';
 
angular.module('Authentication')
	 .controller('LoginController',
 ['$scope', '$rootScope', '$location', 'AuthenticationService',
 function ($scope, $rootScope, $location, AuthenticationService) {
 // reset login status
 AuthenticationService.ClearCredentials();
 $scope.mail=null;
 $scope.pwd=null;
 $scope.message="errrrrrrrrrrreru";
 $scope.login = function () {
	 $scope.dataLoading = true;
	 AuthenticationService.Login($scope.mail, $scope.pwd,
	 function(response) {
		 if(response.success) {
			 AuthenticationService.SetCredentials($scope.mail, $scope.pwd);
			 $location.path('/home');
	 		} else {
			 $scope.error = response.message;
			 $scope.dataLoading = false;
			 }
	 });
 	};
}]);



/*.controller("LoginController" ,function($scope,$http,$location){
$scope.user=[];
$scope.mail=null;
$scope.pwd=null;
$scope.message="tesssssssssst";
$scope.login=function(){
		
		$http.get("/user/findByMailAndPwd?mail="+$scope.mail+"&pwd="+$scope.pwd)
		.success(function(data){
		  $scope.user=data;
          $location.path('/home');
		});
		
		};


});*/
