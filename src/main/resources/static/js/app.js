'use strict';

// declare modules
angular.module('Authentication', []);
angular.module('Home', []);
angular.module('Shop', []);
angular.module('Product', []);
angular.module('Seller', []);
angular.module('Complaint', []);
angular.module('Shoppingcart', []);

angular.module('BasicHttpAuthExample', [
    'Authentication',
    'Home',
    'Shop',
    'Product',
    'Seller',
    'Complaint',
    'shop-checkout'
    'ngRoute',
    'ngCookies'
])
 
.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
    	//Authentification Routes
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
        //Product Routes
        .when('/product-list', {
            controller: 'ProductController',
            templateUrl: 'modules/product/views/product-list.html'
        })
        .when('/product-detail/:id', {
            controller: 'ProductDetailController',
            templateUrl: 'modules/product/views/product-detail.html'
        })
        
        //Shop Routes
        
	    .when('/shop-list', {
            controller: 'ShopController',
            templateUrl: 'modules/shop/views/shop-list.html'
        })
        .when('/shop-detail/:id', {
	         templateUrl: 'modules/shop/views/shop-detail.html',
	         controller: 'ShopDetailController' 
	        })
	        
        //Seller Routes
        .when('/seller-list', {
	         templateUrl: 'modules/seller/views/seller-list.html',
	         controller: 'SellerController' 
	        })
	    .when('/seller-detail/:id', {
	         templateUrl: 'modules/seller/views/seller-detail.html',
	         controller: 'SellerDetailController' 
	        })
	    //Complaint Routes
        .when('/complaint', {
	         templateUrl: 'modules/complaint/views/complaint.html',
	         controller: 'ComplaintController' 
	        })
	        
	        .when('/shop-checkout', {
	         templateUrl: 'modules/shoppingcart/views/shop-checkout.html',
	         controller: 'ComplaintController' 
	        })
        .otherwise({ redirectTo: '/home' });
}]);
 
/*.run(['$rootScope', '$location', '$cookieStore', '$http',
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
 
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
        	            // redirect to login page if not logged in and trying to access a restricted page
        	            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
        	            var loggedIn = $rootScope.globals.currentUser;
        	            if (restrictedPage && !loggedIn) {
        	                $location.path('/login');
        	            }
        	        });
    }]);*/