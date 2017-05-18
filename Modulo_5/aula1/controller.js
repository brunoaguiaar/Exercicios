var modulo = angular.module('aula01', []);

modulo.controller('Exemplo1', function($scope, $rootScope) {
  $scope.pokemon = {
    nome: 'Bruno',
    tipo: 'Café'
  }
});

modulo.controller('Exemplo2', function($scope, $rootScope) {
  $scope.pokemons = [
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
  },
  {
    nome: 'Pikachu',
    tipo: 'Raio'
  },
  {
    nome: 'Wartortle',
    tipo: 'Água'
  },
  {
    nome: 'Metapod',
    tipo: 'Inseto'
  },
  {
    nome: 'Pidgey',
    tipo: 'Normal'
  },
  {
    nome: 'Vulpix',
    tipo: 'Fogo'
  },
  {
    nome: 'Meowth',
    tipo: 'Normal'
  },
  {
    nome: 'Psyduck',
    tipo: 'Água'
  }]
});
