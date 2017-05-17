var modulo = angular.module('aula01', []);

modulo.controller('Exemplo1', function($scope, $rootScope) {
  $scope.pokemon = {
    nome: 'Bruno',
    tipo: 'Café'
  }
});
