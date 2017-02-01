'use strict';

// declare modules
angular.module('Authentication', []);
angular.module('Home', []);
angular.module('Shop', []);
angular.module('Product', []);
angular.module('Seller', []);
angular.module('Complaint', []);
angular.module('ShoppingCart', []);
angular.module('Order', []);

angular.module('BasicHttpAuthExample', [
    'Authentication',
    'Home',
    'Shop',
    'Product',
    'Seller',
    'Complaint',
    'ShoppingCart',
    'Order',
    'ngRoute',
    'ngCookies'
])
 
.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
    	//Authentification Routes
        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'modules/authentication/views/login-register.html',
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
        .when('/product-add/', {
            controller: 'ProductController',
            templateUrl: 'modules/product/views/product-add.html'
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
	    .when('/shop-add/', {
	         templateUrl: 'modules/shop/views/shop-add.html',
	         controller: 'ShopDetailController' 
	        })
	        
        //Seller Routes
        .when('/seller-list', {
	         templateUrl: 'modules/seller/views/seller-list.html',
	         controller: 'SellerController' 
	        })
	    .when('/profile-public/:id', {
	         templateUrl: 'modules/profile/views/profile-public.html',
	         controller: 'SellerDetailController' 
	        })
	    .when('/seller-dashboard', {
	         templateUrl: 'modules/seller/views/seller-dashboard.html',
	         controller: 'OrderController' 
	        })
	    //Complaint Routes
        .when('/complaint', {
	         templateUrl: 'modules/complaint/views/complaint.html',
	         controller: 'ComplaintController' 
	        })
	   //Order Routes
        .when('/seller-dashboard', {
	         templateUrl: 'modules/seller/views/seller-dashboard.html',
	         controller: 'OrderController' 
	        })

	   //ShoppingCart Test Routes
	        .when('/shop-checkout', {
	         templateUrl: 'modules/shoppingcart/views/shoping.html',
	         controller: 'ShoppingCartController' 
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
        	            // redirect to login page if not logged in and trying to access a restricted page
        	            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
        	            var loggedIn = $rootScope.globals.currentUser;
        	            if (restrictedPage && !loggedIn) {
        	                $location.path('/login');
        	            }
        	        });
    }]);