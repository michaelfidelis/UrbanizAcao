(function (angular) {
    'use strict';

    angular.module('app').service('TratativaService', TratativaService);

    TratativaService.$inject = ['$http'];

    function TratativaService($http) {
        var service = {
            obterPorDenuncia: obterPorDenuncia,
            salvar: salvar
        };
        return service;

        function obterPorDenuncia(denuncia) {
            return $http.get('http://localhost:8080/urbaniz/api/denuncias/' + denuncia + '/tratativas');
        }

        function salvar(tratativa) {
            return $http.post('http://localhost:8080/urbaniz/api/denuncias/' + tratativa.denuncia.codigo + '/tratativas', tratativa);
        }

    };
})(window.angular);
