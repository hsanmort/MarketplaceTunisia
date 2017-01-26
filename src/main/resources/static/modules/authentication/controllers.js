/*'use strict';
 
angular.module('Authentication')
	 .controller('LoginController',
 ['$scope', '$rootScope', '$location', 'AuthenticationService', 'FlashService', 
 function ($scope, $rootScope, $location, AuthenticationService,FlashService) {
 // reset login status

 $scope.mail=null;
 $scope.pwd=null;
 $scope.message="errrrrrrrrrrreru";
 AuthenticationService.ClearCredentials();
$scope.login = login;
 $scope.login = function () {
	 $scope.dataLoading = true;
	 AuthenticationService.Login($scope.mail, $scope.pwd,
	 function(response) {
		 if(response.success) {
			 AuthenticationService.SetCredentials($scope.mail, $scope.pwd);
			 $location.path('/home');
			 
	 		} else {
			 $scope.error = response.message;
			 $scope.dataLoading = false;
			 }
	 });
 	};
}]);*/


//
//(function () {
//    'use strict';
// 
//    angular
//        .module('Authentication')
//        .controller('LoginController', LoginController);
// 
//    LoginController.$inject = ['$scope','$location', 'AuthenticationService'];
//    function LoginController($scope,$location, AuthenticationService) {
//        //var vm = this;
// 
//        $scope.login = login;
// 
//        (function initController() {
//            // reset login status
//            AuthenticationService.ClearCredentials();
//        })();
// 
//        function login() {
//        	$scope.dataLoading = true;
//            AuthenticationService.Login($scope.mail, $scope.pwd, function (response) {
//                if (response.success) {
//                    AuthenticationService.SetCredentials($scope.mail, $scope.pwd);
//                    $location.path('/');
//                } else {
//                	FlashService.Error(response.message);
//                    $scope.dataLoading = false;
//                }
//            });
//        };
//    }
// 
//})();


/*'use strict';
  
angular.module('Authentication')
  
.controller('LoginController',
    ['$scope', '$rootScope', '$location', 'AuthenticationService',
    function ($scope, $rootScope, $location, AuthenticationService) {
        // reset login status
        AuthenticationService.ClearCredentials();
  
        $scope.login = function () {
            $scope.dataLoading = true;
            AuthenticationService.Login($scope.mail, $scope.pwd, function(response) {
                if(response.success) {
                    AuthenticationService.SetCredentials($scope.mail, $scope.pwd);
                    $location.path('/');
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
                }
            });
        };
    }]);*/

    'use strict';
 
angular.module('Authentication')
 
.controller('LoginController',
    ['$scope', '$rootScope', '$location', 'AuthenticationService',
    function ($scope, $rootScope, $location, AuthenticationService) {
        // reset login status
        AuthenticationService.ClearCredentials();
 
        $scope.login = function () {
            $scope.dataLoading = true;
            AuthenticationService.Login($scope.mail, $scope.pwd, function(response) {
                if(response.success) {
                    AuthenticationService.SetCredentials($scope.mail, $scope.pwd);
                    $location.path('/');
                } else {
                    $scope.error = response.message;
                    $scope.dataLoading = false;
                }
            });
        };
    }]);