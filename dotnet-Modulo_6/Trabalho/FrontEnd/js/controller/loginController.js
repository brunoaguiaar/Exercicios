angular.module('app').controller('LoginController', function ($scope, authService, $location, toastr) {

  $scope.login = function (usuario){

    if ($scope.formLogin.$valid) {
    authService.login(usuario)
      .then(
        function (response) {
          toastr.success('Login successful!');
          if(authService.isAutenticado()){
            $location.path('/menu');
          }
        },
        function (response) {
          toastr.error('Login ou Senha inválidos!');
        });
    } else {
        toastr.warning('Dados inválidos!');
    }
  };
});
