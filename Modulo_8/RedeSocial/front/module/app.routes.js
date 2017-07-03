angular.module('app').config(function ($routeProvider) {

  $routeProvider
        .when('/login', {
        controller: 'LoginController',
        templateUrl: 'login/login.html'
        })

        .when('/feed', {
        controller: 'FeedController',
        templateUrl: 'feed/feed.html',
        resolve: {
            autenticado: function (authService) {
              return authService.isAutenticadoPromise();
            }
          }
    	  })

        .when('/perfil', {
        controller: 'PerfilController',
        templateUrl: 'perfil/perfil.html',
        resolve: {
            autenticado: function (authService) {
              return authService.isAutenticadoPromise();
            }
          }
    	  })

        .when('/amigos', {
        controller: 'AmigosController',
        templateUrl: 'amigos/amigos.html',
        resolve: {
            autenticado: function (authService) {
              return authService.isAutenticadoPromise();
            }
          }
        })

        .when('/busca', {
        controller: 'BuscaController',
        templateUrl: 'busca/busca.html',
        resolve: {
            autenticado: function (authService) {
              return authService.isAutenticadoPromise();
            }
          }
        })

        .when('/cadastro', {
        controller: 'CadastroController',
        templateUrl: 'html/cadastrarLocacao.html',
        })
        .otherwise({redirectTo:'/login'});
});
