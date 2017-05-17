var modulo = angular.module('aula01', []);

modulo.controller('Exemplo1', function($scope, $rootScope) {
  $scope.pokemon = {
    nome: 'Bruno',
    tipo: 'Café'
  }
});

modulo.controller('Exemplo2', function($scope, $rootScope) {
  $scope.pokemon = [
  {
    nome: 'Bulbasaur',
    tipo: 'Água '
  },
  {
    nome: 'Charmander',
    tipo: 'Fogo'
  },
  {
    nome: 'Ekans',
    tipo: 'Veneno'
  }]
});
