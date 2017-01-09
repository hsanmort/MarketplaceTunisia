angular.module('Complaint')
 
.controller('ComplaintController',
    ['$scope','$http',
	
	$scope.Ajouter = function(){		
			
			var dataObj = {
					nameComplaint: $scope.nameComplaint
					
			};	
			var res = $http.post('/complaint/save', dataObj);
			res.success(function(data, status, headers, config) {
				$scope.message = data;
			});
			res.error(function(data, status, headers, config) {
				alert( "failure message: " + JSON.stringify({data: data}));
			});		
			
			$scope.nameComplaint='';
			
			chargerC();
		}
	
  ]);