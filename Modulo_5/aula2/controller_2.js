var modulo = angular.module('aula02', []);

modulo.controller('Exemplo1', function($scope) {
  $scope.saida = () => {
      const partesData = $scope.data.split("/");
      $scope.dataFinal = new Date(partesData[2], partesData[1] - 1, partesData[0]);
  }
});
