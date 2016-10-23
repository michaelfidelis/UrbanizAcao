(function (angular) {
    'use strict';

    angular.module('app').service('TipoDenunciaService', TipoDenunciaService);

    TipoDenunciaService.$inject = ['$http'];

    function TipoDenunciaService($http) {
        var service = {
            listar: listar
        };
        return service;

        function listar() {
            return $http.get('http://localhost:8080/urbaniz/api/tiposdenuncia');
        }

    };
})(window.angular);
