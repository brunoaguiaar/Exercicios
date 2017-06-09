let app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {

  $routeProvider
    .when('/cliente', {
      controller: 'ClienteController',
      templateUrl: 'html/cliente.html',
      // resolve: {
      //   autenticado: function (authService) {
      //     return authService.isAutenticadoPromise();
      //   }
      // }
    })
    .when('/login', {
      controller: 'LoginController',
      templateUrl: 'html/login.html'
    })
    .when('/locacao', {
      controller: 'LocacaoController',
      templateUrl: 'html/locacao.html',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .when('/relatorio', {
      controller: 'RelatorioController',
      templateUrl: 'html/relatorio.html',
      resolve: {
        autenticado: function (authService) {
          return authService.isAutenticadoPromise();
        }
      }
    })
    .otherwise({redirectTo:'/login'});
});