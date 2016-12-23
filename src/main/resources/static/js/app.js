//	var app = angular.module('app', ['ngRoute','ngResource']);
//
//	app.config(function($routeProvider){
//
//	    $routeProvider
//	        .when('/Account_Login_Buyer',{
//	            templateUrl: '/Security/Account_Login_Buyer.html',
//	        })
//	        .when('/Account_Login_Seller',{
//	            templateUrl: '/View/Security/Account_Login_Seller.html',
//	        })
//	        .when('/test',{
//	            templateUrl: '/testlog.html',
//	        })
//	        .otherwise(
//	            { redirectTo: '/'}
//	        );
//	});
//
//	
//var app = angular.module("app", []);
//
//app.controller("headerCtrl", function($scope){
//    //...    
//});
//
//app.controller("footerCtrl", function($scope){
//    //...    
//});
//
//app.controller("menuCtrl", function($scope){
//    //...    
//});
//
//app.controller("contentCtrl", function($scope){
//    //...    
//});

//logic 1

//'use strict';
//
//define(['js/routeResolver'], function () {
//
//    var app = angular.module('customersApp', ['ngRoute', 'ngAnimate', 'routeAppControllers']);
//
//    app.config(['$routeProvider', 'routeResolverProvider', '$controllerProvider',
//                '$compileProvider', '$filterProvider', '$provide', '$httpProvider',
//
//        function ($routeProvider, routeResolverProvider, $controllerProvider,
//                  $compileProvider, $filterProvider, $provide, $httpProvider) {
//
//            //Change default views and controllers directory using the following:
//            routeResolverProvider.routeConfig.setBaseDirectories('/views', '/controllers');
//
//            app.register =
//            {
//                controller: $controllerProvider.register,
//                directive: $compileProvider.directive,
//                filter: $filterProvider.register,
//                factory: $provide.factory,
//                service: $provide.service
//            };
//
//            //Define routes - controllers will be loaded dynamically
//            //var route = routeResolverProvider.route;
//
//            $routeProvider
//                //route.resolve() now accepts the convention to use (name of controller & view) as well as the 
//                //path where the controller or view lives in the controllers or views folder if it's in a sub folder. 
//                //For example, the controllers for customers live in controllers/customers and the views are in views/customers.
//                
//            	.when('/vendors',
//                    {
//                        templateUrl: '/vendors/vendors',
//                        controller: 'vendorsController'
//                        //resolve: resolveController('/vendorsController.js')
//                    })
//               
//                .otherwise({ redirectTo: '/vendors' });
//
//    }]);
//
// 
//
//    return app;
//
//});

//logic 2
// js/app.js
'use strict';

/**
 * Déclaration de l'application routeApp
 */
var routeApp = angular.module('routeApp', [
// Dépendances du "module"
'ngRoute', 'routeAppControllers' ]);

/**
 * Configuration du module principal : routeApp
 */
//routeApp.config(['$routeProvider', 'routeResolverProvider', '$controllerProvider','$compileProvider', '$filterProvider', '$provide', '$httpProvider',
//    function($routeProvider, routeResolverProvider, $controllerProvider,
//          $compileProvider, $filterProvider, $provide, $httpProvider) { 
routeApp.config([ '$routeProvider', function($routeProvider) {
	// Système de routage
	$routeProvider.when('/home', {
		templateUrl : 'views/home.html',
		controller : 'homeCtrl'
	}).when('/vendors', {
		templateUrl : 'views/vendors/vendors.html',
		controller : 'vendorsController'
	//resolve: resolveController('/controllers/vendorsController.js')
	}).when('/RegBuyer', {
		templateUrl : 'views/security/Account_login_Buyer.html',
		controller : 'registerBuyerController',
		controllerAs: 'vm'	
			
	}).when('/RegSeller', {
		templateUrl : 'views/security/Account_login_Seller.html',
		controller : 'registerSellerController'
	})

	.otherwise({
		redirectTo : '/home'
	});
} ]);

/**
 * Définition des contrôleurs
 */
var routeAppControllers = angular.module('routeAppControllers', []);

// Contrôleur de la page d'accueil
routeAppControllers.controller('homeCtrl', [ '$scope', function($scope) {
	$scope.message = "Bienvenue sur la page d'accueil";
} ]);


//controlleur inscription buyer & seller
routeAppControllers.controller('registerBuyerController', [ '$scope',
		function($scope) {
			$scope.message = "Bienvenue sur la page du Registration Du Buyer";
		} ]);
routeAppControllers.controller('registerSellerController', [ '$scope',
		function($scope) {
			$scope.message = "Bienvenue sur la page du Registration Du Seller";
		} ]);
//registration buyer
routeAppControllers.$inject = ['RegistrationController', '$location', '$rootScope'];
function routeAppControllers(RegistrationController, $location, $rootScope) {
    var vm = this;

    vm.register = register;

    function register() {
        vm.dataLoading = true;
        RegistrationController.RegistrationBuyer(vm.buyer)
            .then(function (response) {
                if (response.success) {
                    $location.path('/home');
                } else {
                    vm.dataLoading = false;
                }
            });
    }
}


//Contrôleur de la page vendors
routeAppControllers.controller('vendorsController', [ '$scope', '$http',
		function($scope, $http) {
			$scope.users = [];
			$scope.message = "Bienvenue sur la page du vendeur";

			function chargerAll() {
				$http.get("/user/all").success(function(data) {
					$scope.users = data;
				});
			}
			;
			chargerAll();
		} ]);


