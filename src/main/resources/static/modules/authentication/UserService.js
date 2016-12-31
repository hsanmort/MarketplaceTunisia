/*'use strict';
 
angular
.module('Authentication')
.factory('UserService', UserService );

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};
 

        service.GetByMail = GetByMail;
       
         
        
        function GetByMail(mail) {
            return $http.get('/user/findByMail/' + mail).then(handleSuccess, handleError('Error getting user by mail'));
        }
        // private functions
 
        function handleSuccess(res) {
            return res.data;
        }
 
        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
 
        return service;
        

};*/
(function () {
    'use strict';
 
    angular
        .module('Authentication')
        .factory('UserService', UserService);
 
    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};
 
        
        service.GetByMail = GetByMail;
        
 
        return service;
 
     
 
        function GetByMail(mail) {
            return $http.get('/user/findByMail' + mail).then(handleSuccess, handleError('Error getting user by mail'));
        }
 
      
 
        // private functions
 
        function handleSuccess(res) {
            return res.data;
        }
 
        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }
 
})();
