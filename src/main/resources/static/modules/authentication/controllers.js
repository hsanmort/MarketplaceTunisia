'use strict';
 
angular.module('Authentication')
.controller("LoginController" ,function($scope,$http,$location){
$scope.user=[];
$scope.mail=null;
$scope.pwd=null;
$scope.message="tesssssssssst";
$scope.login=function(){
		
		$http.get("/user/findByMailAndPwd?mail="+$scope.mail+"&pwd="+$scope.pwd)
		.success(function(data){
		  $scope.user=data;
          $location.path('/');
		});
		
		};


});
	
	// .controller('LoginController',
// ['$scope', '$rootScope', '$location', 'AuthenticationService',
// function ($scope, $rootScope, $location, AuthenticationService) {
// // reset login status
// AuthenticationService.ClearCredentials();
// 
// $scope.login = function () {
// $scope.dataLoading = true;
// AuthenticationService.Login($scope.username, $scope.password,
// function(response) {
// if(response.success) {
// AuthenticationService.SetCredentials($scope.username, $scope.password);
// $location.path('/');
// } else {
// $scope.error = response.message;
// $scope.dataLoading = false;
// }
// });
// };
// }]);

