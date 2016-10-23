(function (window) {
    angular.module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = [];

    function HomeController() {
        var self = this;
    };
})(window.angular);