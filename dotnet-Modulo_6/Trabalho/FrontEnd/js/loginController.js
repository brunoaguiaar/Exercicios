angular.module('app').controller('LoginController', function ($scope, $rootScope, authService, $location, toastr) {

$rootScope.show = false;

if(authService.isAutenticado()){
  $location.path('/index');
}
   $scope.login = login;
   
   function login (usuario) {
    console.log("CHAMOU");

    authService.login(usuario)
      .then(
        function (response) {
          toastr.success('Login com sucesso!');

        },
        function (response) {
          toastr.error('Erro no Login!');
        });
  };

});