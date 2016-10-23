(function (angular) {
    'use strict';

    angular.module('app').config(AppConfig);

    AppConfig.$inject = ['$routeProvider', '$locationProvider', '$httpProvider'];

    function AppConfig($routeProvider, $locationProvider, $httpProvider) {

        $locationProvider.html5Mode({
            enabled: false,
            requireBase: false
        }).hashPrefix('!');
        $routeProvider
            .when('/', {
                templateUrl: 'app/denuncia/views/denuncias.html',
                controller: 'DenunciaController',
                controllerAs: 'self',
            })
            .when('/denunciar', {
                templateUrl: 'app/denuncia/views/denunciar.html',
                controller: 'DenunciaController',
                controllerAs: 'self',
            }).when('/denuncias/:codigo', {
                templateUrl: 'app/denuncia/views/denuncia.html',
                controller: 'DenunciaController',
                controllerAs: 'self',
            })
            // caso não seja nenhum desses, redirecione para a rota '/'
            .otherwise({
                redirectTo: '/'
            });
    }
})(window.angular);
