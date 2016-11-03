(function (angular) {
    'use strict';

    angular.module('app').controller('DenunciaController', DenunciaController);

    DenunciaController.$inject = ['$location', '$routeParams', 'DenunciaService', 'TipoDenunciaService', 'NotificationService', 'TratativaService'];

    function DenunciaController($location, $routeParams, DenunciaService, TipoDenunciaService, NotificationService, TratativaService) {
        var self = this;
        self.denuncia = {};
        self.denuncias = [];
        self.tiposDenuncia = [];
        self.tratativa = {
            denuncia: {}
        };
        self.insercaoTratativa = false;

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

        self.obterTratativas = function () {
            TratativaService.obterPorDenuncia($routeParams.codigo).then(isSuccess, isError);

            function isSuccess(data) {
                self.denuncia.tratativas = data.data;
            }

            function isError() {
                self.denuncia.tratativas = [];
                NotificationService.adicionar('danger', 'Erro ao obter tratativas para esta denúncia.');
            }
        };

        self.inserirTratativa = function () {
            self.tratativa.denuncia.codigo = $routeParams.codigo;
            TratativaService.salvar(self.tratativa).then(isSuccess, isError);

            function isSuccess(data) {
                self.denuncia.tratativas.push(
                    angular.copy(data.data)
                );
                NotificationService.adicionar('success', 'Tratativa cadastrada com sucesso!');
                self.tratativa = {};
                self.insercaoTratativa = false;
            }

            function isError() {
                self.tratativa = {};
                NotificationService.adicionar('danger', 'Erro ao inserir tratativa para esta denúncia.');
            }
        };

        self.cancelarInsercaoTratativa = function () {
            self.tratativa = {};
            self.insercaoTratativa = false;
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
