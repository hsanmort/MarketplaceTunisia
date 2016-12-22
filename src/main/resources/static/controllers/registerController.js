var routeAppControllers = angular.module('routeAppControllers', []);

routeAppControllers.controller('registerBuyerController', ['$scope',
    function($scope){
        $scope.message = "Bienvenue sur la page du Registration Du Buyer";
    }
]);
routeAppControllers.controller('registerSellerController', ['$scope',
    function($scope){
        $scope.message = "Bienvenue sur la page du Registration Du Seller";
    }
]);

