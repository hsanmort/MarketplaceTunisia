
	
	
angular.module('Shoppingcart')
 
.controller('ShoppingcartController',
    ['$scope','$http',
    	function($scope,$http){	
    	 	
    	function Ajouter(){
			var dataObj = {
					nameOrder: $scope.nameOrder
					
			};	
			var res = $http.post('/order/save', dataObj);
			res.success(function(data, status, headers, config) {
				$scope.message = data;
			});
			res.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data: data}));
			});		
			
			$scope.nameOrder='';
    	};
      
	  
	  
    }]);
	
