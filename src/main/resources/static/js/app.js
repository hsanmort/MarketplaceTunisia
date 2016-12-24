//'use strict';
//
///**
// * Déclaration de l'application routeApp
// */
//var routeApp = angular.module('routeApp', [
//// Dépendances du "module"
//'ngRoute']);
//
///**
// * Configuration du module principal : routeApp
// */
//
//routeApp.config([ '$routeProvider', function($routeProvider) {
//	
//	// Système de routage
//	$routeProvider.when('/home', {
//		templateUrl : 'views/home.html',
//		controller : 'homeCtrl'
//	}).when('/vendors', {
//		templateUrl : 'views/vendors/vendors.html',
//		controller : 'vendorsController'
//	
//	//resolve: resolveController('/controllers/vendorsController.js')
//	}).when('/RegBuyer', {
//		templateUrl : 'views/security/Account_login_Buyer.html',
//		controller : 'registerBuyerController',
//		controllerAs: 'vm'	
//			
//	}).when('/RegSeller', {
//		templateUrl : 'views/security/Account_login_Seller.html',
//		controller : 'registerSellerController'
//	})
//
//	.otherwise({
//		redirectTo : '/home'
//	});
//} ]);
//
///**
// * Définition des contrôleurs
// */
//
//// Contrôleur de la page d'accueil
//routeApp.controller('homeCtrl', [ '$scope', function($scope) {
//	$scope.message = "Bienvenue sur la page d'accueil";
//} ]);
//
//
////controlleur inscription buyer & seller
//routeApp.controller('registerBuyerController', [ '$scope',
//		function($scope) {
//			$scope.message = "Bienvenue sur la page du Registration Du Buyer";
//		} ]);
//routeApp.controller('registerSellerController', [ '$scope',
//		function($scope) {
//			$scope.message = "Bienvenue sur la page du Registration Du Seller";
//		} ]);
////registration buyer
//routeApp.$inject = ['RegistrationController', '$location', '$rootScope'];
//function routeAppControllers(RegistrationController, $location, $rootScope) {
//    var vm = this;
//
//    vm.register = register;
//
//    function register() {
//        vm.dataLoading = true;
//        RegistrationController.RegistrationBuyer(vm.buyer)
//            .then(function (response) {
//                if (response.success) {
//                    $location.path('/home');
//                } else {
//                    vm.dataLoading = false;
//                }
//            });
//    }
//}
//
//
////Contrôleur de la page vendors
//routeApp.controller('vendorsController', [ '$scope', '$http',
//		function($scope, $http) {
//			$scope.users = [];
//			$scope.message = "Bienvenue sur la page du vendeur";
//
//			function chargerAll() {
//				$http.get("/user/all").success(function(data) {
//					$scope.users = data;
//				});
//			}
//			;
//			chargerAll();
//		} ]);


'use strict';
var myApp = myApp || {};
 
(function(){
    myApp.factories = angular.module('myAppFactories', []),
    myApp.controllers = angular.module('myAppControllers', [ 'myAppFactories', 'ngRoute' ]),
    myApp.app = angular.module('myApp', [ 'ngRoute', 'myAppControllers']);
})();










