var modulo = angular.module('crud', ['ngRoute']);

modulo.config(function ($routeProvider) {

  $routeProvider
    .when('/livros', {
      controller: 'LivrosController',
      templateUrl: 'livros.html'
    })
    .when('/login', {
      controller: 'LoginController',
      templateUrl: 'login.html'
    })
    .when('/lancamentos', {
      controller: 'LancamentosController',
      templateUrl: 'lancamentos.html'
    })
    .otherwise({
      redirectTo: '/lancamentos'
    });
});

modulo.controller('LivrosController', function ($scope) {
  $scope.controller = 'LivrosController';
});

modulo.controller('LoginController', function ($scope) {
  $scope.controller = 'LoginController';
});

modulo.controller('LancamentosController', function ($scope){
  $scope.controller = 'LancamentosController';
});
