var modulo = angular.module('aula03', []);

modulo.controller('ExemploController', function($scope) {

  $scope.nomes = ['Bernardo', 'Nunes'];

});

modulo.controller('Exemplo2', function($scope,$filter) {

  $scope.instrutores = [{
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: true,
    aula: 'OO'
  }]

  $scope.aulas = [
    'OO',
    'HTML e CSS',
    'Javascript',
    'AngularJS',
    'Banco de Dados I'
  ];

  $scope.incluir = function(){
    if($scope.meuForm.$invalid){
      let copiaDoNovoInstrutor = angular.copy($scope.novoInstrutor);
      $scope.instrutores.push(copiaDoNovoInstrutor);
      $scope.novoInstrutor = {};
    }
  }
});
