/*'use strict';
 
angular
.module('Authentication')
.factory('UserService', UserService );

    UserService.$inject = ['$timeout','$filter', '$q'];
    function UserService($timeout, $filter, $q) {
        var service = {};
        

        service.GetByMail = GetByMail;

        
        
        function GetByMail(mail) {
            var deferred = $q.defer();
            var filtered = $filter('filter')(getUsers(), { mail: mail });
            var user = filtered.length ? filtered[0] : null;
            deferred.resolve(user);
            return deferred.promise;
        }
        // private functions
 
        function getUsers() {
            if(!localStorage.users){
                localStorage.users = JSON.stringify([]);
            }
 
            return JSON.parse(localStorage.users);
        }
 
        function setUsers(users) {
            localStorage.users = JSON.stringify(users);
        }
 
        return service;

};
*/

(function () {
    'use strict';
 
    angular
        .module('Authentication')
        .factory('UserService', UserService);
 
    UserService.$inject = ['$timeout', '$filter', '$q'];
    function UserService($timeout, $filter, $q) {
 
        var service = {};
 
      
        service.GetByMail = GetByMail;
        
 
        return service;
 
       
 
        function GetByMail(mail) {
            var deferred = $q.defer();
            var filtered = $filter('filter')(getUsers(), { mail: mail });
            var user = filtered.length ? filtered[0] : null;
            deferred.resolve(user);
            return deferred.promise;
        }
 
   
        // private functions
 
        function getUsers() {
            if(!localStorage.users){
                localStorage.users = JSON.stringify([]);
            }
 
            return JSON.parse(localStorage.users);
        }
 
        function setUsers(users) {
            localStorage.users = JSON.stringify(users);
        }
    }
})();