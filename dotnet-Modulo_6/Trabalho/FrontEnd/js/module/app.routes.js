let app = angular.module('app', ['ngRoute']);

app.config(function ($routeProvider) {

  $routeProvider 
        .when('/login', {
        controller: 'LoginController',
        templateUrl: 'html/login.html'
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
        .when('/menu', { 
        controller: 'MenuController', 
        templateUrl: 'html/menu.html',
        resolve: {
            autenticado: function (authService) {
              return authService.isAutenticadoPromise();
            }
          } 
    	  })
        .when('/cadastrarCliente', {
        controller: 'CadastroClienteController',
        templateUrl: 'cadastroCliente/cadastrarCliente.html',
        resolve: {
            autenticado: function (authService) {
              return authService.isAutenticadoPromise();
            }
          }
        })
        .when('/cadastrarLocacao', {
        controller: 'CadastroLocacaoController',
        templateUrl: 'html/cadastrarLocacao.html',
        resolve: {
            autenticado: function (authService) {
              return authService.isAutenticadoPromise();
            }
          }
        })
        .otherwise({redirectTo:'/login'});
});