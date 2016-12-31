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
            templateUrl: 'modules/authentication/views/login.html',
            //controllerAs: 'vm'
            hideMenus: true
        })
        .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'modules/authentication/views/register.html',
                controllerAs: 'vm'
            })
 
        .when('/home', {
            controller: 'HomeController',
            templateUrl: 'modules/home/views/home.html'
        })
        .when('/product-list', {
            controller: 'ProductController',
            templateUrl: 'modules/product/views/product-list.html'
        })
        .when('/product-detail/:id', {
            controller: 'ProductDetailController',
            templateUrl: 'modules/product/views/product-detail.html'
        })
        .when('/shop-detail/:id', {
	         templateUrl: 'modules/shop/views/shop-detail.html',
	         controller: 'ShopDetailController' 
	        })
	    .when('/shop-list', {
            controller: 'ShopController',
            templateUrl: 'modules/shop/views/shop-list.html'
        })
        .otherwise({ redirectTo: '/home' });
}]);
 
//.run(['$rootScope', '$location', '$cookieStore', '$http',
//    function ($rootScope, $location, $cookieStore, $http) {
//        // keep user logged in after page refresh
//        $rootScope.globals = $cookieStore.get('globals') || {};
//        if ($rootScope.globals.currentUser) {
//            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
//        }
// 
//        $rootScope.$on('$locationChangeStart', function (event, next, current) {
//        	            // redirect to login page if not logged in and trying to access a restricted page
//        	            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
//        	            var loggedIn = $rootScope.globals.currentUser;
//        	            if (restrictedPage && !loggedIn) {
//        	                $location.path('/login');
//        	            }
//        	        });
//    }]);