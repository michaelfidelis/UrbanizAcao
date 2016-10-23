(function (angular) {
    angular.module('app')
        .component('logo', {
            bindings: {
                color: '@'
            },
            restrict: 'E',
            template: `<h1 class="text-center">[<span style="background-color:{{$ctrl.color}}">urbaniz</span><strong>ação</strong>]
                    </h1>`
        });
})(window.angular);
