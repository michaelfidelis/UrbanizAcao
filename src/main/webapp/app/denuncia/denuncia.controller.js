(function (angular) {
    'use strict';

    angular.module('app').controller('DenunciaController', DenunciaController);

    DenunciaController.$inject = ['$location', '$routeParams', 'DenunciaService', 'TipoDenunciaService', 'NotificationService'];

    function DenunciaController($location, $routeParams, DenunciaService, TipoDenunciaService, NotificationService) {
        var self = this;
        self.denuncia = {};
        self.denuncias = [];
        self.tiposDenuncia = [];

        self.obterTiposDenuncia = function () {
            TipoDenunciaService.listar().then(isSuccess, isError);

            function isSuccess(data) {
                self.tiposDenuncia = data.data;
            }

            function isError() {
                self.tiposDenuncia = [];
                NotificationService.adicionar('danger', 'Erro ao obter tipos de denúncias.');
            }
        };

        self.obterDenuncias = function () {
            DenunciaService.listar().then(isSuccess, isError);

            function isSuccess(data) {
                self.denuncias = data.data;
            }

            function isError() {
                self.denuncias = [];
                NotificationService.adicionar('danger', 'Erro ao obter denúncias cadastradas.');
            }
        };

        self.salvarDenuncia = function () {
            self.denuncia.data = new Date();
            DenunciaService.salvar(self.denuncia).then(isSuccess, isError);

            function isSuccess(data) {
                $location.path("/");
                NotificationService.adicionar('success', 'Denúncia cadastrada com sucesso!');
            }

            function isError(data, status) {
                if (data.status == 400) {
                    NotificationService.adicionar('danger', data.data.message);
                } else {
                    NotificationService.adicionar('danger', 'Erro ao cadastrar denúncia!');
                }
            }
        };

        self.obterDetalhesDenuncia = function () {
            DenunciaService.obterPorCodigo($routeParams.codigo).then(isSuccess, isError);

            function isSuccess(data) {
                self.denuncia = data.data;
            }

            function isError(data, status) {
                self.voltar();
                if (data.status == 400) {
                    NotificationService.adicionar('danger', data.data.message);
                } else {
                    NotificationService.adicionar('danger', 'Erro obter detalhes da denúncia!');
                }
            }
        };

        self.voltar = function () {
            self.denuncia = {};
            $location.path("/");
        };
    };
})(window.angular);
