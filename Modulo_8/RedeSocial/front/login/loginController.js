angular.module('app').controller('LoginController', function ($scope, authService, toastr) {

  // $scope.login = function (usuario){
  //
  //   if ($scope.formLogin.$valid) {
  //   authService.login(usuario)
  //     .then(
  //       function (response) {
  //         toastr.success('Login successful!');
  //         if(authService.isAutenticado()){
  //           $location.path('/feed');
  //         }
  //       },
  //       function (response) {
  //         toastr.error('Login ou Senha inválidos!');
  //       });
  //   } else {
  //       toastr.warning('Dados inválidos!');
  //   }
  // };

  $scope.login = function (usuario) {
       debugger
       authService.login(usuario)
           .then(
           function (response) {
               console.log(response);
                toastr.success('Login com sucesso!','Redirecionando');

           },
           function (response) {
               console.log(response);
               toastr.error('Erro no Login!');
           });
   };
});
