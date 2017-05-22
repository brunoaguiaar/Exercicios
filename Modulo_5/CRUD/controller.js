var modulo = angular.module('crud', ['ngAnimate', 'toastr']);

modulo.controller('MainController', ($scope, toastr) => {
  let idAula = 0;
  let idInstrutor = 0;
  $scope.aulas = [{id: idAula++, nome: 'JAVA'},
                  {id: idAula++, nome: 'Banco I'},
                  {id: idAula++, nome: 'HTML & CSS'}];
  $scope.instrutores = [];

  $scope.addAula = () => {
    if($scope.addAula.$valid) {
      $scope.aulas.forEach(item => $scope.addAulaExiste = item.nome === $scope.novaAula.nome);
      if(!$scope.addAulaExiste){
        $scope.novaAula.id = idAula++;
        $scope.aulas.push(angular.copy($scope.novaAula));
        toastr.success('Aula inserida com sucesso.');
      } else {
        toastr.error('Aula já existente.');
      }
      $scope.novaAula = {};
    }
  }

  $scope.showAula = (item) => {
    $scope.editAula = {};
    $scope.showEditAula = true;
    $scope.idAulaUpdate = item.id;
    $scope.editAula.nome = item.nome;
  }

  $scope.editarAula = () => {
   if($scope.updateAula.$valid) {
     $scope.aulas.forEach(item => $scope.editAulaExiste = item.nome === $scope.editAula.nome);
     if(!$scope.editAulaExiste){
       $scope.aulas.forEach((item) => {
         if(item.id === Number($scope.idAulaUpdate))
           item.nome = $scope.editAula.nome;
       });
     }
     $scope.editAula = {};
     $scope.showEditAula = false;
   }
 }

 $scope.deletarAula = (id) => {
       $scope.aulaUsada = aulaJaUsada(id);
       if(!$scope.aulaUsada){
        $scope.aulas.splice(getIdIndex(id, $scope.aulas), 1);
       } else {
         toastr.error('Não é possível excluir esta aula. Aula está sendo usada.');
       }
  }
});
