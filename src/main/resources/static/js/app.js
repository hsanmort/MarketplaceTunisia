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
'use strict';

define(['routeResolver'], function () {

    var app = angular.module('customersApp', ['ngRoute', 'ngAnimate']);

    app.config(['$routeProvider', 'routeResolverProvider', '$controllerProvider',
                '$compileProvider', '$filterProvider', '$provide', '$httpProvider',

        function ($routeProvider, routeResolverProvider, $controllerProvider,
                  $compileProvider, $filterProvider, $provide, $httpProvider) {

            //Change default views and controllers directory using the following:
            //routeResolverProvider.routeConfig.setBaseDirectories('/app/views', '/app/controllers');

            app.register =
            {
                controller: $controllerProvider.register,
                directive: $compileProvider.directive,
                filter: $filterProvider.register,
                factory: $provide.factory,
                service: $provide.service
            };

            //Define routes - controllers will be loaded dynamically
            var route = routeResolverProvider.route;

            $routeProvider
                //route.resolve() now accepts the convention to use (name of controller & view) as well as the 
                //path where the controller or view lives in the controllers or views folder if it's in a sub folder. 
                //For example, the controllers for customers live in controllers/customers and the views are in views/customers.
                //The controllers for orders live in controllers/orders and the views are in views/orders
                //The second parameter allows for putting related controllers/views into subfolders to better organize large projects
            	.when('/customers',
                    {
                        templateUrl: '/customers',
                        resolve: resolveController('/customersController.js')
                    })
                .when('/customerorders/:customerId', route.resolve('CustomerOrders', 'customers/', 'vm'))
                .when('/customeredit/:customerId', route.resolve('CustomerEdit', 'customers/', 'vm', true))
                .when('/orders', route.resolve('Orders', 'orders/', 'vm'))
                .when('/about', route.resolve('About', '', 'vm'))
                .when('/login/:redirect*?', route.resolve('Login', '', 'vm'))
                .otherwise({ redirectTo: '/customers' });

    }]);

    app.run(['$rootScope', '$location', 'authService',
        function ($rootScope, $location, authService) {
            
            //Client-side security. Server-side framework MUST add it's 
            //own security as well since client-based security is easily hacked
            $rootScope.$on("$routeChangeStart", function (event, next, current) {
                if (next && next.$$route && next.$$route.secure) {
                    if (!authService.user.isAuthenticated) {
                        $rootScope.$evalAsync(function () {
                            authService.redirectToLogin();
                        });
                    }
                }
            });

    }]);

    return app;

});





