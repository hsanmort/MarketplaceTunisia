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



(function () {
    'use strict';
 
    angular
        .module('Authentication')
        .controller('LoginController', LoginController);
 
    LoginController.$inject = ['$location', 'AuthenticationService'];
    function LoginController($location, AuthenticationService) {
        var vm = this;
 
        vm.login = login;
 
        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();
 
        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.mail, vm.pwd, function (response) {
                if (response.success) {
                    AuthenticationService.SetCredentials(vm.mail, vm.pwd);
                    $location.path('/');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    }
 
})();