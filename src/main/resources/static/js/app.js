	var app = angular.module('app', ['ngRoute','ngResource']);

	app.config(function($routeProvider){

	    $routeProvider
	        .when('/Account_Login_Buyer',{
	            templateUrl: '/Security/Account_Login_Buyer.html',
	        })
	        .when('/Account_Login_Seller',{
	            templateUrl: '/View/Security/Account_Login_Seller.html',
	        })
	        .when('/test',{
	            templateUrl: '/testlog.html',
	        })
	        .otherwise(
	            { redirectTo: '/'}
	        );
	});