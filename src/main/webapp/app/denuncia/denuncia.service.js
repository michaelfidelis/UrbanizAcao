(function (angular) {
    'use strict';

    angular.module('app').service('DenunciaService', DenunciaService);

    DenunciaService.$inject = ['$http'];

    function DenunciaService($http) {
        var service = {
            listar: listar,
            salvar: salvar,
            obterPorCodigo: obterPorCodigo
        };
        return service;

        function listar() {
            return $http.get('http://localhost:8080/urbaniz/api/denuncias');
        }

        function salvar(denuncia) {
            return $http.post('http://localhost:8080/urbaniz/api/denuncias', denuncia);
        }

        function obterPorCodigo(codigo) {
            return $http.get('http://localhost:8080/urbaniz/api/denuncias/' + codigo);
        }


    };
})(window.angular);
