var modulo = angular.module('aula03', []);

modulo.controller('ExemploController', function($scope) {

  $scope.nomes = ['Bernardo', 'Nunes'];


  $scope.incluir = function(novoNome){
    if($scope.meuForm.$invalid) return;
    $scope.nomes.push(novoNome);
  }

});
