'use strict';

// declare modules
angular.module('Authentication', []);
angular.module('Home', []);
angular.module('Shop', []);
angular.module('Product', []);

angular.module('BasicHttpAuthExample', [
    'Authentication',
    'Home',
    'Shop',
    'Product',
    'ngRoute',
    'ngCookies'
])
 
.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'modules/authentication/views/login-register.html',
            //hideMenus: true
        })
 
        .when('/home', {
            controller: 'HomeController',
            templateUrl: 'modules/home/views/home.html'
        })
         .when('/shop-list', {
            controller: 'ShopController',
            templateUrl: 'modules/shop/views/shop-list.html'
        })
        .when('/product-list', {
            controller: 'ProductController',
            templateUrl: 'modules/product/views/product-list.html'
        })
        .when('/product-detail/:id', {
            controller: 'ProductDetailController',
            templateUrl: 'modules/product/views/product-detail.html'
        })
 
        .otherwise({ redirectTo: '/home' });
}])
 
.run(['$rootScope', '$location', '$cookieStore', '$http',
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
 
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in
            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
                $location.path('/home');
            }
        });
    }]);