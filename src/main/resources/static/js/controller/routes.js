'use strict';
(function() {
    myApp.controllers.config([ '$routeProvider', function($routeProvider) {
    	$routeProvider.when('/home', {
		templateUrl : 'views/home.html',
		controller : 'UserController',
		controllerAs: 'me'	

	}).when('/vendors', {
		templateUrl : 'views/vendors/vendors.html',
		controller : 'UserController',
		controllerAs: 'me'	

		}).when('/RegBuyer', {
		templateUrl : 'views/security/Account_login_Buyer.html',
		controller : 'UserController',
		controllerAs: 'me'	
			
	}).when('/RegSeller', {
		templateUrl : 'views/security/Account_login_Seller.html',
		controller : 'UserController',
		controllerAs: 'me'	

	})

	.otherwise({
		redirectTo : '/home'
	});
} ]);



