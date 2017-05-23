var modulo = angular.module('crud', ['ngRoute']);

modulo.config(function ($routeProvider) {

  $routeProvider
    .when('/pagina1', {
      controller: 'Pagina1Controller',
      templateUrl: 'pagina1.html'
    })
    .when('/pagina2', {
      controller: 'Pagina2Controller',
      templateUrl: 'pagina2.html'
    })
    .otherwise({
      redirectTo: '/pagina1'
    });
});

app.controller('Pagina1Controller', function ($scope) {
  $scope.controller = 'Pagina1Controller';
});

app.controller('Pagina2Controller', function ($scope) {
  $scope.controller = 'Pagina2Controller';
});
