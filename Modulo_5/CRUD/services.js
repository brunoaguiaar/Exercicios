app.factory('aulaService', function () {

  let aulas = [
    { id: 0, nome: 'OO' },
    { id: 1, nome: 'HTML e CSS' }
  ];

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

  function getTodasAsAulas(params) {
    return aulas;
  };

  return {
    list: getTodasAsAulas
  }
  // $scope.showAula = (item) => {
  //   $scope.editAula = {};
  //   $scope.showEditAula = true;
  //   $scope.idAulaUpdate = aula.id;
  //   $scope.editAula.nome = aula.nome;
  // }

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
